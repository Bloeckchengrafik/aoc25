import kotlin.test.Test
import kotlin.test.assertEquals

class Day05Test {
    val testInput = "3-5\n" +
            "10-14\n" +
            "16-20\n" +
            "12-18\n" +
            "\n" +
            "1\n" +
            "5\n" +
            "8\n" +
            "11\n" +
            "17\n" +
            "32\n" +
            "60"

    @Test
    fun stage1E2E() {
        assertEquals(3, Day05.stage1(testInput))
    }

    @Test
    fun stage2E2E() {
        assertEquals(14, Day05.stage2(testInput))
    }

    @Test
    fun testParse() {
        assertEquals(Day05.ParsedInput(
            listOf(0.toLong()..5.toLong(), 7.toLong()..8.toLong()),
            listOf(1,2,3,4)
        ), Day05.parseInput("0-5\n7-8\n\n1\n2\n3\n4"))
    }
}