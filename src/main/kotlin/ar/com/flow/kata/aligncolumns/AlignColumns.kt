package ar.com.flow.kata.aligncolumns

class AlignColumns(private val alignment: Alignment) {
	fun applyTo(table: Table): Table {
		return table.alignColumns(alignment)
	}

	companion object {
		fun of(table: Table, alignment: Alignment): Table {
			return AlignColumns(alignment).applyTo(table)
		}

		fun printGrid(input: String, alignment: Alignment): String {
			val table = InputParser().readTableFrom(input)
			val alignedTable = this.of(table, alignment)
			return AsciiGrid(alignedTable).print()
		}
	}
}
