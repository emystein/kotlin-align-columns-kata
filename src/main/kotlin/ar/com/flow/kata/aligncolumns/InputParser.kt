package ar.com.flow.kata.aligncolumns

class InputParser {
	fun read(input: String): List<List<String>> {
		if (input.isEmpty()) {
			return emptyList()
		}

		val lines = input.split("\n")
		return lines.map { line -> line.split("\$") }
	}
}
