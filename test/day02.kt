import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Day2Test {
    val testInput = "11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124"

    @Test
    fun e2eTest1() {
        assertEquals(1227775554, d02stage1(testInput))
    }

    @Test
    fun e2eTest2() {
        assertEquals(4174379265, d02stage2(testInput))
    }

    @Test
    fun e2eTest1Simpler() {
        assertEquals(38593859, d02stage1("38593856-38593862"))
    }

    @Test
    fun inputParse() {
        assertEquals(listOf(11.toLong()..22.toLong(), 33.toLong()..44.toLong()), d02parse("11-22,33-44"))
    }

    @Test
    fun isFunny() {
        assertTrue(d02isFunny(11), "11")
        assertTrue(d02isFunny(1010), "1010")
        assertFalse(d02isFunny(101), "101")
    }

    @Test
    fun isFunnyOrMore() {
        assertTrue(d02isFunnyOrLonger(11), "11")
        assertTrue(d02isFunnyOrLonger(111), "111")
        assertTrue(d02isFunnyOrLonger(101010), "101010")
        assertFalse(d02isFunnyOrLonger(101), "101")
    }
}