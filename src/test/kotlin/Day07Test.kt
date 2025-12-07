import kotlin.test.Test
import kotlin.test.assertEquals

class Day07Test {
    val testInput = ".......S.......\n" +
            "...............\n" +
            ".......^.......\n" +
            "...............\n" +
            "......^.^......\n" +
            "...............\n" +
            ".....^.^.^.....\n" +
            "...............\n" +
            "....^.^...^....\n" +
            "...............\n" +
            "...^.^...^.^...\n" +
            "...............\n" +
            "..^...^.....^..\n" +
            "...............\n" +
            ".^.^.^.^.^...^.\n" +
            "...............\n"

    @Test
    fun stage1E2E() {
        assertEquals(21, Day07.stage1(testInput))
    }

    @Test
    fun stage2E2E() {
        assertEquals(40, Day07.stage2(testInput))
    }

    @Test
    fun testInputParse() {
        assertEquals(
            Day07.ParsedInput(4, listOf(listOf(0, 3, 6), listOf(2))),
            Day07.parseInput("....S....\n^..^..^\n..^..")
        )
    }
}