package centum1

import binomial

fun main(args: Array<String>) {

    println(binomial(3, 2).toLong() * 2 * 16 - binomial(3, 2).toLong() * 2 * 2)

    fun combinations(digits: Int) = 2 * binomial(digits - 1, 2).toLong() * 2 * 16 + 13 * binomial(digits - 1, 3).toLong() * 6


    // binomial(digits, 3).toLong()  * 4 * maxOf(1, Math.pow(16.0, digits - 3.0).toLong())

    val res = (3..16).map { combinations(it) }.sum()
//
//    println("4: ${combinations(4)}")
//
//    println("Result: ${java.lang.Long.toHexString(res).toUpperCase()}")

    val strs = (4096..65535)
            .map { java.lang.Integer.toHexString(it) }
            .filter { '0' in it && '1' in it && 'a' in it }
            .filter { it[0] == 'a' && it[1] == '1' }
    println("strs: " + strs.count())

//        println(s)


//    val lst = (2 until n) + 2
//    println(lst.reduce { acc, i -> acc * i })
}