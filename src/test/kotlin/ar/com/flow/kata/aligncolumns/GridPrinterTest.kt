package ar.com.flow.kata.aligncolumns

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class GridPrinterTest {
    @Test
    fun givenEmptyLinesWhenPrintGridThenGridShouldBeEmpty() {
        val printed = GridPrinter().print(listOf())

        assertThat(printed).isEqualTo("**\n**\n")
    }
    @Test
    fun givenOneLineOneWordWhenPrintGridThenGridShouldWrapWord() {
        val printed = GridPrinter().print(listOf(listOf("Show")))

        assertThat(printed).isEqualTo("*----*\n|Show|\n*----*\n")
    }
    @Test
    fun givenOneLineOneTwoWordsWhenPrintGridThenGridShouldWrapWords() {
        val printed = GridPrinter().print(listOf(listOf("Show", "me")))

        assertThat(printed).isEqualTo("*----*--*\n|Show|me|\n*----*--*\n")
    }
    @Test
    fun givenTwoLinesWhenPrintGridThenGridShouldWrapLines() {
        val printed = GridPrinter().print(listOf(listOf("Show", "me   "),
                                                 listOf("The ", "money")))

        assertThat(printed).isEqualTo("*----*-----*" + "\n" +
                                           "|Show|me   |" + "\n" +
                "|The |money|" + "\n" +
                "*----*-----*\n")
    }
}