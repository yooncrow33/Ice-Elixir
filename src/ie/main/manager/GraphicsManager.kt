package ie.main.manager

import ie.main.`object`.entity.player.Player
import ie.main.`object`.World
import java.awt.*

class GraphicsManager {
    fun renderBackGround(g : Graphics) {
        g.color = Color(200,200,200)
        g.fillRect(-Int.MAX_VALUE/2, -Int.MAX_VALUE/2, Int.MAX_VALUE, Int.MAX_VALUE)
    }

    fun renderHud(g : Graphics, x : Int, y : Int, player: Player) {
        g.color = Color(40,40,40, 110)
        g.fillRect(-500, y, 5000, 80)

        //elixir
        val currentElixir : Int = player.elixir.toInt()
        for (i in 1..currentElixir) {
            g.color = when {
                i > 159 -> Color(255, 50, 40)   // 조건 1
                i > 79 -> Color(80, 230, 80)   // 조건 2
                else -> Color(240, 210, 50)    // 나머지 전부
            }
            g.fillRoundRect(x + (i*5), y+10,4,20,7,7)
        }
        // 1. 텍스트 겹침 방지 및 강조
        g.font = Font("Impact", Font.BOLD, 30)
        g.color = Color(240, 210, 50)
        g.drawString("${currentElixir}", x + 10, y + 65)

        g.font = Font("Impact", Font.PLAIN, 18) // 최대치는 좀 작게
        g.color = Color(210, 210, 210) // 최대치는 살짝 흐리게
        g.drawString(" / ${player.maxElixir}", x + 55, y + 65) // 간격을 좀 더 벌려!

        //hp
        val currentHp = player.hp.toInt()
        val maxHp = player.maxHp

        // 1. 배경 다각형 (그대로 유지)
        val hpxs = intArrayOf(x + 1650, x + 1750, x + 1950, x + 1850)
        val hpys = intArrayOf(y + 100, y - 80, y - 80, y + 100)
        g.color = Color(30, 30, 30)
        g.fillPolygon(hpxs, hpys, 4)
        g.color = Color(40,40,40, 110)
        g.fillRect(1850, y-80, 5000, 80)

        // 2. 지글지글 방지 칼각 HP 바
        // i를 1씩 올리지 말고, 엘릭서처럼 간격을 줘서 '알갱이' 느낌을 확실히 내자
        val step = 5 // 알갱이 하나당 체력 5씩 처리 (조절 가능)

        for (i in 0 until currentHp step step) {
            g.color = when {
                i < (maxHp * 0.2) -> Color(255, 30, 30)
                else -> Color(255, 70, 80)
            }

            // ratio를 정교하게 계산
            val ratio = i.toDouble() / maxHp

            // 지글거림을 방지하기 위해 좌표 계산 후 소수점 첫째자리에서 반올림 느낌으로
            val drawX = (x + 1675 + (ratio * 88)).toInt()
            val drawY = (y + 75 - (ratio * 160)).toInt()

            // 굵기를 엘릭서랑 맞추고(너비 60, 높이 3), 간격을 띄워서 지글거림을 디자인으로 승화
            g.fillRoundRect(drawX, drawY, 175, 6, 5,5)

            // Graphics2D로 캐스팅 (AWT에서 좀 더 고급진 기능을 쓰기 위해)
            val g2 = g as Graphics2D

// [Glow 로직] 알갱이 주변에 살짝 퍼지는 붉은 빛
            if (player.hp.toInt() > 80) { // 체력이 높을 때만 빛나게 해보자
                g2.color = Color(255, 30, 30, 40) // 아주 연한 빨강
                for (glowSize in 1..3) { // 3단계로 겹쳐 그리기
                    g2.fillRoundRect(drawX - glowSize, drawY - glowSize, 175 + (glowSize * 2), 6 + (glowSize * 2), 5, 5)
                }
            }

// 원래 알갱이 그리기
            g2.color = Color(255, 50, 30)
            g2.fillRoundRect(drawX, drawY, 175, 6, 5, 5)

            g.color = Color(30,30,30)
            g.fillRect(x - 5000, y + 80,100000,7000)
        }
        /*// HP 띠 위에 수치 추가 (니 식대로 살짝 얹어봐)
        g.font = Font("Impact", Font.ITALIC, 20)
        g.color = Color(255, 255, 255, 180)
        val hpPercent = (currentHp.toDouble() / maxHp * 100).toInt()
        g.drawString("CORE STABILITY: $hpPercent%", 1860, y - 50)

         */

    }


    fun renderMap(g: Graphics,world: World, player: Player) {
        val MAP_SCALE = 80

        val MINIMAP_X_START = 10
        val MINIMAP_Y_START = 10
        val MINIMAP_WIDTH: Int = world.WORLD_WIDTH / MAP_SCALE
        val MINIMAP_HEIGHT: Int = world.WORLD_HEIGHT / MAP_SCALE

        // 미니맵 배경
        g.color = Color.black
        g.fillRect(MINIMAP_X_START - 5, MINIMAP_Y_START - 5, MINIMAP_WIDTH + 10, MINIMAP_HEIGHT + 10)
        g.color = Color.white
        g.fillRect(MINIMAP_X_START, MINIMAP_Y_START, MINIMAP_WIDTH, MINIMAP_HEIGHT)

        // 플레이어 좌표 계산
        // 1. 월드 좌표를 미니맵 크기로 변환
        val scaledX: Double = player.x / MAP_SCALE
        val scaledY: Double = player.y / MAP_SCALE

        // 2. 미니맵의 중앙을 기준으로 현재 위치를 계산 (중앙 오프셋)
        val mapCenterX = MINIMAP_WIDTH / 2
        val mapCenterY = MINIMAP_HEIGHT / 2
        val playerMapX = MINIMAP_X_START + mapCenterX + scaledX.toInt()
        val playerMapY = MINIMAP_Y_START + mapCenterY + scaledY.toInt()

        // 플레이어 표시
        g.color = Color.red
        g.fillRect(playerMapX - 3, playerMapY - 3, 6, 6)
    }


    fun renderPauseScreen (g : Graphics) {
        g.color = Color(80,80,80, 170)
        g.fillRect(-Int.MAX_VALUE/2, -Int.MAX_VALUE/2, Int.MAX_VALUE, Int.MAX_VALUE)
    }
}
