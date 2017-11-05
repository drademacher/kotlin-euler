import java.io.File
import java.util.PriorityQueue



fun main(args: Array<String>) {
    val rawFile = File("res/p083_matrix.txt").readText()
    val A = rawFile.split("\n").map { it.split(",").filter { it != "" }.map { it.toInt() } }

    // shortest path cost
    val T = Array(80) { IntArray(80, {Int.MAX_VALUE}) }
    T[0][0] = A[0][0]

    // visited flag
    val V = Array(80) { BooleanArray(80, {false}) }

    // frontier
    val frontier = PriorityQueue<Pair<Int, Int>>(100, {a, b -> T[a.first][a.second] - T[b.first][b.second]})
    frontier.add(Pair(0, 0))

    // processing steps
    while (frontier.isNotEmpty()) {
        val cur = frontier.poll()
        if (V[cur.first][cur.second]) {
            continue
        }

        V[cur.first][cur.second] = true
        val value = T[cur.first][cur.second]

        // println("" + cur + ": " + value)

        if (cur.first > 0 && !V[cur.first - 1][cur.second]) {
            frontier.add(Pair(cur.first - 1, cur.second))
            T[cur.first - 1][cur.second] = minOf(T[cur.first - 1][cur.second], value + A[cur.first - 1][cur.second])
        }

        if (cur.first < 79 && !V[cur.first + 1][cur.second]) {
            frontier.add(Pair(cur.first + 1, cur.second))
            T[cur.first + 1][cur.second] = minOf(T[cur.first + 1][cur.second], value + A[cur.first + 1][cur.second])
        }

        if (cur.second > 0 && !V[cur.first][cur.second - 1]) {
            frontier.add(Pair(cur.first, cur.second - 1))
            T[cur.first][cur.second - 1] = minOf(T[cur.first][cur.second - 1], value + A[cur.first][cur.second - 1])
        }

        if (cur.second < 79 && !V[cur.first][cur.second + 1]) {
            frontier.add(Pair(cur.first, cur.second + 1))
            T[cur.first][cur.second + 1] = minOf(T[cur.first][cur.second + 1], value + A[cur.first][cur.second + 1])
        }

    }


    println("Result: " + T[79][79])
}