package centum3

import binomial
import memoize


// result is 6.3551758451

fun main(args: Array<String>) {
    fun proba(missing: Int, new: Int) = binomial(32 - missing, 16 - new).toLong() * binomial(missing, new).toLong() / binomial(32, 16).toDouble()

    var recurse: (Int) -> Double = { _ -> 0.0 }
    recurse = { n: Int ->
        if (n <= 0) {
            n.toDouble()
        } else {
            (1 + (0 until n).map { recurse(it) * proba(n, n - it) }.sum()) / (1 - proba(n, 0))
        }
    }.memoize()

    println((0 until 1).map { recurse(it) * proba(1, 1 - it) })
    println(proba(1, 0))

    (0..32).forEach {
        println("$it: " + recurse(it))
    }

    println(proba(1, 1))
}