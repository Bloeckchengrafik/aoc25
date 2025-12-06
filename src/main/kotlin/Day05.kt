import kotlin.math.max
import util.Day

object Day05 : Day<Int, Long> {
    data class ParsedInput(
        val freshRanges: List<LongRange>,
        val itemIds: List<Long>
    )

    fun <T> List<T>.splitFirst(element: T): Pair<List<T>, List<T>> {
        val elementIndex = indexOf(element)
        return take(elementIndex) to drop(elementIndex + 1)
    }

    fun consumeRange(line: String): LongRange = line
        .split("-")
        .map { it.toLong() }
        .let { (a, b) -> a..b }

    fun parseInput(input: String): ParsedInput {
        val lines = input.lines()
        val (ranges, numbers) = lines.splitFirst("")

        return ParsedInput(ranges.map(::consumeRange), numbers.map { it.toLong() })
    }

    override fun stage1(input: String): Int {
        val input = parseInput(input)
        return input.itemIds.count { value -> input.freshRanges.any { it.contains(value) } }
    }

    override fun stage2(input: String): Long {
        val input = parseInput(input).freshRanges.sortedBy { it.first }
        var rangeWidths: Long = 0
        var currentStart = input.first().first
        var currentEnd = input.first().last
        for (rangeIndex in 1..<input.size) {
            val nextRange = input[rangeIndex]
            if (nextRange.first <= currentEnd + 1) {
                currentEnd = max(nextRange.last, currentEnd)
            } else {
                rangeWidths += currentEnd - currentStart + 1
                currentStart = nextRange.first
                currentEnd = nextRange.last
            }
        }
        rangeWidths += currentEnd - currentStart + 1

        return rangeWidths
    }
}