package dsa

data class Multiset<T>(val counts: Map<T, Long>) {
    constructor(vararg vals: T) : this(vals.toList())

    constructor(vals: List<T>) : this(vals.groupingBy { it }.eachCount().mapValues { it.value.toLong() })

    fun intersectLeft(other: Multiset<T>): Multiset<T> {
        val result = mutableMapOf<T, Long>()
        for ((item, count) in counts) {
            if (other.counts.containsKey(item)) {
                result[item] = count
            }
        }
        return Multiset(result)
    }

    operator fun minus(other: Multiset<T>): Multiset<T> {
        val result = counts.toMutableMap()
        for ((item, otherCount) in other.counts) {
            val currentCount = result[item] ?: 0
            val newCount = currentCount - otherCount
            if (newCount > 0) {
                result[item] = newCount
            } else {
                result.remove(item)
            }
        }
        return Multiset(result)
    }

    operator fun plus(other: Multiset<T>): Multiset<T> {
        val result = counts.toMutableMap()
        for ((item, otherCount) in other.counts) {
            result[item] = (result[item] ?: 0) + otherCount
        }
        return Multiset(result)
    }

    /**
     * Warning: Not executed on every element n times, just once per unique key.
     * Fn must be pure for cardinality to remain correct.
     */
    fun flatMap(fn: (T) -> Iterable<T>): Multiset<T> {
        val newCounts = mutableMapOf<T, Long>()

        for ((item, count) in counts) {
            val mappedElements = fn(item)
            for (mapped in mappedElements) {
                newCounts[mapped] = (newCounts[mapped] ?: 0) + count
            }
        }

        return Multiset(newCounts)
    }

    override fun toString(): String = counts.toString()

    val size: Long get() = counts.values.sum()
}