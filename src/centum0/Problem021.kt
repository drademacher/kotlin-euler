package centum0

fun main(args: Array<String>) {
    val n = 1000000
    val divisors = IntArray(n + 1, { 1 })

    for (i in 2..n) {
        for (j in 2 * i..n step i) { //
            divisors[j] += i
        }
    }

    fun amicable(n: Int) = divisors[n] != n && n == divisors[divisors[n]]

    println("Result: ${(1 until 10000).filter { amicable(it) }.sum()}")

}