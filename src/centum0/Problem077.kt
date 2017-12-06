package centum0

import getPrimeTester

fun main(args: Array<String>) {
    val N = 10000000

    val prime = getPrimeTester(N)
    val primes = (1..N).filter(prime)
    val memo = HashMap<Pair<Int, Int>, Int>()

    fun backtrack(n: Int, upper: Int): Int {
        if (n == 0) {
            return 1
        }

        if (upper > n) {
            return backtrack(n, n)
        }

        if (Pair(n, upper) in memo) {
            return memo[Pair(n, upper)]!!
        }
        val result = (primes.takeWhile { it <= n && it <= upper }).sumBy { backtrack(n - it, minOf(upper, it)) }
        memo[Pair(n, upper)] = result
        return result
    }



    for (k in 1..10000) {
        val length = backtrack(k, k - 1)
//        println("k $k")

        if (length > 5000) {
            println("Return: $k")
            break
        }
    }
}