import kotlin.test.Test
import kotlin.test.assertEquals

class Day06Test {
    val testInput = "123 328  51 64 \n" +
            " 45 64  387 23 \n" +
            "  6 98  215 314\n" +
            "*   +   *   +  \n"

    val data: List<List<String>> = listOf(
        listOf("123", "328", "51", "64"),
        listOf("45", "64", "387", "23"),
        listOf("6", "98", "215", "314"),
        listOf("*", "+", "*", "+")
    )

    val data2: List<List<String>> = listOf(
        listOf("1", "24", "356", "*"),
        listOf("369", "248", "8", "+"),
        listOf("32", "581", "175", "*"),
        listOf("623", "431", "4", "+")
    )

    @Test
    fun stage1E2E() {
        assertEquals(4277556, Day06.stage1(testInput))
    }

    @Test
    fun stage2E2E() {
        assertEquals(3263827, Day06.stage2(testInput))
    }

    @Test
    fun parseInput1() {
        assertEquals(data, Day06.parseInput1(testInput))
    }

    @Test
    fun parseInput2() {
        assertEquals(data2, Day06.parseInput2(testInput))
    }

    @Test
    fun transpose() {
        val base = listOf(listOf("a", "b"), listOf("c", "d"))
        val expected = listOf(listOf("a", "c"), listOf("b", "d"))
        assertEquals(expected, Day06.transposeList(base))
    }
}