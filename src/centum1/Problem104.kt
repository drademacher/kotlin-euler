package centum1

import java.math.BigInteger

fun main(args: Array<String>) {
    fun isPandigital(n: Int): Boolean {
        val digits = BooleanArray(10)

        var i = n

        while (i != 0) {
            digits[i % 10] = true
            i /= 10
        }

        return digits.drop(1).all { it }
    }

    fun startsPandigital(n: BigInteger) = isPandigital(n.div(BigInteger.TEN.pow(getDigitCount(n) - 9)).toInt())
    fun endsPandigital(n: BigInteger) = isPandigital(n.mod(BigInteger.valueOf(1000000000)).toInt())


    var a = BigInteger.ONE
    var b = BigInteger.ONE
    var c : BigInteger

    for (i in 3..1000000) {
        c = b
        b = a
        a = b + c

        if (endsPandigital(a) && startsPandigital(a)) {
            println("Result: $i")
        }

    }
}

fun getDigitCount(number: BigInteger): Int {
    if (number == BigInteger.ZERO) return 0
    val count = Math.ceil(number.bitLength() * Math.log10(2.0)).toInt()

    return if (BigInteger.TEN.pow(count - 1) > number) {
        count - 1
    } else {
        count
    }
}
