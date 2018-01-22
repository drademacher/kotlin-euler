package centum0

fun main(args: Array<String>) {
    val dice = 6

    var diceListCounter = 0
    val diceList = Array(210, { IntArray(0) })


    val current = IntArray(6)
    fun backtrack(n: Int) {
        when (n) {
            dice -> {
                if (current[n - 1] == 9) {
                    current[n - 1] = 6
                }

                diceList[diceListCounter] = current.copyOf()
                diceListCounter++
            }
            0 -> {
                for (i in (0..9)) {
                    current[n] = i
                    backtrack(n + 1)
                }
            }
            else -> {
                for (i in (current[n - 1] + 1..9)) {
                    current[n] = i
                    backtrack(n + 1)
                }
            }
        }
    }

    backtrack(0)


    var result = 0
    for (i in 0 until diceList.size) {
        for (j in i until diceList.size) {
            if (squaresPossible(diceList[i], diceList[j])) {
                result += 1
            }
        }
    }

    println("Result: $result")

}

private val squares = arrayOf(Pair(0, 1), Pair(0, 4), Pair(0, 6), Pair(1, 6), Pair(2, 5), Pair(3, 6), Pair(4, 6), Pair(6, 4), Pair(8, 1))

private fun squaresPossible(d1: IntArray, d2: IntArray) = squares.none { (it.first !in d1 || it.second !in d2) && (it.first !in d2 || it.second !in d1) }
