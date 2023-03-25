package ar.com.flow.kata.aligncolumns

class GridPrinter {
    fun print(lines: List<List<String>>): String {
        val borderRow =
            Columns.of(lines)
                .joinToString(separator = "*", prefix = "*", postfix = "*") { column -> "-".repeat(column.width) }

        return borderRow + "\n" +
                lines.joinToString(separator = "") { line -> wrapLine(line) + "\n" } +
                borderRow + "\n"
    }

    private fun wrapLine(words: List<String>): String {
        return words.joinToString(separator = "|", prefix = "|", postfix = "|")
    }
}
