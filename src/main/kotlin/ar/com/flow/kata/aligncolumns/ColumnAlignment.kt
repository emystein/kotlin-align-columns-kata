package ar.com.flow.kata.aligncolumns

interface ColumnAlignment {
    fun applyTo(cellValue: String, columnWidth: Int): String
}

class LeftAlignment: ColumnAlignment {
    override fun applyTo(cellValue: String, columnWidth: Int): String {
        return cellValue.plus(" ".repeat(columnWidth - cellValue.length))
    }
}