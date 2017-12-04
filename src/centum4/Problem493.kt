package centum4

import binomial

fun main(args: Array<String>) {
    val poss = (2..7).map { computePossibilities(it) }
    val expected = poss.zip((2..7)).map { pair -> pair.second * pair.first }.sum().toDouble() / poss.sum()

    println("Result: $expected")

//    println("Res: " + )
}

private fun computePossibilities(balls: Int): Long {
    var result = 0L
    val current = arrayOf(0, 0, 0, 0, 0, 0, 0)


    fun backtrack(k: Int, i: Int, residual: Int) {
        if (i == k) {
            if (residual == 0) {
                result += current.map { binomial(10, it).toLong() }.reduce { acc, l -> acc * l }
            }

            return
        }

        for (j in (1..minOf(10, residual))) {
            current[i] = j
            backtrack(k, i + 1, residual - j)
        }

    }

    backtrack(balls, 0, 20)
    return binomial(7, balls).toLong() * result
//    return backtrack(balls, 0)
}