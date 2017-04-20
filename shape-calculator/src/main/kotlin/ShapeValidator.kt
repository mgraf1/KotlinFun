@TestOpen
class ShapeValidator {

    fun validateCircle(shapeData: ShapeData) {
        if (!valuesAreCorrectLengthAndPositive(shapeData, 1)) {
            throw ShapeValidationException("Circle is not valid")
        }
    }

    fun validateRectangle(shapeData: ShapeData) {
        if (!valuesAreCorrectLengthAndPositive(shapeData, 2)) {
            throw ShapeValidationException("Rectangle is not valid")
        }
    }

    fun validateSquare(shapeData: ShapeData) {
        if (!valuesAreCorrectLengthAndPositive(shapeData, 1)) {
            throw ShapeValidationException("Square is not valid")
        }
    }

    fun validateTriangle(shapeData: ShapeData) {
        if (!valuesAreCorrectLengthAndPositive(shapeData, 3)) {
            throw ShapeValidationException("Triangle is not valid")
        }
    }

    private fun valuesAreCorrectLengthAndPositive(shapeData: ShapeData, length: Int): Boolean {
        return shapeData.values.size == length && shapeData.values.all { it > 0 }
    }
}
