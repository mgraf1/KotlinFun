import com.opencsv.CSVReader
import java.io.Reader

class ShapeReader {

    fun readAndProcessShapes(reader: Reader, processAction: (ShapeData) -> Unit) {
        val csvReader = CSVReader(reader)
        csvReader.forEachIndexed { index, line ->
            try {
                val name = line[ShapeData.NAME_INDEX]
                val sides = line
                        .slice(ShapeData.NAME_INDEX + 1 until line.size)
                        .map(String::toDouble)
                processAction(ShapeData(name, sides))
            } catch (ex: Exception) {
                val lineAsString = line.joinToString()
                println("Error parsing csv in line: $index : $lineAsString")
            }
        }
    }
}

data class ShapeData(val name: String, val values: List<Double>) {
    companion object {
        val NAME_INDEX = 0
    }
}
