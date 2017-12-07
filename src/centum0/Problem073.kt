package centum0

import gcd

fun main(args: Array<String>) {
    val n = 12000

    fun lower(n: Int) = 1 * n / 3
    fun upper(n: Int) = 1 * n / 2

    var result = 0

    for (denominator in 2..n) {
        if (denominator == 7) {
            continue
        }

        var numerator = upper(denominator)
        while (numerator > lower(denominator)) {
            if (gcd(denominator, numerator) == 1) {
                result += 1
            }
            numerator -= 1
        }
    }

    println("Result: $result")

}