package ar.com.flow.kata.aligncolumns

object Lines {
	fun from(input: List<List<String>>): List<Line> {
		val columns = Columns.of(input)
		return input.map { lineInput -> Line.from(lineInput, columns) }
	}
}

data class Line(private val cells: List<Cell>, private val columns: List<Column>) {
	fun alignColumns(alignment: Alignment): Line {
		val alignedCells = this.columns.map { column -> this.cellAt(column.number).alignTo(alignment, column.width)}
		return Line(alignedCells, columns)
	}

	private fun cellAt(columnNumber: Int): Cell {
		return this.cells[columnNumber - 1]
	}

	fun asList(): List<String> {
		return this.cells.map { cell -> cell.value }
	}

	companion object {
		fun from(input: List<String>, columns: List<Column>): Line {
			val cells = columns.map { column ->
				val cellValue = input.getOrNull(column.number - 1) ?: ""
				Cell(cellValue, column.width)
			}
			return Line(cells, columns)
		}
	}
}