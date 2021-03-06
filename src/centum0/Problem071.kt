package centum0

import gcd

fun main(args: Array<String>) {
    val n = 1e6.toInt()

    fun lower(n: Int) = 2 * n / 5
    fun upper(n: Int) = 3 * n / 7

    var result = 0
    var maximum = 0.0



    for (denominator in 2..n) {
        if (denominator == 7) {
            continue
        }

        var numerator = upper(denominator)
        while (numerator > lower(denominator)) {
            if (gcd(denominator, numerator) == 1) {
                // numerator forms biggest reduced fraction
                if (numerator.toDouble() / denominator > maximum) {
                    maximum = numerator.toDouble() / denominator
                    result = numerator
                }
                break
            }
            numerator -= 1
        }
    }

    println("Result: $result")

}