import java.io.File
import java.util.*

// COMPLETELY BUGGY !!!!!!!!!!!!

fun main(args: Array<String>) {
    // IMPORTANT: Int.MAX_VALUE causes overflows
    val MAX_VALUE = 1000000


    val file = File("res/p107_network.txt").readText()
            .split("\n").filter { it != "" }
            .map { it.split(",").map { if (it == "-") MAX_VALUE else it.toInt() } }


    val size = 40
    var result = 0

    val V = BooleanArray(size, { false })
    val S = IntArray(size, { MAX_VALUE })
    S[0] = 0

    val frontier = PriorityQueue<Int>(1, { a, b -> S[a] - S[b] })
    frontier.add(0)

    while (frontier.isNotEmpty()) {
        val cur = frontier.poll()
        if (V[cur]) {
            continue
        }
        V[cur] = true

        result += S[cur]
        println(S[cur])


        (0 until size).forEach { e ->
            if (file[cur][e] < S[e]) {
                S[e] = file[cur][e]
                frontier.add(e)
            }

        }

    }

    // MST weight is 2153
    println("Result: " + (result)) // file.flatten().filter { it < MAX_VALUE }.sum() / 2 -  result
}