package ie.main

import ie.main.input.KetListener
import ie.main.manager.*
import ie.main.`object`.*
import ie.main.`object`.entity.BackGroundIce
import ie.main.`object`.entity.player.Player
import ie.main.`object`.entity.player.graphics.Orbit
import ie.main.`object`.entity.player.graphics.PlayerAfterImage
import ie.main.view.IMouse
import scope.SideScrollBase;
import tss.main.`object`.ExitPopup
import java.awt.*


class Main(title : String,profileId : Int) : SideScrollBase(title,19200,10800), IMouse {
    lateinit var gm: GraphicsManager
    lateinit var world: World
    lateinit var player: Player
    lateinit var console: Console
    lateinit var exitPopup: ExitPopup
    lateinit var ketListener: KetListener
    var deltaTime : Double = 0.0
    var fpsLimit = false

    var gamePause = false

    var pizza : Boolean = false
    var antialiasing : Boolean = false

    override fun init() {
        world = World()
        player = Player(world)
        gm = GraphicsManager()
        console = Console(scopeEngine(), this)
        exitPopup = ExitPopup()
        ketListener = KetListener(this, this)
        for (i in 0..400) {
            addEntity(BackGroundIce())
        }
        addEntity(player)
        addEntity(Orbit( this,player))

        launch()
    }
    override fun update(delat: Double) {
        val dt : Double = delat / (16.0 / 1000.0)
        if (!gamePause) {
            camera.follow(player.x,player.y,0.05)
            addEntity(PlayerAfterImage(player))
        }
    }

    override fun backGroundRender(g: Graphics) {
        gm.renderBackGround(g)
        val g2 = g as Graphics2D
        if (pizza) { g2.rotate(Math.PI, 1920 / 2.0, 1080 / 2.0) }
        if (antialiasing) { g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON) }
    }

    override fun render(g : Graphics) {
        gm?.renderMap(g,world,player)

        console.render(g)

        exitPopup.render(g,"EXIT THE GAME", "ARE YOU SURE?")

        //hud test
        gm.renderHud(g,0,1000, player);

        if (gamePause) {
        gm.renderPauseScreen(g)
    }
    }

    fun esc() {
        gamePause = !gamePause
    }

    fun setHitboxRender(b : Boolean) { super.setHitBoxRender(b) }
    fun setAntiAliasing(b : Boolean) {antialiasing = b}
    override fun getVirtualMouseY(): Double {
        return super.getMouseY().toDouble()
    }

    override fun getVirtualMouseX(): Double {
        return super.getMouseX().toDouble()
    }

    fun kill() {super.exit()}
}
fun main() {
    Main("ie dev",1)
}

