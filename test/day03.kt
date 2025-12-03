import kotlin.test.Test
import kotlin.test.assertEquals

class Day03Test {
    val testInput = "987654321111111\n" +
            "811111111111119\n" +
            "234234234234278\n" +
            "818181911112111"

    @Test
    fun stage1E2E() {
        assertEquals(357, Day03.stage1(testInput))
    }

    @Test
    fun stage2E2E() {
        assertEquals(3121910778619, Day03.stage2(testInput))
    }

    @Test
    fun testParse() {
        assertEquals(listOf(listOf(1, 1, 1), listOf(2, 3, 4)), Day03.parseInput("111\n234"))
    }

    @Test
    fun testMaxJolt() {
        assertEquals(98, Day03.maxJolt(listOf(9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 1, 1, 1, 1, 1)))
        assertEquals(78, Day03.maxJolt(listOf(2, 3, 4, 2, 3, 4, 2, 3, 4, 2, 3, 4, 2, 7, 8)))
        assertEquals(92, Day03.maxJolt(listOf(8, 1, 8, 1, 8, 1, 9, 1, 1, 1, 1, 2, 1, 1, 1)))
    }
}