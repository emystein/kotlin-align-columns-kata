package ar.com.flow.kata.aligncolumns

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class LeftAlignmentTest {
	@Test
	fun alignEmptyStringWithWidth0() {
		assertThat(LeftAlignment().applyTo("", width = 0)).isEqualTo("")
	}
	@Test
	fun alignEmptyStringWithWidth10() {
		assertThat(LeftAlignment().applyTo("", width = 10)).isEqualTo(" ".repeat(10))
	}
	@Test
	fun alignStringShorterThan3WithWidth3() {
		assertThat(LeftAlignment().applyTo("A", width = 3)).isEqualTo("A  ")
	}
	@Test
	fun alignStringLongerThan3WithWidth3() {
		assertThat(LeftAlignment().applyTo("Alice", width = 3)).isEqualTo("Alice")
	}
}