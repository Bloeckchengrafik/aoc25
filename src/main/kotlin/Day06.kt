import util.Day

object Day06 : Day<Long, Long> {
    fun transposeList(matrix: List<List<String>>): List<List<String>> =
        matrix[0].indices.map { i -> matrix.map { it[i] } }

    fun parseInput1(input: String): List<List<String>> =
        input.lines()
            .map { line -> line.split("\\s+".toRegex()).filter { it.isNotEmpty() } }
            .filter { it.isNotEmpty() }

    fun parseInput2(input: String): List<List<String>> {
        val out = mutableListOf<List<String>>()
        val lines = input.lines().let { if (it.last().isEmpty()) it.dropLast(1) else it }
        val linesWithoutOperator = lines.dropLast(1)
        val operatorLine = lines.last()
        val numbers = mutableListOf<Long>()
        var operator = ""
        for (index in lines[0].indices) {
            val chars = linesWithoutOperator.map { it[index].toString() }
            val trimmed = chars.joinToString("").trim()
            if (trimmed.isEmpty()) {
                out.add(numbers.map { it.toString() } + listOf(operator))
                numbers.clear()
                operator = ""
                continue
            }

            numbers.add(trimmed.toLong())

            if (operatorLine.indices.contains(index) && operatorLine[index] != ' ')
                operator = operatorLine[index].toString()
        }

        out.add(numbers.map { it.toString() } + listOf(operator))

        return out
    }

    fun evalProblem(problem: List<String>): Long {
        val operator = when (problem.last()) {
            "+" -> ({ a: Long, b: Long -> a + b })
            "*" -> ({ a: Long, b: Long -> a * b })
            else -> throw IllegalArgumentException("Unknown operator ${problem.last()}")
        }

        val numbers = problem.dropLast(1).map { it.toLong() }
        return numbers.reduce(operator)
    }

    override fun stage1(input: String): Long =
        transposeList(parseInput1(input))
            .sumOf { evalProblem(it) }

    override fun stage2(input: String): Long =
        parseInput2(input)
            .sumOf { evalProblem(it) }
}