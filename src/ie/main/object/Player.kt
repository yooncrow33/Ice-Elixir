package ie.main.`object`

class Player(val world: World) {
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

    fun checkBound() {
        if (x > world.MAN_X) {
            x = world.MAN_X
        } else if (x < world.MIN_X) {
            x = world.MIN_X
        }

        if (y > world.MAX_Y) {
            y = world.MAX_Y
        } else if (y < world.MIN_Y) {
            y = world.MIN_Y
        }
    }
}
