package ar.com.flow.kata.aligncolumns

class Line(private val cells: List<Cell>) {
    fun alignColumns(alignment: Alignment): Line {
        val alignedCells = this.cells.map { cell -> alignment.applyTo(cell) }
        return Line(alignedCells)
    }

    fun asList(): List<String> {
        return this.cells.map { cell -> cell.value }
    }

    companion object {
        fun fromValues(values: List<String>, columns: List<Column>): Line {
            val cells = values.withIndex().map { (index, cellValue) -> Cell(cellValue, columns[index].width) }
            return Line(cells)
        }
    }
}