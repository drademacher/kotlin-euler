package centum0

import getPrimeTester

fun main(args: Array<String>) {
    val n = 1e7.toInt()
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

    fun numSorted(n: Int) = n.toString().toCharArray().sorted().toString()

    val result = (2 until n)
            .filter { numSorted(it) == numSorted(phi[it]) }
            .map { Pair(it, it.toDouble() / phi[it].toDouble()) }
            .minBy { it.second }!!
            .first
//    val result = numSorted(phi[87109]) == numSorted(87109)
    println("Result: $result")

//    .toString().toCharArray().sorted().toString()

}