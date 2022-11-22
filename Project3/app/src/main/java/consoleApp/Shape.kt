package consoleApp

sealed interface Shape {
    class Rectangle(sideA: Int, sideB: Int) : Shape
    class Square(side: Int)

    sealed class Elipse: Shape{}

    class Circle(radius: Int): Elipse()

}