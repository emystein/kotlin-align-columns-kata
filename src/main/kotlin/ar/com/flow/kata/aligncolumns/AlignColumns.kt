package ar.com.flow.kata.aligncolumns

class AlignColumns(private val alignment: ColumnAlignment) {
    fun applyTo(lines: List<Line>): List<Line> {
        return lines.map{ line -> line.alignColumns(alignment, columnWidth = maxColumnWidth(lines)) }
    }

    private fun maxColumnWidth(lines: List<Line>): Int {
        return lines.maxOfOrNull { line -> line.maxColumnWidth() } ?: 0
    }

    companion object {
        fun of(lineStrings: List<List<String>>, alignment: ColumnAlignment): List<List<String>> {
            val lines = lineStrings.map{ cells -> Line(cells) }

            // TODO: Extract output format behavior from Line
            return AlignColumns(alignment).applyTo(lines).map { line -> line.asList() }
        }
    }
}
