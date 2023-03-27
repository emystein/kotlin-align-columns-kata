package ar.com.flow.kata.aligncolumns

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class CenterAlignmentTest {
	@Test
	fun alignEmptyStringWithWidth0() {
		assertThat(CenterAlignment().applyTo("", width = 0)).isEqualTo("")
	}
	@Test
	fun alignEmptyStringWithWidth10() {
		assertThat(CenterAlignment().applyTo("", width = 10)).isEqualTo(" ".repeat(10))
	}
	@Test
	fun alignStringShorterThan3WithWidth3() {
		assertThat(CenterAlignment().applyTo("A", width = 3)).isEqualTo(" A ")
	}
	@Test
	fun alignStringWithOddLengthShorterThan4WithWidth4() {
		assertThat(CenterAlignment().applyTo("A", width = 4)).isEqualTo(" A  ")
	}
	@Test
	fun alignStringLongerThan3WithWidth3() {
		assertThat(CenterAlignment().applyTo("Alice", width = 3)).isEqualTo("Alice")
	}
	@Test
	fun alignStringWithNegativeWidth() {
		assertThat(CenterAlignment().applyTo("Alice", width = -10)).isEqualTo("Alice")
	}
}