package centum1

fun main(args: Array<String>) {
    val n = 1e7.toInt()
    var divs = IntArray(n+1, {1})

    for (i in 2..n) {
        for (j in i..n step i) {
            divs[j] += 1
        }
    }

    var result = 0
    for (i in 1 until n) {
        if (divs[i] == divs[i+1]) {
            result += 1
        }
    }
    println("Result: $result")
//
//    println("14: ${divs[14]}")
//    println("15: ${divs[15]}")
}