package ar.com.flow.kata.aligncolumns

class InputParser {
	fun readTableFrom(input: String): Table {
		return Table.from(split(input))
	}

	private fun split(input: String): List<List<String>> {
		if (input.isEmpty()) {
			return emptyList()
		}

		val lines = input.split("\n")
		return lines.map { line -> line.split("\$") }
	}
}
