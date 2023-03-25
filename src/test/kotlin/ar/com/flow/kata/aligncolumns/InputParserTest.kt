package ar.com.flow.kata.aligncolumns

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class InputParserTest {
	@Test
	fun readEmpty() {
		val readLines = InputParser().readLinesFrom("")
		assertThat(readLines).isEqualTo(emptyList())
	}

	@Test
	fun readOneLineWithOneColumn() {
		val readLines = InputParser().readLinesFrom("Show")
		val expectedLines = Lines.from(listOf(listOf("Show")))
		assertThat(readLines).isEqualTo(expectedLines)
	}

	@Test
	fun readOneLineWithTwoColumns() {
		val readLines = InputParser().readLinesFrom("Show\$me")
		val expectedLines = Lines.from(listOf(listOf("Show", "me")))
		assertThat(readLines).isEqualTo(expectedLines)
	}

	@Test
	fun readTwoLinesWithTwoColumns() {
		val readLines = InputParser().readLinesFrom("Show\$me\nthe\$money")
		val expectedLines = Lines.from(
			listOf(
				listOf("Show", "me"),
				listOf("the", "money")
			)
		)
		assertThat(readLines).isEqualTo(expectedLines)
	}
}