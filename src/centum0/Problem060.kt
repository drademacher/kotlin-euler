package centum0

import getPrimeTester

fun main(args: Array<String>) {
    val n = 100000000
    val prime = getPrimeTester(n)
    val primes = (1..n).filter(prime)

    fun combine(a: Int, b: Int): Int {
        val digits = Math.ceil(Math.log10(b.toDouble()))
        return a * Math.pow(10.0, digits).toInt() + b
    }

    fun valid(a: Int, b: Int) = prime(combine(a, b)) && prime(combine(b, a))

    var result = Int.MAX_VALUE
    val cutoff = 10000

//    val set = listOf(13, 5197, 5701, 6733, 8389)
//    for (x in set) {
//        for (y in set) {
//            if (y >= x) continue
//
//            println("$x $y " + valid(x, y))
//        }
//    }

//    println()
//    println(combine(5701, 5197))
//    println(combine(5197, 5701 ))


    for (ai in 0 until primes.size) {
        val a = primes[ai]
        if (a > cutoff || 5 * a > result) break


        for (bi in ai + 1 until primes.size) {
            val b = primes[bi]



            if (a > cutoff || a + 4 * b > result) break



            if (!valid(a, b)) continue

//            if (a == 13 && b == 5197) println("nice ab")

            for (ci in bi + 1 until primes.size) {
                val c = primes[ci]
                if (c > cutoff || a + b + 3 * c > result) break

                if (!valid(a, c)) continue
                if (!valid(b, c)) continue

                for (di in ci + 1 until primes.size) {
                    val d = primes[di]


//                    if (c == 5701) println("nice c")
//                    if (d == 6733) println("nice d")

                    if (d > cutoff || a + b + c + 2 * d > result) break

                    if (!valid(a, d)) continue
                    if (!valid(b, d)) continue
                    if (!valid(c, d)) continue



                    for (ei in di + 1 until primes.size) {
                        val e = primes[ei]


//                        if (a == 13) println("nice a")
//                        if (e == 8389) println("nice e")


                        if (e > cutoff || a + b + c + d + e > result) break

                        if (!valid(a, e)) continue
                        if (!valid(b, e)) continue
                        if (!valid(c, e)) continue
                        if (!valid(d, e)) continue

//                        println("Result: ${a+b+c+d+e}")
                        result = minOf(result, a + b + c + d + e)
//                            return
                    }
                }
            }
        }
    }




    println("Result: $result")

//    println("Result: ${primes[10000]}")
//    println(combine(7, 109))
//    println(combine(109, 7))

}

