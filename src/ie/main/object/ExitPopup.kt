package tss.main.`object`

import java.awt.Color
import java.awt.Font
import java.awt.Graphics

class ExitPopup() {
    var isVisible: Boolean = false
    var isYesSelected: Boolean = false

    fun setVisible() {
        isYesSelected = false
        this.isVisible = true
    }

    fun select() {
        this.isVisible = false
        if (isYesSelected) {
            System.exit(0)
        }
    }

    fun move() {
        this.isYesSelected = !this.isYesSelected;
    }

    fun render(g: Graphics, message: String, title: String) {
        if (!this.isVisible) return

        // 1. 백그라운드 딤(Dimming) 효과 - 약간 푸른빛이 도는 어둠
        g.setColor(Color(10, 20, 30, 200))
        g.fillRect(-2000, -2000, 60000, 6000)

        val pWidth = 500
        val pHeight = 250
        val px = (1920 - pWidth) / 2
        val py = (1080 - pHeight) / 2

        // 2. 팝업 박스 설정 - 딥 네이비 배경
        g.setColor(Color(25, 35, 50))
        g.fillRect(px, py, pWidth, pHeight)

        // 상단 바 - Ice Blue 포인트
        g.setColor(Color(100, 200, 255))
        g.fillRect(px, py, pWidth, 5)

        // 테두리 - 차가운 블루 그레이
        g.setColor(Color(70, 100, 130))
        g.drawRect(px, py, pWidth, pHeight)

        // 3. 텍스트 렌더링
        g.setColor(Color(130, 220, 255)) // 타이틀: 밝은 아이스 블루
        g.setFont(Font("Impact", Font.BOLD, 32))
        g.drawString(title, px + 30, py + 50)

        g.setColor(Color(220, 240, 255)) // 본문: 아주 연한 푸른 흰색
        g.setFont(Font("Dialog", Font.BOLD, 18))
        g.drawString(message, px + 35, py + 100)

        // 4. 버튼 영역
        val btnWidth = 180
        val btnHeight = 50
        val btnY = py + 160

        // [ABORT] 버튼 (Yes 역할)
        if (isYesSelected) {
            g.setColor(Color(0, 150, 255)) // 활성화 시 진한 하늘색
            g.fillRect(px + 40, btnY, btnWidth, btnHeight)
            g.setColor(Color.WHITE)
        } else {
            g.setColor(Color(60, 80, 100))
            g.drawRect(px + 40, btnY, btnWidth, btnHeight)
        }
        g.setFont(Font("Impact", Font.PLAIN, 24))
        g.drawString("ABORT", px + 97, btnY + 33)

        // [CONTINUE] 버튼 (No 역할)
        if (!isYesSelected) {
            g.setColor(Color(180, 230, 255)) // 활성화 시 밝은 아이스 블루
            g.fillRect(px + 280, btnY, btnWidth, btnHeight)
            g.setColor(Color(20, 30, 50)) // 텍스트는 어둡게 반전
        } else {
            g.setColor(Color(60, 80, 100))
            g.drawRect(px + 280, btnY, btnWidth, btnHeight)
        }
        g.setFont(Font("Impact", Font.PLAIN, 24))
        g.drawString("CONTINUE", px + 322, btnY + 33)
    }
}