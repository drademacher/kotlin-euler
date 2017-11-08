package centum0

fun main(args: Array<String>) {
    var result = 0
    (100..999).forEach { i ->
        (100..999)
                .asSequence()
                .filter { palindrome(i * it) && i * it > result }
                .forEach { result = i * it }
    }

    println("Result: " + result)

}

fun palindrome(n: Int): Boolean {
    val s = n.toString()
    return s == s.reversed()
}