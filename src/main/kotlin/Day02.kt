import util.Day
import util.runner

object Day02 : Day<Long, Long> {
    fun parse(input: String): List<LongRange> = input.split(",").map { str ->
        val vals = str.split("-").map { it.toLong() }
        vals[0]..vals[1]
    }

    fun isFunny(num: Long): Boolean {
        if (num < 10) return false
        val str = num.toString()

        val repeating = str.substring(0..<(str.length/2))
        val total = repeating.repeat(2)
        return str == total
    }

    fun isFunnyOrLonger(num: Long): Boolean {
        if (num < 10) return false
        val str = num.toString()

        for (i in 1..(str.length/2)) {
            val repeating = str.substring(0..<i)
            var total = repeating
            while (total.length < str.length) {
                total += repeating
                if (str == total) return true
            }
        }
        return false
    }

    fun sumFunny(input: String, fn: (Long) -> Boolean): Long {
        return parse(input)
            .sumOf { ints ->
                ints
                    .filter { fn(it) }
                    .sum()
            }
    }

    override fun stage1(input: String): Long = sumFunny(input, ::isFunny)
    override fun stage2(input: String): Long = sumFunny(input, ::isFunnyOrLonger)
}
