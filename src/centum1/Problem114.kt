package centum1

import binomial

// wolfram alpha:
// sum (50 + 1 - 2i choose 2i) for i = 0 to 12

fun main(args: Array<String>) {
    val result = F(3, 50)
    println("Result: " + result)
}

private fun F(m: Int, n: Int): Long {
    val maximalNumber: Int = (n + 1) / m
    return (0..maximalNumber).map { G(m, n, it) }.sum()
}

private fun G(m: Int, n: Int, k: Int): Long {
    return binomial(n + 1 - (m - 1) * k, 2 * k).toLong()
}