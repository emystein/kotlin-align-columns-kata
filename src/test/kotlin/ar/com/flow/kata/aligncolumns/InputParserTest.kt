package ar.com.flow.kata.aligncolumns

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class InputParserTest {
	@Test
	fun parseEmpty() {
		val parsedLines = InputParser().readLines("")
		assertThat(parsedLines).isEqualTo(emptyList())
	}

	@Test
	fun parseOneLineWithOneColumn() {
		val parsedLines = InputParser().readLines("Show")
		val expectedLines = Lines.from(listOf(listOf("Show")))
		assertThat(parsedLines).isEqualTo(expectedLines)
	}

	@Test
	fun parseOneLineWithTwoColumns() {
		val parsedLines = InputParser().readLines("Show\$me")
		val expectedLines = Lines.from(listOf(listOf("Show", "me")))
		assertThat(parsedLines).isEqualTo(expectedLines)
	}

	@Test
	fun parseTwoLinesWithTwoColumns() {
		val parsedLines = InputParser().readLines("Show\$me\nthe\$money")
		val expectedLines = Lines.from(
			listOf(
				listOf("Show", "me"),
				listOf("the", "money")
			)
		)
		assertThat(parsedLines).isEqualTo(expectedLines)
	}
}