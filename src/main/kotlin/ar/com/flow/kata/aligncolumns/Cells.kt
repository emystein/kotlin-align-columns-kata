package ar.com.flow.kata.aligncolumns

object Cells {
    fun from(lineValues: List<String>, columns: List<Column>): List<Cell> {
        return columns.map { column ->
            val cellValue = lineValues.getOrNull(column.number - 1) ?: ""
            Cell(cellValue, column.width)
        }
    }
}