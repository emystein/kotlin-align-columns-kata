package ar.com.flow.kata.aligncolumns

class GridPrinter {
    fun print(lines: List<List<String>>): String {
        val borderRow =
            Columns.of(lines).map { column -> "-".repeat(column.width) }
                             .joinToString( separator = "*", prefix = "*", postfix = "*")
        val wrappedLines = lines.joinToString(separator = "") { line -> wrapLine(line) }
        return borderRow + "\n" + wrappedLines + borderRow + "\n"
    }

    private fun wrapLine(words: List<String>): String {
        return words.joinToString(separator = "|", prefix = "|", postfix = "|\n")
    }
}
