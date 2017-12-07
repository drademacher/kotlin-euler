package centum2

import getPrimeTester

fun main(args: Array<String>) {
    val n = 40000000
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

    val chain = IntArray(n + 1)
    chain[1] = 1
    for (i in 2..n) {
        chain[i] = 1 + chain[phi[i]]
    }

    val result = primes
            .filter { chain[it] == 25 }
            .map { it.toLong() }
            .sum()

    println("Result: $result")
}