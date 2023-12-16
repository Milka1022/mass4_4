fun main() {
    val array1 = intArrayOf(1, 2, 3, 2, 0)
    val array2 = intArrayOf(5, 1, 2, 7, 3, 2, 2)

    val intersection = findIntersection(array1, array2)
    println(intersection.contentToString())
}

fun findIntersection(array1: IntArray, array2: IntArray): IntArray {
    val map1 = array1.groupBy { it }.mapValues { it.value.size }
    val map2 = array2.groupBy { it }.mapValues { it.value.size }

    val result = mutableListOf<Int>()
    for ((num, count) in map1) {
        if (num in map2) {
            val minCount = minOf(count, map2[num]!!)
            repeat(minCount) {
                result.add(num)
            }
        }
    }
    return result.toIntArray()
}