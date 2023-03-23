package ar.com.flow.kata.aligncolumns

class Line(private val cells: List<String>) {
    fun maxColumnWidth(): Int {
        return this.cells.maxOfOrNull { cell -> cell.length } ?: 0
    }

    fun alignColumns(alignment: ColumnAlignment, columnWidth: Int): Line  {
        val alignedCells = this.cells.map { cell -> alignment.applyTo(cell, columnWidth) }
        return Line(alignedCells)
    }

    fun asList(): List<String> {
        return this.cells
    }
}