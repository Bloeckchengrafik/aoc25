import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Day02Test {
    val testInput = "11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124"

    @Test
    fun e2eTest1() {
        assertEquals(1227775554, Day02.stage1(testInput))
    }

    @Test
    fun e2eTest2() {
        assertEquals(4174379265, Day02.stage2(testInput))
    }

    @Test
    fun e2eTest1Simpler() {
        assertEquals(38593859, Day02.stage1("38593856-38593862"))
    }

    @Test
    fun inputParse() {
        assertEquals(listOf(11.toLong()..22.toLong(), 33.toLong()..44.toLong()), Day02.parse("11-22,33-44"))
    }

    @Test
    fun isFunny() {
        assertTrue(Day02.isFunny(11), "11")
        assertTrue(Day02.isFunny(1010), "1010")
        assertFalse(Day02.isFunny(101), "101")
    }

    @Test
    fun isFunnyOrMore() {
        assertTrue(Day02.isFunnyOrLonger(11), "11")
        assertTrue(Day02.isFunnyOrLonger(111), "111")
        assertTrue(Day02.isFunnyOrLonger(101010), "101010")
        assertFalse(Day02.isFunnyOrLonger(101), "101")
    }
}