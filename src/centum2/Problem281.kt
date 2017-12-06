package centum2

import binomial

fun main(args: Array<String>) {
    fun f (m : Int, n : Int) : Long {
        var result = 0L

        println((1..m).map { binomial(n * it, n).toLong() })

        result += (1..m).map { binomial(n * it, n).toLong() }.reduce { acc, l -> l * acc }

//        result /= m * n
        return result
    }

    println("f(2,1) = ${f(2,1)}")
    println("f(2,2) = ${f(2,2)}")
    println("f(3,1) = ${f(3,1)}")
    println("f(3,2) = ${f(3,2)}")
}