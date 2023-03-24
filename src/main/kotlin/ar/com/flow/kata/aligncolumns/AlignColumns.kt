package ar.com.flow.kata.aligncolumns

class AlignColumns(private val alignment: Alignment) {
    fun applyTo(lines: List<Line>): List<Line> {
        return lines.map { line -> line.alignColumns(alignment) }
    }

    companion object {
        fun of(linesAsListOfListOfStrings: List<List<String>>, alignment: Alignment): List<List<String>> {
            val columns = Columns.of(linesAsListOfListOfStrings)

            val lines = linesAsListOfListOfStrings
                .map { lineValues -> completeLineValuesUpTotalColumns(lineValues, columns) }
                .map { lineValues -> lineValues.withIndex().map { (index, cellValue) -> Cell(cellValue, columns[index].width) } }
                .map { cells -> Line(cells) }

            // TODO: Extract output format behavior from Line
            return AlignColumns(alignment).applyTo(lines).map { line -> line.asList() }
        }

        private fun completeLineValuesUpTotalColumns(lineValues: List<String>, columns: List<Column>): List<String> {
            val missingCellCount = columns.size - lineValues.size
            return lineValues.plus(Array(missingCellCount, init = { _: Int -> "" }))
        }
    }
}
