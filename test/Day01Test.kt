import kotlin.test.Test
import kotlin.test.assertEquals

class Day01Test {
    val testIn = """L68
L30
R48
L5
R60
L55
L1
L99
R14
L82"""

    @Test
    fun stage1() {
        val out = Day01.stage1(testIn)
        assertEquals(3, out)
    }

    @Test
    fun stage2() {
        val out = Day01.stage2(testIn)
        assertEquals(6, out)
    }

    @Test
    fun stage2LargeWrap() {
        val out = Day01.stage2("R1000")
        assertEquals(10, out)
    }
}