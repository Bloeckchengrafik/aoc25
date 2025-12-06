import util.Day

private typealias Grid = MutableList<MutableList<Boolean>>

object Day04 : Day<Int, Int> {
    fun parseInput(input: String): Grid =
        input.split("\n").map { line -> line.map { it == '@' }.toMutableList() }.toMutableList()

    fun Grid.neighbors(x: Int, y: Int): List<Boolean> = (-1..1).flatMap { dx ->
        (-1..1).mapNotNull { dy ->
            if (dx == 0 && dy == 0) return@mapNotNull null
            val tx = x + dx
            val ty = y + dy
            if (ty !in indices || tx !in this[ty].indices) return@mapNotNull false
            this[ty][tx]
        }
    }

    override fun stage1(input: String): Int = parseInput(input).let { grid ->
        grid.indices.sumOf { y ->
            grid[y].indices.count { x ->
                grid[y][x] && grid.neighbors(x, y).count { it } < 4
            }
        }
    }

    override fun stage2(input: String): Int {
        val grid = parseInput(input)
        var hasChanged = true
        var count = 0

        outer@ while (hasChanged) {
            hasChanged = false
            for (y in grid.indices) {
                for (x in grid[y].indices) {
                    if (grid[y][x] && grid.neighbors(x, y).count { it } < 4) {
                        grid[y][x] = false
                        hasChanged = true
                        count++
                    }
                }
            }
        }

        return count
    }
}