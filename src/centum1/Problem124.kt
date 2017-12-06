package centum1

import getPrimeTester

fun main(args: Array<String>) {
    val n = 1e5.toInt()
    val prime = getPrimeTester(n)
    val primes = (1..n).filter(prime)

    // compute rad on integers in [n] to array
    val rad = IntArray(n + 1, { 1 })
    for (i in primes) {
        for (j in i..n step i) {
            rad[j] *= i
        }
    }

    val result = rad
            .drop(1) // array starts at 0, but rad starts at 1, so delete first
            .zip((1..n)) // annotate with indices which are lost after sorting
            .sortedBy { it.first }
            .get(10000-1)
            .second
    println("Result: $result")
}