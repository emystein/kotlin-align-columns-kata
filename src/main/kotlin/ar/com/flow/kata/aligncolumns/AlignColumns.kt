package ar.com.flow.kata.aligncolumns

interface ColumnAlignment {
    fun applyTo(cell: String, columnWidth: Int): String
}

class LeftAlignment: ColumnAlignment {
    override fun applyTo(cell: String, columnWidth: Int): String {
        return cell.plus(" ".repeat(columnWidth - cell.length))
    }
}

class AlignColumns(private val alignment: ColumnAlignment= LeftAlignment()) {
    fun applyTo(lines: List<List<String>>): List<List<String>> {
        val maxColumnWidths = lines.map{ line -> this.calculateMaxColumnWidthOfLine(line) }
        val maxColumnWidth = maxColumnWidths.maxOrNull() ?: 0
        return lines.map { line -> this.alignColumns(line, maxColumnWidth) }
    }

    private fun alignColumns(line: List<String>, maxColumnWidth: Int): List<String>  {
        return line.map { cell -> this.alignment.applyTo(cell, maxColumnWidth) }
    }

    private fun calculateMaxColumnWidthOfLine(line: List<String>): Int {
        return line.maxOfOrNull { cell -> cell.length } ?: 0
    }

    companion object {
        fun of(lines: List<List<String>>, alignment: ColumnAlignment= LeftAlignment()): List<List<String>> {
            val align = AlignColumns(alignment)
            return align.applyTo(lines)
        }
    }
}