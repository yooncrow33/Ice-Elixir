package ie.main

import ie.main.graphics.BackGroundIce
import ie.main.input.KetListener
import ie.main.manager.*
import ie.main.`object`.*
import scope.Base
import tss.main.`object`.ExitPopup
import java.awt.*

class Main(title : String,profileId : Int) : Base(title) {
    val gm : GraphicsManager = GraphicsManager()
    val console : Console by lazy { Console(scopeEngine(), this) }
    val ketListener  : KetListener = KetListener(this,this)
    val exitPopup : ExitPopup = ExitPopup()
    val world : World = World()
    var deltaTime : Double = 0.0

    var pause = true

    var pizza : Boolean = false

    val backGroundIces = List(400) {
        BackGroundIce()
    }

    override fun init() {

    }
    override fun update(delat: Double) {
        val dt : Double = delat / (16.0 / 1000.0)
        if (pause) {
        world.update(dt)
    }

    }
    override fun render(g : Graphics) {
        val g2 = g as Graphics2D
        if (pizza) {
            g2.rotate(Math.PI, 1920 / 2.0, 1080 / 2.0)
        }
        gm.renderBackGround(g)
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON)

        for (i in backGroundIces) {
            if (i.isVisibleToPlayer(world.player)) i.renderIce(g, world.player)
        }

        //hud test
        gm.renderHud(g,0,1000, world.player);

        console.render(g)

        exitPopup.render(g,"EXIT THE GAME", "ARE YOU SURE?")
    }

    fun esc() {

    }
}
fun main() {
    Main("ie dev",1)
}

