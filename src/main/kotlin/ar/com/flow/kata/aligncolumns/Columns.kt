package ar.com.flow.kata.aligncolumns

object Columns {
	fun from(input: List<List<String>>): List<Column> {
		val columnCount = input.maxOfOrNull { line -> line.size } ?: 0
		return (1..columnCount).map { columnNumber -> Column.fromInput(input, columnNumber) }
	}
}

data class Column(val number: Int, val width: Int) {
	companion object {
		fun fromInput(input: List<List<String>>, columnNumber: Int): Column {
			return Column(columnNumber, widthOf(columnNumber, input))
		}

		private fun widthOf(columnNumber: Int, input: List<List<String>>): Int {
			val valuesUnderColumn = input.map { cells -> cells.getOrNull(columnNumber - 1) ?: "" }
			return valuesUnderColumn.maxOf { value -> value.length }
		}
	}
}
