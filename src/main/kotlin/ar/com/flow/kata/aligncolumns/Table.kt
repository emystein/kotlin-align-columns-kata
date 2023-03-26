package ar.com.flow.kata.aligncolumns

data class Table(val lines: List<Line>, val columns: List<Column>) {
	fun isEmpty(): Boolean {
		return this.lines.isEmpty()
	}

	fun alignColumns(alignment: Alignment): Table {
		val alignedLines = this.lines.map { it.alignColumns(alignment) }
		return Table(alignedLines, this.columns)
	}

	companion object {
		fun from(input: List<List<String>>): Table {
			return Table(Lines.from(input), Columns.from(input))
		}
	}
}
