package ar.com.flow.kata.aligncolumns

import kotlin.math.max

interface Alignment {
	fun applyTo(valueToAlign: String, width: Int): String
}

class LeftAlignment : Alignment {
	override fun applyTo(valueToAlign: String, width: Int): String {
		return valueToAlign.plus(" ".repeat(max(0, width - valueToAlign.length)))
	}
}

class RightAlignment : Alignment {
	override fun applyTo(valueToAlign: String, width: Int): String {
		return " ".repeat(max(0, width - valueToAlign.length)).plus(valueToAlign)
	}
}

class CenterAlignment : Alignment {
	override fun applyTo(valueToAlign: String, width: Int): String {
		val totalSpaceCount = max(0, width - valueToAlign.length)
		val leftSpaces = " ".repeat(totalSpaceCount / 2)
		val rightSpaces = " ".repeat(totalSpaceCount - leftSpaces.length)
		return leftSpaces + valueToAlign + rightSpaces
	}
}
