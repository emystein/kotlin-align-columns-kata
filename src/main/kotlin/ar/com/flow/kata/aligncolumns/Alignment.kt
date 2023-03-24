package ar.com.flow.kata.aligncolumns

interface Alignment {
    fun applyTo(cell: Cell): Cell
}

class LeftAlignment: Alignment {
    override fun applyTo(cell: Cell): Cell {
        val alignedValue = cell.value.plus(" ".repeat(cell.width - cell.value.length))
        return Cell(alignedValue, alignedValue.length)
    }
}