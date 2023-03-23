package ar.com.flow.kata.aligncolumns

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class AlignColumnsTest {
    @Test
    fun givenEmptyLinesWhenAlignColumnsThenTheResultShouldBeEmptyLines() {
        assertThat(AlignColumns.of(listOf())).isEqualTo(listOf())
    }
    @Test
    fun givenOneLineOneColumnWhenAlignColumnsThenTheColumnShouldBeAlignedTheSameAsTheOriginal() {
        assertThat(AlignColumns.of(listOf(listOf("The")))).isEqualTo(listOf(listOf("The")))
    }
    @Test
    fun givenOneLineManyColumnsWithFirstColumnWidestWhenAlignColumnsThenTheColumnShouldBeAlignedToTheFirstColumn() {
        assertThat(AlignColumns.of(listOf(listOf("Align", "me")))).isEqualTo(listOf(listOf("Align", "me   ")))
    }
    @Test
    fun givenOneLineManyColumnsWithSecondColumnWidestWhenAlignColumnsThenTheColumnShouldBeAlignedToTheSecondColumn() {
        assertThat(AlignColumns.of(listOf(listOf("The", "Alignment")))).isEqualTo(listOf(listOf("The      ", "Alignment")))
    }
    @Test
    fun givenManyLinesManyColumnsWhenAlignColumnsThenTheColumnsShouldBeAlignedToTheWidestColumn() {
        assertThat(AlignColumns.of(listOf(listOf("Align", "me"),
                                          listOf("The", "Alignment")))).isEqualTo(listOf(listOf("Align    ", "me       "),
                                                                                         listOf("The      ", "Alignment")))
    }
}