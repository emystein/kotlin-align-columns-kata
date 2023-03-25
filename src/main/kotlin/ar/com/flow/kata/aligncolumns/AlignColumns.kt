package ar.com.flow.kata.aligncolumns

class AlignColumns(private val alignment: Alignment) {
	fun applyTo(lines: List<Line>): List<Line> {
		return lines.map { line -> line.alignColumns(alignment) }
	}

	companion object {
		fun of(table: Table, alignment: Alignment): List<List<String>> {
			return AlignColumns(alignment).applyTo(table.lines).map { line -> line.asList() }
		}
	}
}
