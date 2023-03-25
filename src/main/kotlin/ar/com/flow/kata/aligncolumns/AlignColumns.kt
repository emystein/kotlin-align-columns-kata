package ar.com.flow.kata.aligncolumns

class AlignColumns(private val alignment: Alignment) {
	fun applyTo(lines: List<Line>): List<Line> {
		return lines.map { line -> line.alignColumns(alignment) }
	}

	companion object {
		fun of(lines: List<Line>, alignment: Alignment): List<List<String>> {
			return AlignColumns(alignment).applyTo(lines).map { line -> line.asList() }
		}
	}
}
