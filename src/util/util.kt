package util

import com.toldoven.aoc.notebook.AocClient
import kotlin.time.measureTime

fun <T> stage(block: () -> T): T {
    val out: T
    val time = measureTime {
        out = block()
    }
    println("Stage took $time. Output: $out")
    return out
}

typealias AocRunFn = (String) -> Any

val unimpl: AocRunFn = { TODO("Not implemented") }

fun runner(day: Int, stage1: AocRunFn = unimpl, stage2: AocRunFn = unimpl) {
    val client = AocClient.fromFile()
    val input = client.interactiveDay(2025, day).input()

    if (stage1 != unimpl) stage { stage1(input) }
    if (stage2 != unimpl) stage { stage2(input) }
}