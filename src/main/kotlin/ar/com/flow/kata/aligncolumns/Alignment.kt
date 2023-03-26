package ar.com.flow.kata.aligncolumns

interface Alignment {
	fun applyTo(valueToAlign: String, width: Int): String
}

class LeftAlignment : Alignment {
	override fun applyTo(valueToAlign: String, width: Int): String {
		return valueToAlign.plus(" ".repeat(width - valueToAlign.length))
	}
}