package ie.main

import ie.main.input.KetListener
import scope.Base
import java.awt.*
import ie.main.`object`.*
import ie.main.manager.*
import tss.main.`object`.ExitPopup

class Main(title : String,profileId : Int) : Base(title) {
    val gm : GraphicsManager = GraphicsManager()
    val console : Console by lazy { Console(scopeEngine(), this) }
    val ketListener  : KetListener = KetListener(this,this)
    val exitPopup : ExitPopup = ExitPopup()

    var pause = false;

    var pizza : Boolean = false

    override fun init() {

    }
    override fun update(dt: Double) {
    if (pause) {

    }
    }
    override fun render(g : Graphics) {
        val g2 = g as Graphics2D
        if (pizza) {
            g2.rotate(Math.PI, 1920 / 2.0, 1080 / 2.0)
        }
        gm.renderBackGround(g)
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON)
        g.color = Color(20,20,20)
        g.fillRect(400,680, 400,400)
        g.fillRect(400,880,1120,200)

        console.render(g)

        exitPopup.render(g,"EXIT THE GAME", "ARE YOU SURE?")
    }

    fun esc() {

    }
}
fun main() {
    Main("ie dev",1)
}

