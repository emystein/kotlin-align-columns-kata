package ar.com.flow.kata.aligncolumns

data class Table(val lines: List<Line>, val columns: List<Column>) {
	fun isEmpty(): Boolean {
		return this.lines.isEmpty()
	}

	companion object {
		fun from(input: List<List<String>>): Table {
			val lines = Lines.from(input)
			val columns = Columns.ofLines(lines)
			return Table(lines, columns)
		}

		fun fromLines(lines: List<Line>): Table {
			val columns = Columns.ofLines(lines)
			return Table(lines, columns)
		}
	}
}
