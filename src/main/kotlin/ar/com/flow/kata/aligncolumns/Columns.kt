package ar.com.flow.kata.aligncolumns

object Columns {
	fun from(input: List<List<String>>): List<Column> {
		val columnCount = input.maxOfOrNull { line -> line.size } ?: 0
		return (1..columnCount).map { columnNumber -> Column.from(input, columnNumber) }
	}
}

data class Column(val number: Int, val width: Int) {
	companion object {
		fun from(input: List<List<String>>, columnNumber: Int): Column {
			return Column(columnNumber, widthOf(columnNumber, input))
		}

		private fun widthOf(columnNumber: Int, input: List<List<String>>): Int {
			return valuesOf(columnNumber, input).maxOf { value -> value.length }
		}

		private fun valuesOf(columnNumber: Int, input: List<List<String>>): List<String> {
			return input.map { line -> line.getOrNull(columnNumber - 1) ?: "" }
		}
	}
}