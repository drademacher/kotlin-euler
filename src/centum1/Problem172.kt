package centum1

import binomial
import java.math.BigInteger

fun main(args: Array<String>) {
    val eighteenDigits = int(9) * int(10).pow(17)
    val result = eighteenDigits - (4..17).map { hasKZeros(it) }.reduce { acc, bigInteger -> acc + bigInteger } - (4..18).map { int(9) * hasKFixedNonzeros(it) }.reduce { acc, bigInteger -> acc + bigInteger }
    println("Result: $result")

    println(hasKFixedNonzeros(17))
}

private fun int(n : Long) = BigInteger.valueOf(n)

private fun hasKZeros(k : Int) : BigInteger {
    return binomial(17, k) * int(9).pow(18-k)
}

private fun hasKFixedNonzeros(k : Int) : BigInteger {
    if (k == 18) {
        return int(1)
    }
    return binomial(17, k-1) * int(9).pow(18-k) + binomial(17, k) * int(8) * int(9).pow(17-k)
}