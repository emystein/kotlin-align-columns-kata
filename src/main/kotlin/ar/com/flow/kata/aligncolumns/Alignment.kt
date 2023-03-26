package ar.com.flow.kata.aligncolumns

interface Alignment {
	fun applyTo(valueToAlign: String, width: Int): Cell
}

class LeftAlignment : Alignment {
	override fun applyTo(valueToAlign: String, width: Int): Cell {
		val alignedValue = valueToAlign.plus(" ".repeat(width - valueToAlign.length))
		return Cell(alignedValue, alignedValue.length)
	}
}