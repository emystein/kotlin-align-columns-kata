package ar.com.flow.kata.aligncolumns

data class Cell(val value: String, val width: Int) {
	fun alignTo(alignment: Alignment, width: Int): Cell {
		return alignment.applyTo(this.value, width)
	}
}