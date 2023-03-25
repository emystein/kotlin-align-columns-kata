package ar.com.flow.kata.aligncolumns

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class InputParserTest {
	@Test
	fun parseEmpty() {
		val readLines = InputParser().readLines("")
		assertThat(readLines).isEqualTo(emptyList())
	}

	@Test
	fun parseOneLineWithOneColumn() {
		val readLines = InputParser().readLines("Show")
		val expectedLines = Lines.from(listOf(listOf("Show")))
		assertThat(readLines).isEqualTo(expectedLines)
	}

	@Test
	fun parseOneLineWithTwoColumns() {
		val readLines = InputParser().readLines("Show\$me")
		val expectedLines = Lines.from(listOf(listOf("Show", "me")))
		assertThat(readLines).isEqualTo(expectedLines)
	}

	@Test
	fun parseTwoLinesWithTwoColumns() {
		val readLines = InputParser().readLines("Show\$me\nthe\$money")
		val expectedLines = Lines.from(
			listOf(
				listOf("Show", "me"),
				listOf("the", "money")
			)
		)
		assertThat(readLines).isEqualTo(expectedLines)
	}
}