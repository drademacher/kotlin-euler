package centum0

fun main(args: Array<String>) {
    val memo = HashMap<Pair<Int, Int>, Int>()

    fun backtrack(n: Int, upper: Int): Int {
        if (n == 0) {
            return 1
        }

        if (Pair(n, upper) in memo) {
            return memo[Pair(n, upper)]!!
        }
        val result = (1..minOf(n, upper)).sumBy { backtrack(n - it, minOf(upper, it)) }
        memo[Pair(n, upper)] = result
        return result
    }

    println("Return: " + backtrack(100, 99))
}