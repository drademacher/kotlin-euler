import java.math.BigInteger

fun main(args: Array<String>) {
    
    for (i in 1010101010..1389026623) {
        val k = i * i
        if (check(k)) {
            println("Result: " + k)
            break
        }
    }

    println("hi")
}

fun check(n : Int) : Boolean {
    if (n % 10 != 0) {
        return false
    }

    return true
}