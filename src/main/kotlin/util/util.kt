package util

import com.toldoven.aoc.notebook.AocClient
import kotlin.time.measureTime

fun <T> stage(n: Int, block: () -> T): T {
    val out: T
    val time = measureTime {
        out = block()
    }
    println("Stage $n took $time. Output: $out")
    return out
}

typealias AocRunFn = (String) -> Any

val unimpl: AocRunFn = { TODO("Not implemented") }

fun runner(day: Int, stage1: AocRunFn = unimpl, stage2: AocRunFn = unimpl) {
    val client = AocClient.fromFile()
    val input = client.interactiveDay(2025, day).input()

    if (stage1 != unimpl) stage(1) { stage1(input) }
    if (stage2 != unimpl) stage(2) { stage2(input) }
}