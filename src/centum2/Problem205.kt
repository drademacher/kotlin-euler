package centum2

fun main(args: Array<String>) {
    val colin = IntArray(37, {0})
    val peter = IntArray(37, {0})


    fun backtrackC(i : Int, acc : Int) {
        if (i == 6) {
            colin[acc]++
            return
        }

        (1..6).forEach { j -> backtrackC(i+1, acc+j) }
    }
    fun backtrackP(i : Int, acc : Int) {
        if (i == 9) {
            peter[acc]++
            return
        }

        (1..4).forEach { j -> backtrackP(i+1, acc+j) }
    }

    backtrackC(0, 0)
    backtrackP(0, 0)

    var total = 0L
    (1..36).forEach({
        i: Int ->  total += peter[i] * colin.take(i).sum()
    })

    println("Result: 0." + "%.7f".format(total.toDouble() / colin.sum() / peter.sum()).substring(2)) //
}
