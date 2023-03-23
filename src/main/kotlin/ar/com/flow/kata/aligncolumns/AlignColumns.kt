package ar.com.flow.kata.aligncolumns

interface ColumnAlignment {
    fun applyTo(cell: String, columnWidth: Int): String
}

class LeftAlignment: ColumnAlignment {
    override fun applyTo(cell: String, columnWidth: Int): String {
        return cell.plus(" ".repeat(columnWidth - cell.length))
    }
}

class AlignColumns(private val alignment: ColumnAlignment) {
    fun applyTo(lineStrings: List<List<String>>): List<List<String>> {
        val lines = lineStrings.map{ Line(it) }
        val maxColumnWidth = lines.maxOfOrNull { it.maxColumnWidth() } ?: 0
        return lines.map{ it.alignColumns(alignment, maxColumnWidth) }
    }

    companion object {
        fun of(lines: List<List<String>>, alignment: ColumnAlignment = LeftAlignment()): List<List<String>> {
            return AlignColumns(alignment).applyTo(lines)
        }
    }
}

class Line(private val cells: List<String>) {
    fun maxColumnWidth(): Int {
        return cells.maxOfOrNull { cell -> cell.length } ?: 0
    }

    fun alignColumns(alignment: ColumnAlignment, columnWidth: Int): List<String>  {
        return this.cells.map { cell -> alignment.applyTo(cell, columnWidth) }
    }
}