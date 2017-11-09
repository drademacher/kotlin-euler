package centum0

import getPrimeTester

fun main(args: Array<String>) {
    val n = 10000000
    val prime = getPrimeTester(10000000)
    val primes = (1..n).filter(prime)

    fun combine(a : Int, b : Int) : Int {
        val digits = Math.ceil(Math.log10(b.toDouble()))
        return a * Math.pow(10.0, digits).toInt() + b
    }

    fun valid(a : Int, b : Int) = prime(combine(a, b)) && prime(combine(b, a))

    for (a in 0..primes.size) {
        for (b in a+1..primes.size) {
            if (!valid(a, b)) continue

            for (c in b+1..primes.size) {
                if (!valid(a, c)) continue
                if (!valid(b, c)) continue

                for (d in c+1..primes.size) {
                    if (!valid(a, d)) continue
                    if (!valid(b, d)) continue
                    if (!valid(c, d)) continue


                    for (e in d+1..primes.size) {
                        if (!valid(a, e)) continue
                        if (!valid(b, e)) continue
                        if (!valid(c, e)) continue
                        if (!valid(d, e)) continue

                        println("Result: ${a+b+c+d+e}")
                        return
                    }
                }
            }
        }
    }


//    println("Result: ${primes[10000]}")
    println(combine(7, 109))
    println(combine(109, 7))

}

