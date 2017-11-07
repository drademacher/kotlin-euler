fun main(args: Array<String>) {
    fun backtrack(n: Int, upper: Int): Int {
        if (n == 0) {
            return 1
        }
        return (1..minOf(n, upper)).sumBy { backtrack(n - it, minOf(upper, it)) }
    }

    println("Return: " + backtrack(100, 99))
}