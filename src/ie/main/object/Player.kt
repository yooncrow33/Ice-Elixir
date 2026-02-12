package ie.main.`object`

class Player {
    var moveUp: Boolean = false
    var moveLeft: Boolean = false
    var moveDown: Boolean = false
    var moveRight: Boolean = false

    val PLAYER_WIDTH: Int = 30
    val PLAYER_HEIGHT: Int = 30

    val PLAYER_MOVE_SPEED: Int = 10

    val weaponDistance: IntArray = intArrayOf(120, 200, 400, 600)
    var weapon: Int = 0

    var stop: Boolean = false

    var x: Double = 0.0
    var y: Double = 0.0
}
