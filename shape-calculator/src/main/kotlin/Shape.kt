abstract class Shape(val name: String) {
    abstract val perimeter: Double
    abstract val area: Double

    override fun toString(): String {
        return "Name: $name | Perimeter: $perimeter | Area: $area"
    }
}

class Circle(name:String, private val radius: Double) : Shape(name) {
    override val perimeter: Double
        get() = 2 * Math.PI * radius

    override val area: Double
        get() = Math.PI * radius * radius
}

open class Rectangle(name: String, private val width: Double, private val height: Double) : Shape(name) {
    override val perimeter: Double
        get() = (2 * width) +  (2 * height)

    override val area: Double
        get() = width * height
}

class Square(name: String, sideLength: Double) : Rectangle(name, sideLength, sideLength)

class Triangle(
        name: String,
        private val sideLengthA: Double,
        private val sideLengthB: Double,
        private val sideLengthC: Double) : Shape(name) {

    override val perimeter: Double
        get() = sideLengthA + sideLengthB + sideLengthC

    override val area: Double
        get() = heronsFormula(sideLengthA, sideLengthB, sideLengthC)

    private fun heronsFormula(a: Double, b: Double, c: Double): Double {
        val semiPerimeter = perimeter / 2
        val semiPerimeterSideProduct =
                semiPerimeter * (semiPerimeter - a) * (semiPerimeter - b) * (semiPerimeter - c)

        return Math.sqrt(semiPerimeterSideProduct)
    }
}
