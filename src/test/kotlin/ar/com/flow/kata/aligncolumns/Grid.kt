package ar.com.flow.kata.aligncolumns

class Grid {
	fun print(table: Table): String {
		val borderRow =
			table.columns.joinToString(separator = "*", prefix = "*", postfix = "*") { column -> "-".repeat(column.width) }

		return borderRow + "\n" +
				table.lines.joinToString(separator = "") { line -> wrapLine(line) + "\n" } +
				borderRow + "\n"
	}

	private fun wrapLine(line: Line): String {
		val words = line.asList()
		return words.joinToString(separator = "|", prefix = "|", postfix = "|")
	}
}
