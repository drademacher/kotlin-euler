

fun main(args: Array<String>) {
    val result = (1..25).map { binomial(50 - it, it).toLong() }.union(
            (1..16).map { binomial(50 - 2 * it, it).toLong() }.union(
                    (1..12).map{ binomial(50 - 3 * it, it).toLong() }
            )
    ).sum()

    println("Result: " + result)
    var x = binomial(10, 20)
    // sum (50 - i choose i) for i = 1 to 25
    // + sum (50 - 2i choose i) for i = 1 to 16
    // + sum (50 - 3i choose i) for i = 1 to 12
}
