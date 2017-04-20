import com.nhaarman.mockito_kotlin.mock
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.junit.gen5.api.Assertions.assertTrue
import org.junit.gen5.api.Assertions.assertThrows

class ShapeFactorySpek: Spek({
    describe("the ShapeFactory") {
        var shapeValidator: ShapeValidator
        var shapeFactory: ShapeFactory? = null

        beforeEachTest {
            shapeValidator = mock()
            shapeFactory = ShapeFactory(shapeValidator)
        }

        on("create") {

            it("should create a Circle when passed the correct data") {
                val result = shapeFactory?.create(ShapeData("Circle", listOf(1.0)))
                assertTrue(result is Circle)
            }

            it("should create a Square when passed the correct data") {
                val result = shapeFactory?.create(ShapeData("Square", listOf(1.0)))
                assertTrue(result is Square)
            }

            it("should create a Rectangle when passed the correct data") {
                val result = shapeFactory?.create(ShapeData("Rectangle", listOf(1.0, 1.0)))
                assertTrue(result is Rectangle)
            }

            it("should create a Triangle when passed the correct data") {
                val result = shapeFactory?.create(ShapeData("Triangle", listOf(1.0, 1.0, 1.0)))
                assertTrue(result is Triangle)
            }

            it("should throw IllegalArgumentException when given unknown type") {
                val badData = ShapeData("what??", listOf(1.0))
                assertThrows(IllegalArgumentException::class.java) {
                    shapeFactory?.create(badData)
                }
            }
        }
    }
})
