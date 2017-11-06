import java.math.BigInteger

fun binomial(N: Int, K: Int): BigInteger {
    if (K > N || K < 0) {
        return BigInteger.ZERO
    }
    var ret = BigInteger.ONE
    (0 until minOf(K, N-K)).forEach { i ->
        ret = ret.multiply(BigInteger.valueOf((N - i).toLong()))
                .divide(BigInteger.valueOf((i + 1).toLong()))
    }

    return ret
}