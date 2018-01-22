package centum1

import binomial

fun main(args: Array<String>) {
    val check = "OOOO OOOA OOOL OOAO OOAA OOAL OOLO OOLA OAOO OAOA OAOL OAAO OAAL OALO OALA OLOO OLOA OLAO OLAA AOOO AOOA AOOL AOAO AOAA AOAL AOLO AOLA AAOO AAOA AAOL AALO AALA ALOO ALOA ALAO ALAA LOOO LOOA LOAO LOAA LAOO LAOA LAAO"
    val num = check.split(" ").filter { it.contains("L") }
    println(num)

    val x = prices(4)
    println("$x")

//    println("0: " + neverLateAndPrice(0))
//    println("1: " + neverLateAndPrice(1))
//    println("2: " + neverLateAndPrice(2))
//    println("3: " + neverLateAndPrice(3))
}

private fun prices(n: Int): Long {
    var result = 0L
    result += neverLateAndPrice(n)
    for (i in 0 until n) {
        val j = (n - 1) - i
        result += neverLateAndPrice(i) * neverLateAndPrice(j)
    }
    return result
}

private fun neverLateAndPrice(n: Int): Long {
//    if (n == 0) return 1
//    if (n == 1) return 2
//    if (n == 2) return 4


    var result = 0L

    for (a in 0..n) {
        val add = binomial(n, a).toLong() - binomial(n - 3, a - 3).toLong() * (n - 2)
        if (add > 0)
            result += add
    }

    // 573808520
    return result

}