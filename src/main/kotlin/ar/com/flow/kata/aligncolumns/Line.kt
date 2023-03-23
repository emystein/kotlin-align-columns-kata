package ar.com.flow.kata.aligncolumns

class Line(private val cells: List<String>) {
    fun maxColumnWidth(): Int {
        return cells.maxOfOrNull { cell -> cell.length } ?: 0
    }

    fun alignColumns(alignment: ColumnAlignment, columnWidth: Int): List<String>  {
        return this.cells.map { cell -> alignment.applyTo(cell, columnWidth) }
    }
}