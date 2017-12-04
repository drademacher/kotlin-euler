package centum0

import combine

fun main(args: Array<String>) {
    val result = (1..350).toList().combine((1..350))
            .filter { it.first >= it.second }
            .map { pair -> Pair(pair, Math.abs(rectangles(pair.first, pair.second) - 2000000)) }
            .minBy { pair -> pair.second }
            ?.first

//    val result = rectangles(3, 2)

    if (result != null) {
        println("Result: ${result.first * result.second}")
    }

}

private fun rectangles(x: Int, y: Int): Int {
    var result = 0
    for (i in (1..y)) {
        for (j in (1..x)) {
            result += (y + 1 - i) * (x + 1 - j)
        }
    }

    return result

//    return (1..x).toList().combine((1..y)).map { pair -> (y / pair.second) * (x - pair.first + 1) }.sum()
}