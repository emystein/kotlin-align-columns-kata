package ar.com.flow.kata.aligncolumns

import kotlin.collections.flatten
import kotlin.collections.fold
import kotlin.collections.map

class AlignColumns {
    companion object {
        fun align(input: String): String {
            if (input.isBlank()) return ""
            val rawInputLines = input.lines()
            val table = Table.fromRawLines(rawInputLines)
            val result = table.border() + "\n" + table.contents().joinToString("\n") + "\n" + table.border()
            return result
        }
    }
}

data class Table(val cellsByLine: Map<Int, List<Cell>>) {
    val columns = setupColumns()

    private fun setupColumns(): Array<Column> =
        cellsByLine
            .values
            .flatten()
            .groupBy { cell -> cell.columnIndex }
            .map { cellsByColumn -> Column(cellsByColumn.key, cellsByColumn.value) }
            .toTypedArray()

    fun border(): String {
        return columns.fold("*") { result, column -> """$result${"-".repeat(column.width)}*""" }
    }

    fun contents(): List<String> {
        return cellsByLine
            .values
            .map { line -> expand(line) }
            .map { line -> wrapContents(line) }
    }

    private fun expand(line: List<Cell>): List<Cell> =
        line.map { cell -> cell.copy(content = cell.content.padEnd(columns[cell.columnIndex].width)) }

    private fun wrapContents(line: List<Cell>): String =
        line.fold("|") { accumulator, cell -> """$accumulator${cell.content}|""" }

    companion object {
        fun fromRawLines(rawInputLines: List<String>): Table {
            val cellsByLine = rawInputLines
                .mapIndexed { lineIndex, line ->
                    lineIndex to line.split("$").mapIndexed { columnIndex, word -> Cell(lineIndex, columnIndex, word) }
                }
                .toMap()
            val table = Table(cellsByLine)
            return table
        }
    }
}


data class Cell(val lineIndex: Int, val columnIndex: Int, val content: String)

data class Column(val index: Int, val cells: List<Cell>) {
    val width = cells
        .map { cell -> cell.content }
        .maxOfOrNull { it.length } ?: 0
}
    