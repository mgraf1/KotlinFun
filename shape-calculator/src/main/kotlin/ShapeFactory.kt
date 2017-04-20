class ShapeFactory(val shapeValidator: ShapeValidator) {

    fun create(shapeData: ShapeData): Shape {
        when (shapeData.name.toLowerCase()) {
            CIRCLE_NAME -> {
                shapeValidator.validateCircle(shapeData)
                return Circle(shapeData.name, shapeData.values[0])
            }
            RECTANGLE_NAME -> {
                shapeValidator.validateRectangle(shapeData)
                return Rectangle(shapeData.name, shapeData.values[0], shapeData.values[1])
            }
            SQUARE_NAME -> {
                shapeValidator.validateSquare(shapeData)
                return Square(shapeData.name, shapeData.values[0])
            }
            TRIANGLE_NAME -> {
                shapeValidator.validateTriangle(shapeData)
                return Triangle(shapeData.name, shapeData.values[0], shapeData.values[1], shapeData.values[2])
            }
            else ->  {
                val name = shapeData.name
                throw IllegalArgumentException("Unknown shape type: $name")
            }
        }
    }

    companion object {
        val CIRCLE_NAME = "circle"
        val SQUARE_NAME = "square"
        val RECTANGLE_NAME = "rectangle"
        val TRIANGLE_NAME = "triangle"
    }
}
