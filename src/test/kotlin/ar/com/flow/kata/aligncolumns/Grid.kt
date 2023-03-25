package ar.com.flow.kata.aligncolumns

class Grid {
	fun print(lines: List<Line>): String {
		val borderRow =
			Columns.ofLines(lines)
				.joinToString(separator = "*", prefix = "*", postfix = "*") { column -> "-".repeat(column.width) }

		return borderRow + "\n" +
				lines.joinToString(separator = "") { line -> wrapLine(line) + "\n" } +
				borderRow + "\n"
	}

	private fun wrapLine(line: Line): String {
		val words = line.asList()
		return words.joinToString(separator = "|", prefix = "|", postfix = "|")
	}
}
