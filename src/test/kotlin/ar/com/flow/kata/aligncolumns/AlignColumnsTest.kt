package ar.com.flow.kata.aligncolumns

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class AlignColumnsTest {
	@Test
	fun givenEmptyLinesWhenAlignColumnsThenTheResultShouldBeEmptyLines() {
		val table = Table.from(emptyList())
		val aligned = AlignColumns.of(table, alignment = LeftAlignment())

		assertThat(aligned).isEqualTo(Table.from(emptyList()))
	}

	@Test
	fun givenOneLineOneColumnWhenAlignColumnsThenTheColumnShouldBeAlignedTheSameAsTheOriginal() {
		val table = Table.from(listOf(listOf("The")))
		val aligned = AlignColumns.of(table, alignment = LeftAlignment())

		assertThat(aligned).isEqualTo(Table.from(listOf(listOf("The"))))
	}

	@Test
	fun givenOneLineManyColumnsWithFirstColumnWidestWhenAlignColumnsThenTheColumnShouldBeAlignedToTheFirstColumn() {
		val table = Table.from(listOf(listOf("Align", "me")))
		val aligned = AlignColumns.of(table, alignment = LeftAlignment())

		assertThat(aligned).isEqualTo(Table.from(listOf(listOf("Align", "me"))))
	}

	@Test
	fun givenOneLineManyColumnsWithSecondColumnWidestWhenAlignColumnsThenTheColumnShouldBeAlignedToTheSecondColumn() {
		val table = Table.from(listOf(listOf("The", "Alignment")))
		val aligned = AlignColumns.of(table, alignment = LeftAlignment())

		assertThat(aligned).isEqualTo(Table.from(listOf(listOf("The", "Alignment"))))
	}

	@Test
	fun givenManyLinesManyColumnsWhenAlignColumnsThenTheColumnsShouldBeAlignedToTheWidestColumn() {
		val table = Table.from(
			listOf(
				listOf("Align", "me"),
				listOf("The", "Alignment")
			)
		)

		val aligned = AlignColumns.of(table, alignment = LeftAlignment())

		assertThat(aligned).isEqualTo(
			Table.from(listOf(
				listOf("Align", "me       "),
				listOf("The  ", "Alignment")
			))
		)
	}

	@Test
	fun givenManyLinesDifferentNumberOfColumnsWhenAlignColumnsThenTheColumnsShouldBeAlignedToTheWidestColumn() {
		val table = Table.from(
			listOf(
				listOf("Align"),
				listOf("The", "Alignment")
			)
		)

		val aligned = AlignColumns.of(table, alignment = LeftAlignment())

		assertThat(aligned).isEqualTo(
			Table.from(listOf(
				listOf("Align", "         "),
				listOf("The  ", "Alignment")
			))
		)
	}

	@Test
	fun printGrid() {
		val input = "Show\$me\nThe\$money"

		val printed = AlignColumns.printGrid(input, alignment = LeftAlignment())

		assertThat(printed).isEqualTo(
			"*----*-----*\n" +
			"|Show|me   |\n" +
			"|The |money|\n" +
			"*----*-----*\n"
		)
	}
}
