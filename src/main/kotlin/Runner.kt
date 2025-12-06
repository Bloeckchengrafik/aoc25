import util.runner

val days = listOf(
    Day01,
    Day02,
    Day03
)

fun main(args: Array<String>) {
    args.firstOrNull()?.toIntOrNull()?.also {
        println("== Day ${it} == ")
        val day = days[it - 1]
        runner(it, day::stage1, day::stage2)
        return
    }

    for ((i, day) in days.withIndex()) {
        println("== Day ${i + 1} == ")
        runner(i + 1, day::stage1, day::stage2)
    }
}