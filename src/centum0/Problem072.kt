package centum0

import getPrimeTester

fun main(args: Array<String>) {
    val n = 1e6.toInt()
    val prime = getPrimeTester(n)
    val primes = (1..n).filter(prime)

    // compute phi on integers in [n] to array
    val phi = IntArray(n + 1, { it })
    for (i in primes) {
        for (j in i..n step i) {
            phi[j] /= i
            phi[j] *= (i - 1)
        }
    }

    val result = (2..n)
            .map { phi[it].toLong() }
            .sum()
    println("Result: $result")
}
