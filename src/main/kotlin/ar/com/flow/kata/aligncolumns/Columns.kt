package ar.com.flow.kata.aligncolumns

object Columns {
    fun of(lines: List<List<String>>): List<Column> {
        val columnCount = lines.maxOfOrNull { line -> line.size } ?: 0
        val columnRange = (1..columnCount)
        return columnRange.map { columnNumber -> Column.create(columnNumber, lines) }
    }
}

class Column(val number: Int, values: List<String>) {
    val width: Int = values.maxOf { value -> value.length }

    companion object {
        fun create(number: Int, lines: List<List<String>>): Column {
            val values = lines.map { cells -> cells.getOrNull(number - 1) ?: "" }
            return Column(number, values)
        }
    }
}