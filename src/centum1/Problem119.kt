package centum1

import java.math.BigInteger
import kotlin.math.log

fun main(args: Array<String>) {

    val solutions = HashSet<Long>()
    for (base in 2L..1000) {
        (2..20)
                .map { BigInteger.valueOf(base).pow(it).toLong() }
                .filterTo(solutions) { it > 9 && termOfSequence(it) }
    }

    val result = solutions.sorted()[29]
    println("Result: $result")
}

private fun termOfSequence(n: Long): Boolean {
    val int = Math.round(log(n.toDouble(), sumOfDigits(n).toDouble()))
    return Math.pow(sumOfDigits(n).toDouble(), int.toDouble()) == n.toDouble()
}

private fun sumOfDigits(n: Long): Long {
    var result = 0L
    var i = n
    while (i > 0) {
        result += i % 10
        i /= 10
    }
    return result
}