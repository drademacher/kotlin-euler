import java.math.BigInteger

fun main(args: Array<String>) {

    for (i in 1010101010L..1389026623L) {
        val k = BigInteger.valueOf(i) * BigInteger.valueOf(i)
        if (valid(k)) {
            println("Result: " + i)
            break
        }
    }
}

fun valid(m : BigInteger) : Boolean {
    var n = m

    if (n.rem(BigInteger.valueOf(10)) != BigInteger.valueOf(0)) {
        return false
    }

    for (i in 9L downTo 1L)  {
        n /= BigInteger.valueOf(100)

        if (n.rem(BigInteger.valueOf(10)) != BigInteger.valueOf(i)) {
            return false
        }
    }

    return true
}