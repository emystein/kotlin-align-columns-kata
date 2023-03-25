package ar.com.flow.kata.aligncolumns

class AlignColumns(private val alignment: Alignment) {
	fun applyTo(table: Table): Table {
		return Table.fromLines(table.lines.map { line -> line.alignColumns(alignment) })
	}

	companion object {
		fun of(table: Table, alignment: Alignment): Table {
			return AlignColumns(alignment).applyTo(table)
		}

		fun printGrid(input: String, alignment: Alignment): String {
			val table = InputParser().readTableFrom(input)
			return Grid().print(of(table, alignment))
		}
	}
}
