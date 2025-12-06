import kotlin.test.Test
import kotlin.test.assertEquals

class Day04Test {
    val testInput = "..@@.@@@@.\n" +
            "@@@.@.@.@@\n" +
            "@@@@@.@.@@\n" +
            "@.@@@@..@.\n" +
            "@@.@@@@.@@\n" +
            ".@@@@@@@.@\n" +
            ".@.@.@.@@@\n" +
            "@.@@@.@@@@\n" +
            ".@@@@@@@@.\n" +
            "@.@.@@@.@.\n"

    val smallerTest1 = "@"
    val smallerTest9 = "@@@\n@@@\n@@@"

    @Test
    fun stage1E2E() {
        assertEquals(13, Day04.stage1(testInput))
    }

    @Test
    fun stage2E2E() {
        assertEquals(43, Day04.stage2(testInput))
    }

    @Test
    fun gridTest() {
        val grid1 = Day04.parseInput(smallerTest1)
        val grid9 = Day04.parseInput(smallerTest9)

        with(Day04) {
            assertEquals(listOf(false, false, false, false, false, false, false, false), grid1.neighbors(0, 0))
            assertEquals(listOf(true, true, true, true, true, true, true, true), grid9.neighbors(1, 1))
        }
    }
}