package ar.com.flow.kata.aligncolumns

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class AlignColumnsTest {
	@Test
	fun emptyText() {
		val input = ""
		val expected = ""
		assertEquals(expected, AlignColumns.align(input))
	}

	@Test
	fun singleLineOneWordText() {
		val input = "Hola"
		val expected = """
			*----*
			|Hola|
			*----*
		""".trimIndent()
		assertEquals(expected, AlignColumns.align(input))
	}

	@Test
	fun singleLineTwoWordText() {
		val input = "Hola\$Mundo!"
		val expected = """
			*----*------*
			|Hola|Mundo!|
			*----*------*
		""".trimIndent()
		assertEquals(expected, AlignColumns.align(input))
	}

	@Test
	fun twoLinesTwoWordsText() {
		val input = "Hola\$Mundo!\nQué\$Tal?"
		val expected = """
			*----*------*
			|Hola|Mundo!|
			|Qué |Tal?  |
			*----*------*
		""".trimIndent()
		assertEquals(expected, AlignColumns.align(input))
	}
}