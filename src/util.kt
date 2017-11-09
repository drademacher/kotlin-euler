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


/**
 * Retrieve a function which tells whether a given input number is prime
 *
 * how to increase wheel
 * update: sieve array size, inWheel(), toWheel(), return function
 */
fun getPrimeTester(n : Int) : (Int) -> Boolean {
    val sieve = BooleanArray(n/3 + 1, {it != 0})

    fun inWheel(k : Int) = k % 6 == 1 || k % 6 == 5
    fun toWheel(k : Int) = k / 3
//    fun toReal(k : Int) = 6 * (k/2) + 1 + (k % 2) * 4

    (1..Math.sqrt(n.toDouble()).toInt() step 2)
            .filter { inWheel(it) && sieve[toWheel(it)] }
            .forEach { i -> (i * i..n step i).filter { inWheel(it) }.forEach { j -> sieve[toWheel(j)] = false } }

    return { it -> it == 2 || it == 3 || (it in 1..n && inWheel(it) && sieve[toWheel(it)])}
}