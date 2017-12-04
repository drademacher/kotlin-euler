package centum1

import getPrimeTester

fun main(args: Array<String>) {
    val n = 100000000

    val prime = getPrimeTester(n)
    val primes = (1..n).filter(prime)
    val composites = BooleanArray(n + 1, { false })

    for (i in 0 until primes.size) {
        for (j in i until primes.size) {
            val x: Long = primes[i].toLong() * primes[j].toLong()
            if (x > n) break

            if (x < 0) println("${primes[i]} * ${primes[j]} $x")
            composites[x.toInt() - 1] = true
        }
    }
    println("Result: ${composites.filter { it }.size}")

}