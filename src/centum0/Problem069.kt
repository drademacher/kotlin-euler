package centum0

import getPrimeTester

// INFO: easy solution is to find biggest product < n of the first n primes, but that is boring in terms of computations :-)
fun main(args: Array<String>) {
    val n = 1000000
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

    val result = (2 until n)
            .map { Pair(it, it.toDouble() / phi[it].toDouble()) }
            .maxBy { it.second }!!
            .first
    println("Result: $result")
}
