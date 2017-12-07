package centum1

import binomial
import java.math.BigInteger

fun main(args: Array<String>) {
    val state = IntArray(10, { 0 })

    fun stateCombinations(): BigInteger {
        var left = state.sum()
        var result = binomial(left - 1, state[0])
        left -= state[0]

        for (i in 1 until 10) {
            result *= binomial(left, state[i])
            left -= state[i]
        }

        return result
    }

    fun backtrack(n: Int, m: Int): BigInteger {
        return if (m == 0) {
            val result = stateCombinations()
            result
        } else if (n == 10) {
            BigInteger.ZERO
        } else {
            var result = BigInteger.ZERO
            for (k in 0..3) {
                state[n] += k
                result += backtrack(n + 1, m - k)
                state[n] -= k
            }
            result
        }
    }

    val result = backtrack(0, 18)
    println("Result: $result")
}
