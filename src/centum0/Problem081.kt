package centum0

import java.io.File

fun main(args: Array<String>) {
    val rawFile = File("res/p081_matrix.txt").readText()
    val A = rawFile.split("\n").map { it.split(",").filter { it != "" }.map { it.toInt() } }

    val T = Array(80) { IntArray(80, { Int.MAX_VALUE }) }
    T[0][0] = A[0][0]

    for (k in 1..158) {
        for (i in 0..k) {
            if (i > 79 || k - i > 79) {
                continue
            }

            if (i != 0 && T[i][k - i] > A[i][k - i] + T[i - 1][k - i]) {
                T[i][k - i] = A[i][k - i] + T[i - 1][k - i]
            }

            if (i != k && T[i][k - i] > A[i][k - i] + T[i][k - i - 1]) {
                T[i][k - i] = A[i][k - i] + T[i][k - i - 1]
            }
        }
    }

    println(T[79][79])
}