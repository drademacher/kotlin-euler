package centum0

fun main(args: Array<String>) {
    val memo = HashMap<Pair<Int, Int>, Long>()

    fun backtrack(n: Int, upper: Int): Long {
        if (n == 0) {
            return 1
        }

        if (upper > n) {
            return backtrack(n, n)
        }

        if (Pair(n, upper) in memo) {
            return memo[Pair(n, upper)]!!
        }
        val result = (1..minOf(n, upper)).map { backtrack(n - it, minOf(upper, it)) }.sum()
        memo[Pair(n, upper)] = result
        return result
    }

    fun partitions(n: Long) = backtrack(n.toInt(), n.toInt())

    fun binarySearch(n: Long, min: Long, max: Long): Long {
        if (min > max) return -1

        val mid = (max + min) / 2
//        if (differ(n, mid) == 0L) return mid
//        if (differ(n, mid) > 0L) return binarySearch(n, mid+1, max)
        return binarySearch(n, min, mid - 1)
    }



    for (i in 1L..Long.MAX_VALUE) {
        val value = partitions(i)
        if (value % 1000 == 0L) {
            println("$i: $value")
        }

    }


//
//
//    for (k in 1000..10000) {
//        val result = backtrack(k, k)
//        println("k $k")
//
//        if (result % 1000000 == 0) {
//            println("Return: $result")
//        }
//    }

//    println("Result: $k")
}