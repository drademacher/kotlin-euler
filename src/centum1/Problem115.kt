package centum1

import binomial

fun main(args: Array<String>) {
    val m = 50

    val result = (1..1000).takeWhile { F(m, it) < 1e6 }.last() + 1
    println("Result: " + result)
}

private fun F(m: Int, n: Int): Long {
    val maximalNumber: Int = (n + 1) / m
    return (0..maximalNumber).map { G(m, n, it) }.sum()
}

private fun G(m: Int, n: Int, k: Int): Long {
    return binomial(n + 1 - (m - 1) * k, 2 * k).toLong()
}