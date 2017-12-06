package centum1

import getPrimeTester

fun main(args: Array<String>) {
    val n = 5e4.toInt() + 3 // the +5 gives us one more prime after 1e6
    val prime = getPrimeTester(n)
    val primes = (5..n).filter(prime)


    println("size = ${primes.size}")
    var result = 0

    for (i in 0..primes.size - 2)
//    val i = 5
//
//    var x = primes[i] * primes[i+1]
//    x += nextPowerTen(primes[i]) - x % nextPowerTen(primes[i]) + primes[i]
//    println(x)

     {
        var smallest = primes[i]

        do {
            smallest += nextPowerTen(primes[i])
        } while (smallest % primes[i + 1] != 0)

        result += smallest
    }

    println("Result: $result")

//    println(primes.subList(primes.size - 10, primes.size))


}

private fun nextPowerTen(n : Int) : Int {
    var result = 1
    var i = n
    while (i > 0) {
        i /= 10
        result *= 10
    }
    return result
}