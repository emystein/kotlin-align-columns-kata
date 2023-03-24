package ar.com.flow.kata.aligncolumns

class AlignColumns(private val alignment: Alignment) {
    fun applyTo(lines: List<Line>): List<Line> {
        return lines.map { line -> line.alignColumns(alignment) }
    }

    companion object {
        fun of(lineStrings: List<List<String>>, alignment: Alignment): List<List<String>> {
            val columns = Columns.of(lineStrings)

            val lines = lineStrings
                .map { line -> completeCellsUpToSize(line, columns.size) }
                .map { line -> Line.fromValues(line, columns) }

            // TODO: Extract output format behavior from Line
            return AlignColumns(alignment).applyTo(lines).map { line -> line.asList() }
        }

        private fun completeCellsUpToSize(cells: List<String>, totalCellCount: Int): List<String> {
            val missingCellCount = totalCellCount - cells.size
            return cells.plus(Array(missingCellCount, init = { _: Int -> "" }))
        }
    }
}
