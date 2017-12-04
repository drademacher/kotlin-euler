package centum2

import combine
import memoize


// res: 806844323190414
// solved with wolfram alpha

fun main(args: Array<String>) {

    val width = 9
    val height = 3

    val x = (0..width / 2).toList().combine((0..width / 3))
            .filter { pair -> 2 * pair.first + 3 * pair.second == width }

    print(x)


    fun binary(n: Int) = (Math.pow(2.0, n.toDouble()).toInt() until Math.pow(2.0, (n + 1).toDouble()).toInt())
            .map { Integer.toBinaryString(it).substring(1).toCharArray().map { it - '0' } }

    fun cracks(two: Int, three: Int) = binary(two + three)
            .filter { it.sum() == three }
            .map { it.map { it + 2 } }
            .map {
                it
                        .mapIndexed { index, i -> i + it.take(index).sum() }
                        .dropLast(1)
            }

    val y = x.flatMap { cracks(it.first, it.second) }
    val m = y.size

    val poss = Array(m, { IntArray(0) })
    for (i in 0 until m) {
        poss[i] = (0 until m).filter { y[i].intersect(y[it]).isEmpty() }.toIntArray()
//        println(poss[i].toList())
    }


    var backtrack: (Int, Int) -> Long = { _, _ -> 0 }
    backtrack = { choice: Int, row: Int ->
        if (row <= 1) {
            row.toLong() // poss[choice].size.toLong()
        } else {
            poss[choice].map { backtrack(it, row - 1) }.reduce { acc, l -> (l + acc) }
        }
    }.memoize()

    val result = (0 until m)
            .map { backtrack(it, height) }
            .sum()

    println("Result: $result")
}

