import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.junit.gen5.api.Assertions.assertThrows

class ShapeValidatorSpek: Spek({
    describe("the ShapeValidator") {
        val validator = ShapeValidator()

        on("validateCircle") {

            it("does not throw when ShapeData is valid") {
                val validCircleData = ShapeData("Circle", listOf(1.0))
                validator.validateCircle(validCircleData)
            }

            it("throws ShapeValidationException when ShapeData.values is wrong length") {
                val invalidCircleData = ShapeData("Circle", listOf(1.0, 2.0))
                assertThrows(ShapeValidationException::class.java) {
                    validator.validateCircle(invalidCircleData)
                }
            }

            it("throws ShapeValidationException when value is negative") {
                val invalidCircleData = ShapeData("Circle", listOf(-1.0))
                assertThrows(ShapeValidationException::class.java) {
                    validator.validateCircle(invalidCircleData)
                }
            }

            it("throws ShapeValidationException when value is zero") {
                val invalidCircleData = ShapeData("Circle", listOf(0.0))
                assertThrows(ShapeValidationException::class.java) {
                    validator.validateCircle(invalidCircleData)
                }
            }
        }

        on("validateSquare") {

            it("does not throw when ShapeData is valid") {
                val validSquareData = ShapeData("Square", listOf(1.0))
                validator.validateSquare(validSquareData)
            }

            it("throws ShapeValidationException when ShapeData.values is wrong length") {
                val invalidSquareData = ShapeData("Square", listOf(1.0, 2.0))
                assertThrows(ShapeValidationException::class.java) {
                    validator.validateSquare(invalidSquareData)
                }
            }

            it("throws ShapeValidationException when value is negative") {
                val invalidSquareData = ShapeData("Square", listOf(-1.0))
                assertThrows(ShapeValidationException::class.java) {
                    validator.validateSquare(invalidSquareData)
                }
            }

            it("throws ShapeValidationException when value is zero") {
                val invalidSquareData = ShapeData("Square", listOf(0.0))
                assertThrows(ShapeValidationException::class.java) {
                    validator.validateSquare(invalidSquareData)
                }
            }
        }

        on("validateRectangle") {

            it("does not throw when ShapeData is valid") {
                val validRectangleData = ShapeData("Rectangle", listOf(1.0, 2.0))
                validator.validateRectangle(validRectangleData)
            }

            it("throws ShapeValidationException when ShapeData.values is wrong length") {
                val invalidRectangleData = ShapeData("Rectangle", listOf(1.0))
                assertThrows(ShapeValidationException::class.java) {
                    validator.validateRectangle(invalidRectangleData)
                }
            }

            it("throws ShapeValidationException when value is negative") {
                val invalidRectangleData = ShapeData("Rectangle", listOf(-1.0, 3.0))
                assertThrows(ShapeValidationException::class.java) {
                    validator.validateRectangle(invalidRectangleData)
                }
            }

            it("throws ShapeValidationException when value is zero") {
                val invalidRectangleData = ShapeData("Rectangle", listOf(4.0, 0.0))
                assertThrows(ShapeValidationException::class.java) {
                    validator.validateRectangle(invalidRectangleData)
                }
            }
        }

        on("validateTriangle") {

            it("does not throw when ShapeData is valid") {
                val validTriangleData = ShapeData("Triangle", listOf(1.0, 2.0, 3.0))
                validator.validateTriangle(validTriangleData)
            }

            it("throws ShapeValidationException when ShapeData.values is wrong length") {
                val invalidTriangleData = ShapeData("Triangle", listOf(1.0, 2.1))
                assertThrows(ShapeValidationException::class.java) {
                    validator.validateTriangle(invalidTriangleData)
                }
            }

            it("throws ShapeValidationException when value is negative") {
                val invalidTriangleData = ShapeData("Triangle", listOf(1.0, -3.0, 4.0))
                assertThrows(ShapeValidationException::class.java) {
                    validator.validateTriangle(invalidTriangleData)
                }
            }

            it("throws ShapeValidationException when value is zero") {
                val invalidTriangleData = ShapeData("Triangle", listOf(4.0, 0.0, 2.2))
                assertThrows(ShapeValidationException::class.java) {
                    validator.validateTriangle(invalidTriangleData)
                }
            }
        }
    }
})
