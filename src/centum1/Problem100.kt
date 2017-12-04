package centum1

fun main(args: Array<String>) {
    fun differ(total: Long, blue: Long) = (total) * (total - 1) - 2 * blue * (blue - 1)

    fun binarySearch(n: Long, min: Long, max: Long): Long {
        if (min > max) return -1

        val mid = (max + min) / 2
        if (differ(n, mid) == 0L) return mid
        if (differ(n, mid) > 0L) return binarySearch(n, mid + 1, max)
        return binarySearch(n, min, mid - 1)
    }

//    (1..21).forEach{ println("$it - ${differ(n, it.toLong())}") }
//    println(binarySearch(n, 0, n))

    var result: Long
    var n = 1030000000000L
//    var n = 1000L
    do {
        if (n % 10000000 == 0L) println("n = $n")
        result = binarySearch(n, n / 2, 3 * n / 4)
        n++
    } while (result == -1L)

    println("Result: blue = $result, red = ${n - result - 1}")
}

