package ar.com.flow.kata.aligncolumns

class GridPrinter {
    fun print(lines: List<List<String>>): String {
        val borderRowColumnSeparators =
            Columns.of(lines).fold("") { accumulator, column -> accumulator + ("-".repeat(column.width) + "*") }
            .removeSuffix("*")
        val borderRow = "*$borderRowColumnSeparators*\n"
        return borderRow + lines.fold(""){ accumulator, line -> accumulator + wrapLine(line)} + borderRow
    }

    private fun wrapLine(words: List<String>): String {
        return words.joinToString(separator = "|", prefix = "|", postfix = "|") + "\n"
    }
}
