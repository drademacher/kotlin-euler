import java.math.BigInteger

fun binomial(N: Int, K: Int): BigInteger {
    var ret = BigInteger.ONE
    (0 until K).forEach { i ->
        ret = ret.multiply(BigInteger.valueOf((N - i).toLong()))
                .divide(BigInteger.valueOf((i + 1).toLong()))
    }
    return ret
}