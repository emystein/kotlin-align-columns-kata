package ar.com.flow.kata.aligncolumns

class AsciiGrid(private val wrappedTable: Table) {
	fun print(): String {
		return this.borderRow + "\n" +
				this.wrappedLines +
				this.borderRow + "\n"
	}

	private val borderRow =
		this.wrappedTable.columns
			.joinToString(separator = "*", prefix = "*", postfix = "*") { column -> "-".repeat(column.width) }

	private val wrappedLines =
		this.wrappedTable.lines
			.joinToString(separator = "") { line -> wrapLine(line) + "\n" }

	private fun wrapLine(line: Line): String {
		return line.asList().joinToString(separator = "|", prefix = "|", postfix = "|")
	}
}
