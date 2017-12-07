package centum1

import binomial
import java.math.BigInteger

fun main(args: Array<String>) {
    val state = IntArray(16, { 0 })

    fun stateCombinations(): BigInteger {
        state[0] += 1
        state[1] += 1
        state[10] += 1


        var left = state.sum()
        var result = binomial(left - 1, state[0])
        left -= state[0]

        for (i in 1 until 16) {
            result *= binomial(left, state[i])
            left -= state[i]
        }

        state[0] -= 1
        state[1] -= 1
        state[10] -= 1

        return result
    }

    fun backtrack(n: Int, m: Int): BigInteger {
        return if (m == 0 || n == 15) {
            state[15] = m
            val result = stateCombinations()
            state[15] = 0
            result
        } else {
            var result = BigInteger.ZERO
            for (k in 0..m) {
                state[n] += k
                result += backtrack(n + 1, m - k)
                state[n] -= k
            }
            result
        }
    }

    // faster solution, interested if that also works
//    val result = (3..16)
//            .map { BigInteger.valueOf(15) * BigInteger.valueOf(16).pow(it-1) + BigInteger.valueOf(41) * BigInteger.valueOf(14).pow(it-1) - BigInteger.valueOf(43) * BigInteger.valueOf(15).pow(it-1) - BigInteger.valueOf(13).pow(it) }
//            .reduce { acc, bigInteger -> acc+bigInteger }

    val result = (3..16)
            .map { backtrack(0, it-3) }
            .reduce { acc, bigInteger -> acc+bigInteger }
    println("Result: ${java.lang.Long.toHexString(result.toLong()).toUpperCase()}")
}
