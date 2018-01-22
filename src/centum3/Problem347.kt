package centum3

import getPrimeTester
import java.lang.Math.pow
import kotlin.math.log

fun main(args: Array<String>) {
    val n = 10000000
    val m = n / 2

    val prime = getPrimeTester(m)
    val primes = (1..m).filter(prime)

    var result = mutableSetOf<Long>()

    for (a in 0 until primes.size) {
        for (b in a + 1 until primes.size) {
            val pa = primes[a]
            val pb = primes[b]
            if (pa * pb > n) break


            var best = 0L
            var i = log(n.toDouble(), pa.toDouble()).toInt() + 1
            var j = 1

            while (j <= log(n.toDouble(), pb.toDouble()).toInt()) {
                while (intpow(pa, i) * intpow(pb, j) > n) i--
                if (i < 1) break

                best = maxOf(best, intpow(pa, i) * intpow(pb, j))
                j++
            }

            result.add(best)
        }
    }
    // 2088731014440
//    1781527310321
    println("Result: ${result.sum()}")
}


// SIMPLE IMPLEMENTATION FOR LOW VALUES!
private fun intpow(b: Int, p: Int): Long {
//    var result = 1
//    var base = b
//    var power = p
//    while (power > 0) {
//        if (power % 2 == 1) {
//            result = (result * base)
//        }
//        base *= base
//        power /= 2
//
//    }
//    return result
    return pow(b.toDouble(), p.toDouble()).toLong()
}