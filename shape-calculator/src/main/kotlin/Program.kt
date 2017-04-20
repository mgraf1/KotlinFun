import java.io.InputStreamReader
import java.io.Reader

class Program {
    companion object {
        val FILE_PATH = "shapes.csv"

        @JvmStatic
        fun main(args: Array<String>) {
            val reader = createReader()
            val shapeFactory = createShapeFactory()

            ShapeReader().readAndProcessShapes(reader) {
                val shape = shapeFactory.create(it)
                println(shape)
            }
        }

        private fun createReader(): Reader {
            val resourceStream = Program::class.java.classLoader.getResourceAsStream(FILE_PATH)
            return InputStreamReader(resourceStream)
        }

        private fun createShapeFactory(): ShapeFactory {
            val shapeValidator = ShapeValidator()
            return ShapeFactory(shapeValidator)
        }
    }
}
