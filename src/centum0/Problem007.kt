package centum0

import getPrimeTester

fun main(args: Array<String>) {
    val n = 10000000

    val check = getPrimeTester(n)
    val primes = (1..n).filter(check)

    println("Result: ${primes[10000]}")
}





