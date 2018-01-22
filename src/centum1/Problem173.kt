package centum1

fun main(args: Array<String>) {
    val n = 1e6.toInt()
    val m = n/8+1

    val cummulativeOdd = IntArray(m)
    cummulativeOdd[0] = squareBorderOdd(1)
    for (i in 2..m) {
        cummulativeOdd[i-1] = cummulativeOdd[i-2] + squareBorderOdd(i)
    }

    val cummulativeEven = IntArray(m)
    cummulativeEven[0] = squareBorderEven(1)
    for (i in 2..m) {
        cummulativeEven[i-1] = cummulativeEven[i-2] + squareBorderEven(i)
    }


    var result = 0
    for (stop in 0 until m) {
        for (start in stop-1 downTo 0) {
            if (cummulativeOdd[stop] - cummulativeOdd[start] > n) {
                break
            }
            result += 1
        }
    }

    for (stop in 0 until m) {
        for (start in stop-1 downTo 0) {
            if (cummulativeEven[stop] - cummulativeEven[start] > n) {
                break
            }
            result += 1
        }
    }

    println("Result: $result")
}

private fun squareBorderOdd(i : Int) = 4 * (2 * i - 1)
private fun squareBorderEven(i : Int) = if (i == 1) 1 else 4 * (2 * i - 2)