package ar.com.flow.kata.aligncolumns

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class GridTest {
	@Test
	fun givenEmptyLinesWhenPrintGridThenGridShouldBeEmpty() {
		val lines = Lines.from(emptyList())
		val columns = Columns.ofLines(lines)
		val printed = Grid().print(lines, columns)

		assertThat(printed).isEqualTo(
			"**\n" +
			"**\n"
		)
	}

	@Test
	fun givenOneLineOneWordWhenPrintGridThenGridShouldWrapWord() {
		val lines = Lines.from(listOf(listOf("Show")))
		val columns = Columns.ofLines(lines)
		val printed = Grid().print(lines, columns)

		assertThat(printed).isEqualTo(
			"*----*\n" +
			"|Show|\n" +
			"*----*\n"
		)
	}

	@Test
	fun givenOneLineOneTwoWordsWhenPrintGridThenGridShouldWrapWords() {
		val lines = Lines.from(listOf(listOf("Show", "me")))
		val columns = Columns.ofLines(lines)
		val printed = Grid().print(lines, columns)

		assertThat(printed).isEqualTo(
			"*----*--*\n" +
			"|Show|me|\n" +
			"*----*--*\n"
		)
	}

	@Test
	fun givenTwoLinesWhenPrintGridThenGridShouldWrapLines() {
		val lines = Lines.from(listOf(
			listOf("Show", "me   "),
			listOf("The ", "money")
		))
		val columns = Columns.ofLines(lines)
		val printed = Grid().print(lines, columns)

		assertThat(printed).isEqualTo(
			"*----*-----*\n" +
			"|Show|me   |\n" +
			"|The |money|\n" +
			"*----*-----*\n"
		)
	}
}