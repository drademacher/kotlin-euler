package centum2

import getPrimeTester

// NOTE: Aufgabe ist ziemlich reudig, numerator braucht scheinbar ewigkeiten zum rechnen

fun main(args: Array<String>) {
    val a = 15499.0
    val b = 94744.0

    fun numerator(n: Long) = (1 until n).filter { gcd(n, it) == 1L }.count()

    val n = 1000000
    val prime = getPrimeTester(n)
    val primes = (1..n).filter(prime)

//    val const = 2*3*5*7*11*13*17*19*23
    var i = 0
    var num = 6L
    while (numerator(num).toDouble() / (num - 1).toDouble() >= a / b) {
//        println("$i: ${10 * num(i)} vs ${4 * (i-1) }")
        println("$num: ${numerator(num).toDouble() / (num - 1).toDouble()}")
        num *= primes[i]
        i += 1
    }

//    println("$i: ${94744 * } vs ${15499 * numerator(i) /  }")
//    println("$i: ${numerator(num)} vs ${(num-1) }")
    println("Result: $num")

//    println(num(22669) / (22669 - 1) )

}

private fun gcd(s: Long, t: Long): Long {
    var a = s
    var b = t
    var c: Long
    while (b != 0L) {
        c = a
        a = b
        b = c % b
    }

    return a
}