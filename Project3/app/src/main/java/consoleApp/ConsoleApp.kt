package consoleApp

fun main(){
    val a = Figure(1, 2)
    val b = Figure(3,4)
    val c = Figure(5,6)
    val figures = listOf(a,b,c)

    var totalArea = 0
    figures.forEach{
        totalArea += it.area
    }
    println("Загальна сума полів: " + totalArea)
    println("--------------------------")

    val r1 = Shape.Rectangle(4,3)
    val r2 = Shape.Rectangle(5,6)
    val s1 = Shape.Square(4)
    val s2 = Shape.Square(5)
    val s3 = Shape.Square(6)
    val c1 = Shape.Circle(2)
    val c2 = Shape.Circle(3)

    val shapes = mutableListOf(r1, r2, s1, s2, s3, c1, c2)

    var rectangles = shapes.filterIsInstance<Shape.Rectangle>().count()
    var squares = shapes.filterIsInstance<Shape.Square>().count()
    var circles = shapes.filterIsInstance<Shape.Circle>().count()
    println("Кількість трикутників: " + rectangles)
    println("Кількість квадратів: " + squares)
    println("Кількість кіл: " + circles)
    println("--------------------------")
    rectangles = 0
    squares = 0
    circles = 0

    shapes.forEach{
        when(it){
            is Shape.Rectangle -> rectangles++
            is Shape.Square -> squares++
            is Shape.Circle -> circles++

        }        }
    println("Кількість трикутників: " + rectangles)
    println("Кількість квадратів: " + squares)
    println("Кількість кіл: " + circles)
    }
