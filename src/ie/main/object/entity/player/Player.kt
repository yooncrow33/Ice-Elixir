package ie.main.`object`.entity.player

import ie.main.`object`.World
import ie.main.Main;
import ie.main.`object`.entity.player.graphics.Orbit
import ie.main.`object`.weapon.Gun
import scope.sideScroll.Entity
import java.awt.Color
import java.awt.Graphics

class Player(val main: Main) : Entity(15, 0.0,0.0,true,true,0,) {
    var moveUp: Boolean = false
    var moveLeft: Boolean = false
    var moveDown: Boolean = false
    var moveRight: Boolean = false

    val PLAYER_WIDTH: Int = 30
    val PLAYER_HEIGHT: Int = 30

    val PLAYER_MOVE_SPEED: Int = 10

    val weaponDistance: IntArray = intArrayOf(120, 200, 400, 600)
    var weapon: Int = 0


    var elixir: Double = 20.0
    val maxElixir = 200
    var hp : Double = 100.0
    val maxHp = 100

    var takeItem : Boolean = false;

    val orbit : Orbit = Orbit(main,this)

    var gun : Gun = Gun(main,this)


    init {
        main.addGameEntity(orbit)
    }

    override fun update(delta : Double) {
        val dt : Double = delta / (16.0 / 1000.0)
        if (moveUp) { addY(- PLAYER_MOVE_SPEED * dt) }
        if (moveDown) { addY(+ PLAYER_MOVE_SPEED * dt) }
        if (moveLeft) { addX(- PLAYER_MOVE_SPEED * dt) }
        if (moveRight) { addX(+ PLAYER_MOVE_SPEED * dt) }

        if (elixir >= 200) {elixir = maxElixir.toDouble()} else { elixir += 0.3 }
        if (hp >= maxHp) {hp = maxHp.toDouble() } else { hp += 0.1 }
    }

    override fun render(g: Graphics, x: Double, y: Double) {
        g.color = Color.black
        g.fillOval((x - PLAYER_WIDTH/2).toInt(), (y - PLAYER_HEIGHT/2).toInt(), PLAYER_WIDTH,PLAYER_HEIGHT)
    }

    fun shot() {

    }

    fun useWeapon() {

    }



    fun setTrueMoveUp() { moveUp = true }
    fun setTrueMoveLeft() { moveLeft = true }
    fun setTrueMoveDown() { moveDown = true }
    fun setTrueMoveRight() { moveRight = true }
    fun setFalseMoveUp() { moveUp = false }
    fun setFalseMoveLeft() { moveLeft = false }
    fun setFalseMoveDown() { moveDown = false }
    fun setFalseMoveRight() { moveRight = false }}
