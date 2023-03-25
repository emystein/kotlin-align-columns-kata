package ar.com.flow.kata.aligncolumns

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class InputParserTest {
	@Test
	fun parseEmpty() {
		val parsedLines = InputParser().read("")
		assertThat(parsedLines).isEqualTo(emptyList())
	}

	@Test
	fun parseOneLineWithOneColumn() {
		val parsedLines = InputParser().read("Show")
		assertThat(parsedLines).isEqualTo(listOf(listOf("Show")))
	}

	@Test
	fun parseOneLineWithTwoColumns() {
		val parsedLines = InputParser().read("Show\$me")
		assertThat(parsedLines).isEqualTo(listOf(listOf("Show", "me")))
	}

	@Test
	fun parseTwoLinesWithTwoColumns() {
		val parsedLines = InputParser().read("Show\$me\nthe\$money")
		assertThat(parsedLines).isEqualTo(
			listOf(
				listOf("Show", "me"),
				listOf("the", "money")
			)
		)
	}
}