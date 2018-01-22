package centum1

import getPrimeTester
import java.math.BigInteger

// computes result = 4939993641022

fun main(args: Array<String>) {
    val n = 1000003 // the +3 gives us one more prime after 1e6
    val prime = getPrimeTester(n)
    val primes = (5..n).filter(prime)

    var result = BigInteger.ZERO

    for (i in 0..primes.size - 2)
    {
        var smallest = primes[i].toLong()
        val next = nextPowerTen(primes[i])

        do {
            smallest += next
        } while (smallest % primes[i + 1] != 0L)

        result += BigInteger.valueOf(smallest)
    }

    println("Result: $result")
}

private fun nextPowerTen(n: Int): Long {
    var result = 1L
    var i = n
    while (i > 0) {
        i /= 10
        result *= 10
    }
    return result
}