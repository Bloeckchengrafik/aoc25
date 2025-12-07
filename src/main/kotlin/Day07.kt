import dsa.Multiset
import util.Day

object Day07 : Day<Int, Long> {
    data class ParsedInput(
        val startIdx: Int,
        val splitters: List<List<Int>>
    )

    fun parseInput(input: String): ParsedInput {
        val lines = input.lines();
        val startIdx = lines.first().indexOf("S")
        val splitters = lines.drop(1).map {
            it.mapIndexedNotNull { i, c -> if (c == '^') i else null }
        }

        return ParsedInput(startIdx, splitters)
    }

    override fun stage1(input: String): Int {
        val parsedInput = parseInput(input)
        var timesSplit = 0
        parsedInput.splitters.fold(setOf(parsedInput.startIdx)) { acc, splitters ->
            val splitterSet = splitters.toSet()
            val splitOn = acc.intersect(splitterSet)
            val accWithoutSplit = acc - splitOn
            timesSplit += splitOn.size
            splitOn.flatMap { listOf(it - 1, it + 1) }.toSet() + accWithoutSplit
        }
        return timesSplit
    }

    override fun stage2(input: String): Long {
        val parsedInput = parseInput(input)
        var timelines: Long = 1
        parsedInput.splitters.fold(Multiset(parsedInput.startIdx)) { acc, splitters ->
            val splitterSet = Multiset(splitters)
            val splitOn = acc.intersectLeft(splitterSet)
            val accWithoutSplit = acc - splitOn
            timelines += splitOn.size
            splitOn.flatMap { listOf(it - 1, it + 1) } + accWithoutSplit
        }
        return timelines
    }
}