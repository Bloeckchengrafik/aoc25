package util

interface Day<T : Any, U : Any> {
    fun stage1(input: String): T
    fun stage2(input: String): U
}