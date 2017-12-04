package centum0

fun main(args: Array<String>) {
    fun digits(n: Double) = Math.ceil(Math.log10(n)).toInt()

    //  add one for case: 1 = 1^n
    var result = emptyList<Double>()

    var x: Double
    for (n in 0..100000) {
        for (base in 2..9) {
            x = Math.pow(base.toDouble(), n.toDouble())

            if (digits(x) == n) {
//                println("x = $base^$n = $x")
                result += x
            }
        }

    }

    println("Result: ${result.distinct().size}")
}