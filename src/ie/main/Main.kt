package ie.main

import ie.main.`object`.entity.BackGroundIce
import ie.main.input.KetListener
import ie.main.manager.*
import ie.main.`object`.*
import scope.SideScrollBase
import tss.main.`object`.ExitPopup
import java.awt.*

class Main(title : String,profileId : Int) : SideScrollBase(title,19200,10800) {
    val gm : GraphicsManager = GraphicsManager()
    val console : Console by lazy { Console(scopeEngine(), this) }
    val ketListener  : KetListener = KetListener(this,this)
    val exitPopup : ExitPopup = ExitPopup()
    val world : World = World()
    var deltaTime : Double = 0.0
    var fpsLimit = false

    var pause = true

    var pizza : Boolean = false

    override fun init() {
        for (i in 0..400) {
            addEntity(BackGroundIce())
        }
    }
    override fun update(delat: Double) {
        val dt : Double = delat / (16.0 / 1000.0)
        if (pause) {
            world.update(dt)
            camera.follow(world.player.x,world.player.y,0.05)
            //println(camera.x)
            //println(".")
            //println(camera.y)
        }
    }

    override fun backGroundRender(g: Graphics) {
        gm.renderBackGround(g)
    }

    override fun render(g : Graphics) {
        val g2 = g as Graphics2D
        if (pizza) {
            g2.rotate(Math.PI, 1920 / 2.0, 1080 / 2.0)
        }

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON)

        console.render(g)

        exitPopup.render(g,"EXIT THE GAME", "ARE YOU SURE?")

        //hud test
        //gm.renderHud(g,0,1000, world.player);
    }

    fun esc() {

    }

    fun setHitboxRender(b : Boolean) {
        super.setHitBoxRender(b)
    }
}
fun main() {
    Main("ie dev",1)
}

