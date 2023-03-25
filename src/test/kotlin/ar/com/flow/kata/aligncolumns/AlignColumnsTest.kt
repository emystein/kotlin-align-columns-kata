package ar.com.flow.kata.aligncolumns

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class AlignColumnsTest {
	@Test
	fun givenEmptyLinesWhenAlignColumnsThenTheResultShouldBeEmptyLines() {
		val lines = Lines.from(emptyList())
		val aligned = AlignColumns.of(lines, alignment = LeftAlignment())

		assertThat(aligned).isEqualTo(emptyList())
	}

	@Test
	fun givenOneLineOneColumnWhenAlignColumnsThenTheColumnShouldBeAlignedTheSameAsTheOriginal() {
		val lines = Lines.from(listOf(listOf("The")))
		val aligned = AlignColumns.of(lines, alignment = LeftAlignment())

		assertThat(aligned).isEqualTo(listOf(listOf("The")))
	}

	@Test
	fun givenOneLineManyColumnsWithFirstColumnWidestWhenAlignColumnsThenTheColumnShouldBeAlignedToTheFirstColumn() {
		val lines = Lines.from(listOf(listOf("Align", "me")))
		val aligned = AlignColumns.of(lines, alignment = LeftAlignment())

		assertThat(aligned).isEqualTo(listOf(listOf("Align", "me")))
	}

	@Test
	fun givenOneLineManyColumnsWithSecondColumnWidestWhenAlignColumnsThenTheColumnShouldBeAlignedToTheSecondColumn() {
		val lines = Lines.from(listOf(listOf("The", "Alignment")))
		val aligned = AlignColumns.of(lines, alignment = LeftAlignment())

		assertThat(aligned).isEqualTo(listOf(listOf("The", "Alignment")))
	}

	@Test
	fun givenManyLinesManyColumnsWhenAlignColumnsThenTheColumnsShouldBeAlignedToTheWidestColumn() {
		val lines = Lines.from(
			listOf(
				listOf("Align", "me"),
				listOf("The", "Alignment")
			)
		)

		val aligned = AlignColumns.of(lines, alignment = LeftAlignment())

		assertThat(aligned).isEqualTo(
			listOf(
				listOf("Align", "me       "),
				listOf("The  ", "Alignment")
			)
		)
	}

	@Test
	fun givenManyLinesDifferentNumberOfColumnsWhenAlignColumnsThenTheColumnsShouldBeAlignedToTheWidestColumn() {
		val lines = Lines.from(
			listOf(
				listOf("Align"),
				listOf("The", "Alignment")
			)
		)

		val aligned = AlignColumns.of(lines, alignment = LeftAlignment())

		assertThat(aligned).isEqualTo(
			listOf(
				listOf("Align", "         "),
				listOf("The  ", "Alignment")
			)
		)
	}
}