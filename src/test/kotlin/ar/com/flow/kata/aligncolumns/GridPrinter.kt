package ar.com.flow.kata.aligncolumns

class GridPrinter {
    fun print(lines: List<List<String>>): String {
        if (lines.isEmpty()) {
            return "**\n**"
        }
        val columns = Columns.of(lines)
        var borderRow = "*" + lines[0].withIndex().fold("") {
                accumulator, (index, _)  -> accumulator + ("-".repeat(columns[index].width) + "*")
        } + "\n"
        return borderRow + lines.fold(""){ accumulator, line -> accumulator + wrapLine(line)} + borderRow
    }

    private fun wrapLine(words: List<String>): String {
        return words.joinToString(separator = "|", prefix = "|", postfix = "|") + "\n"
    }
}
