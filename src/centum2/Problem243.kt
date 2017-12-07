package centum2

import getPrimeTester

fun main(args: Array<String>) {
    val n = 1e6.toInt()
    val prime = getPrimeTester(n)
    val primes = (1..n).filter(prime)

//    // compute phi on integers in [n] to array
//    val phi = IntArray(n + 1, { it })
//    for (i in primes) {
//        for (j in i..n step i) {
//            phi[j] /= i
//            phi[j] *= (i - 1)
//        }
//    }

    var i = 0
    var result = 1L
    var phi = 1L

    do {
        result *= primes[i]
        phi *= primes[i] - 1
        i += 1
    } while (phi.toDouble() / (result.toDouble() - 1) >= 15499.0 / 94744.0)

    println("Result: $result")

}
