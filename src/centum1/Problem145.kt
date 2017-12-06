package centum1

fun main(args: Array<String>) {
    fun reverse (n : Int) : Int {
        var i = n
        var result = 0
        while (i != 0) {
            result *= 10
            result += i % 10
            i /= 10
        }
        return result
    }

    fun reversible(n : Int) : Boolean {
        if (n % 10 == 0) {
            return false
        }
        var i = n + reverse(n)

        do {
            if (i % 2 == 0) {
                return false
            }
            i /= 10
        } while (i > 0)

        return true
    }

    println("Result: " + (1 until 1000000000).filter { reversible(it) }.size)
}