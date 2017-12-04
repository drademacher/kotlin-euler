package centum0

import memoize

fun main(args: Array<String>) {
    var backtrack: (Int, Int) -> Int = { _, _ -> 0 }
    backtrack = { n: Int, upper: Int ->
        if (n == 0) {
            1
        } else {
            (1..minOf(n, upper)).sumBy { backtrack(n - it, minOf(upper, it)) }
        }
    }.memoize()
    println("Return: " + backtrack(100, 99))
}