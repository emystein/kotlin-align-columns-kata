package ar.com.flow.kata.aligncolumns

interface Alignment {
    fun applyTo(cellValue: String, columnWidth: Int): String
}

class LeftAlignment: Alignment {
    override fun applyTo(cellValue: String, columnWidth: Int): String {
        return cellValue.plus(" ".repeat(columnWidth - cellValue.length))
    }
}