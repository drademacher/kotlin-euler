package centum0

import kotlin.math.sqrt

fun main(args: Array<String>) {
    val n = 1500000
    val count = IntArray(n + 1)

    for (a in 1..n / 3) {
        if (a % 1000 == 0) println(a/1000)
        for (b in a..n) {

            val cSquare = (a * a + b * b)
            val h = cSquare and 0xF

            // Take advantage of Boolean short-circuit evaluation
            if (h == 0 || h == 1 || h == 4 || h == 9) {
                val c = sqrt(cSquare.toDouble()).toInt()
                if (c * c != cSquare) continue

                if (a + b + c > n) {
                    break
                }

                count[a + b + c] += 1

            }
        }
    }


//    println(count.asList())
    println("Result: " + count.filter { it == 1 }.count())
}