package ar.com.flow.kata.aligncolumns

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isTrue
import org.junit.jupiter.api.Test

class InputParserTest {
	@Test
	fun readEmpty() {
		val table = InputParser().readTableFrom("")
		assertThat(table.isEmpty()).isTrue()
	}

	@Test
	fun readOneLineWithOneColumn() {
		val table = InputParser().readTableFrom("Show")
		val expectedLines = Lines.from(listOf(listOf("Show")))
		assertThat(table.lines).isEqualTo(expectedLines)
	}

	@Test
	fun readOneLineWithTwoColumns() {
		val table = InputParser().readTableFrom("Show\$me")
		val expectedLines = Lines.from(listOf(listOf("Show", "me")))
		assertThat(table.lines).isEqualTo(expectedLines)
	}

	@Test
	fun readTwoLinesWithTwoColumns() {
		val table = InputParser().readTableFrom("Show\$me\nthe\$money")
		val expectedLines = Lines.from(
			listOf(
				listOf("Show", "me"),
				listOf("the", "money")
			)
		)
		assertThat(table.lines).isEqualTo(expectedLines)
	}
}