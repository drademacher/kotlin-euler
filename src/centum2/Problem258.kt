package centum2

fun main(args: Array<String>) {
    val mod = 20092010

    val len = 3 // 2001
    val lagged = IntArray(len, { 1 })

    val n = 1000000000000

    for (i in len..n) {
        var ind = (i % len).toInt()
        lagged[ind] = (lagged[(ind + len - 1) % len] + lagged[(ind + len - 2) % len]) % mod
//        println(lagged.toList())
    }

    println("Result : ${lagged[(n % len).toInt()]}")

}