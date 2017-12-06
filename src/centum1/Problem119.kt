package centum1

import java.math.BigInteger
import kotlin.math.log

fun main(args: Array<String>) {
//    println(termOfSequence(512))
//    println(sumOfDigits(512))
//    println(log(512.toDouble(), sumOfDigits(512).toDouble()))
//    println(termOfSequence(614656 ))


    val solutions = HashSet<Long>()
    for (base in 2L..1000) {
        for (expo in 2..20) {
            val i = BigInteger.valueOf(base).pow(expo).toLong()
            if (i > 9 && termOfSequence(i)) {
                solutions.add(i)
//            println(log10(i.toDouble()) / log10(sumOfDigits(i).toDouble()))
//            println(sumOfDigits(i))
            }
        }
    }

    solutions
            .sorted()
            .forEachIndexed { index, l ->
                println("${index + 1}: $l")
            }

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