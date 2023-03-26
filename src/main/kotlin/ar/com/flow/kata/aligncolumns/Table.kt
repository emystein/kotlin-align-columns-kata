package ar.com.flow.kata.aligncolumns

data class Table(val lines: List<Line>, val columns: List<Column>) {
	fun isEmpty(): Boolean {
		return this.lines.isEmpty()
	}

	fun alignColumns(alignment: Alignment): Table {
		val alignedLines = this.lines.map { line -> line.alignColumns(alignment) }
		return Table(alignedLines, this.columns)
	}

	companion object {
		fun from(input: List<List<String>>): Table {
			val lines = Lines.from(input)
			val columns = Columns.ofLines(lines)
			return Table(lines, columns)
		}
	}
}
