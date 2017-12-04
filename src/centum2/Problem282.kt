package centum2

import memoize

fun main(args: Array<String>) {
    val mod = 1475789056

    var ack: (Long, Long) -> Long = { _, _ -> 0L }
    ack = { m: Long, n: Long ->
        if (m == 0L) {
            n + 1L % mod
        } else {
            if (n == 0L) {
                ack(m - 1, 1) % mod
            } else {
                ack(m - 1, ack(m, n - 1)) % mod
            }
        }
    }.memoize()

    println("A(1, 0) = ${ack(1L, 0L)}")
    println("A(2, 2) = ${ack(2L, 2L)}")
    println("A(4, 4) = ${ack(4L, 4L)}")
}