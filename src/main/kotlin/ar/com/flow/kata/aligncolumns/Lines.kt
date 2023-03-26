package ar.com.flow.kata.aligncolumns

object Lines {
	fun from(input: List<List<String>>): List<Line> {
		val columns = Columns.from(input)
		return input.map { lineInput -> Line.from(lineInput, columns) }
	}
}

data class Line(private val values: List<String>, private val columns: List<Column>) {
	fun alignColumns(alignment: Alignment): Line {
		val alignedCells = this.columns.map { column ->
			val valueToAlign = this.valueAtColumn(column)
			alignment.applyTo(valueToAlign, column.width)
		}
		return Line(alignedCells, this.columns)
	}

	fun valueAtColumn(column: Column): String {
		return this.values.getOrNull(column.number - 1) ?: ""
	}

	fun asList(): List<String> {
		return this.values
	}

	companion object {
		fun from(input: List<String>, columns: List<Column>): Line {
			val values = columns.map { column -> input.getOrNull(column.number - 1) ?: "" }
			return Line(values, columns)
		}
	}
}