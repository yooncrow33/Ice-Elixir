package ie.main

import ie.main.input.KetListener
import ie.main.input.MouseListener
import ie.main.manager.GraphicsManager
import ie.main.manager.OptionManager
import ie.main.`object`.Console
import ie.main.`object`.World
import ie.main.`object`.entity.BackGroundIce
import ie.main.`object`.entity.bullet.Bullet
import ie.main.`object`.entity.enemy.Enemy
import ie.main.`object`.entity.player.Player
import ie.main.`object`.entity.player.graphics.PlayerAfterImage
import ie.main.view.IMouse
import scope.SideScrollBase
import scope.sideScroll.Entity
import tss.main.`object`.ExitPopup
import java.awt.Graphics
import java.awt.Graphics2D
import java.awt.RenderingHints


class Main(title : String,profileId : Int) : SideScrollBase(title,19200,10800), IMouse {
    lateinit var gm: GraphicsManager
    lateinit var world: World
    lateinit var player: Player
    lateinit var console: Console
    lateinit var exitPopup: ExitPopup
    lateinit var ketListener: KetListener
    lateinit var optionManager: OptionManager
    lateinit var mouseListener: MouseListener
    var deltaTime : Double = 0.0
    var fpsLimit = false

    var gamePause = false

    var pizza : Boolean = false
    var antialiasing : Boolean = false

    var enemies = ArrayList<Enemy>()

    override fun init() {
        world = World()
        player = Player(this)
        gm = GraphicsManager()
        console = Console(scopeEngine(), this)
        exitPopup = ExitPopup()
        ketListener = KetListener(this, this)
        optionManager = OptionManager()
        mouseListener = MouseListener(this)
        this.addMouseListener(mouseListener)
        for (i in 0..400) {
            addEntity(BackGroundIce())
        }
        addEntity(player)

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

    fun addGameEntity(e : Entity) {
        addEntity(e)
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

