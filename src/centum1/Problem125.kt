package centum1

fun main(args: Array<String>) {
    fun reverse (n : Long) : Long {
        var i = n
        var result = 0L
        while (i != 0L) {
            result *= 10L
            result += i % 10
            i /= 10
        }
        return result
    }

    fun palindromic(n : Long) = n == reverse(n)

    val n = 100000000L
    val m = Math.sqrt(n.toDouble() / 2.0).toLong() // biggest two squares have to be lower than n

    val numbers = HashSet<Long>()
    for (i in 1..m) {
        for (j in i+1..m) {
            val num = (i..j).map { it*it }.sum()
            if (num > n) {
                break
            }

            if (palindromic(num)) {
                numbers.add(num)
            }
        }
    }

    println("Result: ${numbers.sum()}")

}
