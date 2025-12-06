import util.Day
import util.runner

object Day01 : Day<Int, Int> {
    override fun stage1(input: String): Int {
        val dirs = input.lines().map {
            val dir = if (it[0] == 'R') 1 else -1
            val num = it.substring(1).toInt()
            dir * num
        }
        var password = 0
        var pos = 50
        for (item in dirs) {
            pos = (pos + item + 100) % 100
            if (pos == 0) password++
        }

        return password
    }

    override fun stage2(input: String): Int {
        val dirs = input.lines().map {
            val dir = if (it[0] == 'R') 1 else -1
            val num = it.substring(1).toInt()
            dir to num
        }
        var password = 0
        var pos = 50
        for ((dir, num) in dirs) {
            for (i in 1..num) {
                pos = (pos + dir + 100) % 100

                if (pos == 0) {
                    password++
                }
            }
        }

        return password
    }
}

fun main() = runner(1, Day01::stage1, Day01::stage2)
