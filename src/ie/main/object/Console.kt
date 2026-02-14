package ie.main.`object`

import scope.internal.facade.Access.ScopeEngineAccess
import ie.main.Main
import java.awt.*
import java.util.*
import kotlin.math.max

class Console(var scopeEngine: ScopeEngineAccess, var main: Main) {
    var isOpen: Boolean = false
        private set
    private val buffer = StringBuilder()
    private val logs = ArrayList<String>()

    // 스크롤 처리를 위한 변수 (로그가 많아지면 위로 밀리게)
    private val MAX_LINES = 10

    val help = Help()

    init {
        logs.add("[Console] Try 'help' for more information")
    }

    fun toggle() {
        isOpen = !isOpen
    }

    // ★ 핵심: 키보드 입력을 받아먹는 함수
    fun inputKey(key: Char, code: Int) {
        if (!isOpen) return

        if (code == 10) { // Enter Key Code
            execute()
        } else if (code == 8) { // Backspace
            if (buffer.isNotEmpty()) {
                buffer.deleteCharAt(buffer.length - 1)
            }
        } else {
            // 특수문자나 이상한 거 제외하고 출력 가능한 것만 받음
            // (자바 char는 유니코드라 한글도 됨)
            if (key.code in 32..126) {
                buffer.append(key)
            }
        }
    }

    private fun execute() {
        val input = buffer.toString().trim()
        if (input.isEmpty()) return

        logs.add("[${String.format("%tT", System.currentTimeMillis())}] root: $input")

        val args = input.split(" ")
        val cmd = args[0].lowercase()

        // if-else if 대신 when을 쓰면 줄 맞춤이 편해져요
        when (cmd) {
            "help" -> help.setVisible()
            "clear" -> logs.clear()
            "close" -> isOpen = false;
            "exit" -> {this.isOpen=false; main.exitPopup.setVisible()}
            "pizza" -> {
                main.pizza = !main.pizza // if-else 대신 반전(!) 하나로 끝
                logs.add("[System] Is very good.")
            }
            "set" -> {
                if (args.size == 4) handleSet(args)
                else logs.add("[Console] Usage: set [type] [name] [value]")
            }
            else -> { logs.add("[Console] Error: Unknown command: $cmd"); logs.add("[Console] Try 'help' for more information") }
        }
        buffer.setLength(0)
    }

    private fun handleSet(args: List<String>) {
        val (_, type, target, valueStr) = args
        val value = valueStr.toIntOrNull() ?: 0

        if (type == "val") {
            if (target.startsWith("setting")) {
                /*val num = target.replace("setting", "").toIntOrNull() ?: 0
                if (num !in 1..<5) {
                    logs.add("[Console] Error: No found setting")
                    return;
                }
                // 여기서 핵심! 인덱스별로 범위를 다르게 체크
                val isValid = when (num) {
                    2 -> value in 0..4        // setting2는 상남자답게 0~4 허용
                    1, 3, 4, 5 -> value in 0..2 // 나머지는 0~2만
                    else -> false             // setting6 같은 건 바로 컷
                }
                if (isValid) {
                    main.settingManager.setSettingIndex(num - 1, value)
                    logs.add("[System] $target set to $value")
                } else {
                    logs.add("[Console] Error: Value $value is out of range for $target")
                }

                 */
            } else if (target == "elixir") {
                // 여기서 핵심! 인덱스별로 범위를 다르게 체크
                val isValid = valueStr.toIntOrNull() in 0..100
                if (isValid) {
                    main.world.player.elixir = valueStr.toIntOrNull()!!
                    logs.add("[System] $target set to $value")
                } else {
                    logs.add("[Console] Error: Value $value is out of range for $target")
                }
            }  else if (target == "hp") {
                // 여기서 핵심! 인덱스별로 범위를 다르게 체크
                val isValid = valueStr.toIntOrNull() in 0..100
                if (isValid) {
                    main.world.player.hp = valueStr.toIntOrNull()!!
                    logs.add("[System] $target set to $value")
                } else {
                    logs.add("[Console] Error: Value $value is out of range for $target")
                }
            }

        } else if (type == "bool") {
            /*val valueBool = valueStr.toBooleanStrictOrNull()
            if (valueBool == null) { logs.add("[Console] Error: Not boolean value"); return}

            when (target) {
            "screenchangeeffect" -> { main.getShutter().setScreenEffect(valueBool); logs.add("[System] $target set to $valueBool") }
            }

            */
            }
    }

        fun render(g: Graphics) {
        if (!isOpen) return
        val g2 = g as Graphics2D

        // 1. 배경 (아주 어두운 네이비 반투명)
        g2.setColor(Color(30, 30, 30, 245))
        g2.fillRect(0, 0, 1920, 340)

        // 2. 하단 구분선 (Ice Blue 포인트)
        g2.setColor(Color(190,190,190))
        g2.setStroke(BasicStroke(3f))
        g2.drawLine(0, 340, 1920, 340)

        // [Left Zone] 명령어 로그
        g2.setFont(Font("Consolas", Font.PLAIN, 16))
        val lineHeight = 25
        val startY = 40
        val startIndex = max(0, logs.size - MAX_LINES)
        var lineCount = 0

        for (i in startIndex..<logs.size) {
        val line = logs[i]

        // 컬러 코딩 변경
        when {
        line.contains("Error") -> g2.setColor(Color(255, 30, 30)) // 에러는 여전히 붉은계열이 좋음
        line.contains("root:") -> g2.setColor(Color(210, 210, 210)) // Me: 연한 블루
        line.contains("[System]") -> g2.setColor(Color(40, 255, 20)) // System: 민트/그린 계열
        else -> g2.setColor(Color(160, 160, 160)) // Others: 블루 그레이
        }

        g2.drawString(line, 30, startY + (lineCount * lineHeight))
        lineCount++
        }

        // [Input Line]
        g2.setColor(Color(190,190,190)) // 입력 프롬프트 Ice Blue
        g2.setFont(Font("Consolas", Font.BOLD, 18))
        val cursor = if (System.currentTimeMillis() % 1000 > 300) "_" else ""
        g2.drawString("root@ie:~$ $buffer$cursor", 30, 320)

        // [Right Zone] 시스템 모니터
        g2.color = Color(20,20,20) // 구분선도 블루 그레이로
        g2.drawLine(1500, 20, 1500, 320)

        g2.setFont(Font("Impact", Font.PLAIN, 24))
        g2.setColor(Color(220,220,220)) // 헤더
        g2.drawString("SYSTEM STATUS", 1520, 60)

        var y = 100
        drawStat(g2, "FPS", "60 (Fixed)", Color(140,140,140), 1520, y)
        y += 30
        drawStat(g2, "MEMORY", "${scopeEngine.system().usedMemory}MB / ${scopeEngine.system().totalMemory}MB", Color(140,140,140), 1520, y)
        y += 30
        drawStat(g2, "THREADS", "${Thread.activeCount()} Active", Color(140,140,140), 1520, y)
        y += 30
        drawStat(g2, "CPU", "${scopeEngine.system().cpuPercentage}%", Color(140,140,140), 1520, y)

        // 하단 로고
        g2.setColor(Color(35, 35, 35))
        g2.setFont(Font("Impact", Font.ITALIC, 40))
        g2.drawString("IE CONSOLE", 1530, 300)
        }

        // 모니터링용 헬퍼 함수
        private fun drawStat(g: Graphics2D, label: String?, value: String?, valColor: Color?, x: Int, y: Int) {
        g.color = Color(160,160,160)
        g.drawString(label, x, y)
        g.color = valColor
        g.drawString(value, x + 120, y)
        }
    }