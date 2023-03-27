package ar.com.flow.kata.aligncolumns

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class RightAlignmentTest {
	@Test
	fun alignEmptyStringWithWidth0() {
		assertThat(RightAlignment().applyTo("", width = 0)).isEqualTo("")
	}
	@Test
	fun alignEmptyStringWithWidth10() {
		assertThat(RightAlignment().applyTo("", width = 10)).isEqualTo(" ".repeat(10))
	}
	@Test
	fun alignStringShorterThan3WithWidth3() {
		assertThat(RightAlignment().applyTo("A", width = 3)).isEqualTo("  A")
	}
	@Test
	fun alignStringLongerThan3WithWidth3() {
		assertThat(RightAlignment().applyTo("Alice", width = 3)).isEqualTo("Alice")
	}
	@Test
	fun alignStringWithNegativeWidth() {
		assertThat(RightAlignment().applyTo("Alice", width = -10)).isEqualTo("Alice")
	}
}