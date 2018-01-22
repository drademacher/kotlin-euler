package centum3

import getPrimeTester

fun main(args: Array<String>) {
    val n = 100000000
    val check = getPrimeTester(n)

    val ints = BooleanArray(n + 1, { true })
    ints[0] = false

    for (d in 1..n) {
        for (k in d..n step d) {
            val num = k/d + d
            if (!check(num)) {
                ints[k] = false
            }
        }
    }

    var result = 0L
    ints.forEachIndexed { index, b -> if (b) result += index }
    println("Result: $result")
}