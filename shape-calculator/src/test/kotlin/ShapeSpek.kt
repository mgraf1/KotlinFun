import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.junit.gen5.api.Assertions.assertEquals
import org.junit.gen5.api.Assertions.assertTrue

class ShapeSpek: Spek({
    describe("A Circle") {
        val circle = Circle("Circle", 5.0)

        on("perimeter") {
            val perimeter = circle.perimeter

            it("should return the circumference of the circle") {
                assertTrue(Math.abs(31.415927 - perimeter) <= .01)
            }
        }

        on("area") {
            val area = circle.area

            it("should return the area of the circle") {
                assertTrue(Math.abs(78.53975 - area) <= .01)
            }
        }
    }

    describe("A Square") {
        val square = Square("Square", 5.0)

        on("perimeter") {
            val perimeter = square.perimeter

            it("should return the perimeter of the square") {
                assertEquals(20.0, perimeter)
            }
        }

        on("area") {
            val area = square.area

            it("should return the area of the square") {
                assertEquals(25.0, area)
            }
        }
    }

    describe("A Rectangle") {
        val rectangle = Rectangle("Rectangle", 5.0, 3.0)

        on("perimeter") {
            val perimeter = rectangle.perimeter

            it("should return the perimeter of the rectangle") {
                assertEquals(16.0, perimeter)
            }
        }

        on("area") {
            val area = rectangle.area

            it("should return the area of the rectangle") {
                assertEquals(15.0, area)
            }
        }
    }

    describe("A Triangle") {
        val triangle = Triangle("Triangle", 4.0, 3.0, 5.0)

        on("perimeter") {
            val perimeter = triangle.perimeter

            it("should return the perimeter of the triangle") {
                assertEquals(12.0, perimeter)
            }
        }

        on("area") {
            val area = triangle.area

            it("should return the area of the triangle") {
                assertEquals(6.0, area)
            }
        }
    }
})
