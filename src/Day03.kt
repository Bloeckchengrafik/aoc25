import util.Day
import util.runner

object Day03 : Day<Int, Long> {
    fun parseInput(input: String): List<List<Int>> =
        input.split("\n").map { it.split("").mapNotNull { str -> str.toIntOrNull() } }

    fun maxJolt(line: List<Int>, k: Int = 2): Long {
        val maxJolts = Array(k) { 0.toLong() }
        for (i in line) {
            for (nD in (1..<k).reversed()) {
                val newJoltCandidate = maxJolts[nD - 1] * 10 + i
                maxJolts[nD] = maxJolts[nD].coerceAtLeast(newJoltCandidate)
            }
            maxJolts[0] = maxJolts[0].coerceAtLeast(i.toLong())
        }

        return maxJolts[k-1]
    }

    override fun stage1(input: String): Int {
        return parseInput(input).sumOf { maxJolt(it).toInt() }
    }

    override fun stage2(input: String): Long {
        return parseInput(input).sumOf { maxJolt(it, 12) }
    }
}

fun main() = runner(3, Day03::stage1, Day03::stage2)
