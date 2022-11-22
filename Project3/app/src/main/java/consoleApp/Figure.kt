package consoleApp

data class Figure( val width: Int, val height: Int) {
    val area get() = width * height
}