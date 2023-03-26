package ar.com.flow.kata.aligncolumns

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class AsciiGridTest {
	@Test
	fun givenEmptyLinesWhenPrintGridThenGridShouldBeEmpty() {
		val table = Table.from(emptyList())
		val printed = AsciiGrid(table).print()

		assertThat(printed).isEqualTo(
			"**\n" +
			"**\n"
		)
	}

	@Test
	fun givenOneLineOneWordWhenPrintGridThenGridShouldWrapWord() {
		val table = Table.from(listOf(listOf("Show")))
		val printed = AsciiGrid(table).print()

		assertThat(printed).isEqualTo(
			"*----*\n" +
			"|Show|\n" +
			"*----*\n"
		)
	}

	@Test
	fun givenOneLineOneTwoWordsWhenPrintGridThenGridShouldWrapWords() {
		val table = Table.from(listOf(listOf("Show", "me")))
		val printed = AsciiGrid(table).print()

		assertThat(printed).isEqualTo(
			"*----*--*\n" +
			"|Show|me|\n" +
			"*----*--*\n"
		)
	}

	@Test
	fun givenTwoLinesWhenPrintGridThenGridShouldWrapLines() {
		val table = Table.from(listOf(
			listOf("Show", "me   "),
			listOf("The ", "money")
		))
		val printed = AsciiGrid(table).print()

		assertThat(printed).isEqualTo(
			"*----*-----*\n" +
			"|Show|me   |\n" +
			"|The |money|\n" +
			"*----*-----*\n"
		)
	}
}