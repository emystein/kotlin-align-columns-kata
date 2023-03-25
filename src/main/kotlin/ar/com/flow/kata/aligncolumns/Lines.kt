package ar.com.flow.kata.aligncolumns

object Lines {
	fun from(listOfListOfStrings: List<List<String>>): List<Line> {
		val columns = Columns.of(listOfListOfStrings)

		return listOfListOfStrings.map { lineAsListOfStrings ->
			Line.from(lineAsListOfStrings, columns)
		}
	}
}

data class Line(private val cells: List<Cell>) {
	fun alignColumns(alignment: Alignment): Line {
		val alignedCells = this.cells.map { cell -> alignment.applyTo(cell) }
		return Line(alignedCells)
	}

	fun asList(): List<String> {
		return this.cells.map { cell -> cell.value }
	}

	companion object {
		fun from(lineAsListOfString: List<String>, columns: List<Column>): Line {
			return Line(Cells.from(lineAsListOfString, columns))
		}
	}
}