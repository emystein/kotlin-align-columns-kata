package ar.com.flow.kata.aligncolumns

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class AlignColumnsTest {
	@Test
	fun givenEmptyLinesWhenAlignColumnsThenTheResultShouldBeEmptyLines() {
		val aligned = AlignColumns.of(listOf(), alignment = LeftAlignment())

		assertThat(aligned).isEqualTo(listOf())
	}

	@Test
	fun givenOneLineOneColumnWhenAlignColumnsThenTheColumnShouldBeAlignedTheSameAsTheOriginal() {
		val aligned = AlignColumns.of(listOf(listOf("The")), alignment = LeftAlignment())

		assertThat(aligned).isEqualTo(listOf(listOf("The")))
	}

	@Test
	fun givenOneLineManyColumnsWithFirstColumnWidestWhenAlignColumnsThenTheColumnShouldBeAlignedToTheFirstColumn() {
		val aligned = AlignColumns.of(listOf(listOf("Align", "me")), alignment = LeftAlignment())

		assertThat(aligned).isEqualTo(listOf(listOf("Align", "me")))
	}

	@Test
	fun givenOneLineManyColumnsWithSecondColumnWidestWhenAlignColumnsThenTheColumnShouldBeAlignedToTheSecondColumn() {
		val aligned = AlignColumns.of(listOf(listOf("The", "Alignment")), alignment = LeftAlignment())

		assertThat(aligned).isEqualTo(listOf(listOf("The", "Alignment")))
	}

	@Test
	fun givenManyLinesManyColumnsWhenAlignColumnsThenTheColumnsShouldBeAlignedToTheWidestColumn() {
		val aligned = AlignColumns.of(
			listOf(
				listOf("Align", "me"),
				listOf("The", "Alignment")
			), alignment = LeftAlignment()
		)

		assertThat(aligned).isEqualTo(
			listOf(
				listOf("Align", "me       "),
				listOf("The  ", "Alignment")
			)
		)
	}

	@Test
	fun givenManyLinesDifferentNumberOfColumnsWhenAlignColumnsThenTheColumnsShouldBeAlignedToTheWidestColumn() {
		val aligned = AlignColumns.of(
			listOf(
				listOf("Align"),
				listOf("The", "Alignment")
			), alignment = LeftAlignment()
		)

		assertThat(aligned).isEqualTo(
			listOf(
				listOf("Align", "         "),
				listOf("The  ", "Alignment")
			)
		)
	}
}