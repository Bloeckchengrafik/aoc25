import util.runner

fun d02parse(input: String): List<LongRange> = input.split(",").map { str ->
    val vals = str.split("-").map { it.toLong() }
    vals[0]..vals[1]
}

fun d02isFunny(num: Long): Boolean {
    if (num < 10) return false
    val str = num.toString()

    val repeating = str.substring(0..<(str.length/2))
    val total = repeating.repeat(2)
    return str == total
}

fun d02isFunnyOrLonger(num: Long): Boolean {
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

fun d02sumFunny(input: String, fn: (Long) -> Boolean): Long {
    return d02parse(input)
        .sumOf { ints ->
            ints
                .filter { fn(it) }
                .sum()
        }
}

fun d02stage1(input: String): Long {
    return d02sumFunny(input, ::d02isFunny)
}

fun d02stage2(input: String): Long {
    return d02sumFunny(input, ::d02isFunnyOrLonger)
}

fun main() = runner(2, ::d02stage1, ::d02stage2)
