import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.gen5.api.Assertions.assertEquals
import java.io.StringReader

/**
 * Created by Graf on 4/16/2017.
 */
class ShapeReaderSpek: Spek({

    describe("the ShapeReader") {

        it("calls the process action on all valid lines") {
            val validCsvLines = """|Circle,5
                                   |Square,3
                                   |Triangle,1,2,3
                                   |Rectangle,3,6""".trimMargin()
            val reader = StringReader(validCsvLines)
            var callCount = 0

            ShapeReader().readAndProcessShapes(reader) {
                callCount++
            }

            assertEquals(4, callCount)
        }

        it("does not call the process action on invalid lines") {
            val validAndInvalidCsvLines = """|Circle,5
                                             |Square,3,bad!
                                             |Triangle,1,hello,3
                                             |Rectangle,3,6""".trimMargin()
            val reader = StringReader(validAndInvalidCsvLines)
            var callCount = 0

            ShapeReader().readAndProcessShapes(reader) {
                callCount++
            }

            assertEquals(2, callCount)
        }
    }
})
