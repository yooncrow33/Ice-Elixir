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

    var elixir = 200
    val maxElixir = 100
    var hp = 100
    val maxHp = 100

    var x: Double = 0.0
    var y: Double = 0.0

    fun update(dt : Double) {
        if (moveUp) { y -= PLAYER_MOVE_SPEED * dt }
        if (moveDown) { y += PLAYER_MOVE_SPEED * dt }
        if (moveLeft) { x -= PLAYER_MOVE_SPEED * dt }
        if (moveRight) { x += PLAYER_MOVE_SPEED * dt }
        checkBound()
    }

    fun useWeapon() {

    }

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

    fun setTrueMoveUp() { moveUp = true }
    fun setTrueMoveLeft() { moveLeft = true }
    fun setTrueMoveDown() { moveDown = true }
    fun setTrueMoveRight() { moveRight = true }
    fun setFalseMoveUp() { moveUp = false }
    fun setFalseMoveLeft() { moveLeft = false }
    fun setFalseMoveDown() { moveDown = false }
    fun setFalseMoveRight() { moveRight = false }}
