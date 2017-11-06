// wolfram alpha:
// sum (50 - i choose i) for i = 1 to 25
// + sum (50 - 2i choose i) for i = 1 to 16
// + sum (50 - 3i choose i) for i = 1 to 12

fun main(args: Array<String>) {
    val result = F(50, 2) + F(50, 3 ) + F(50, 4)

    println("Result: " + result)
}

private fun F(n : Int, t : Int) : Long {
    return (1..(n/t)).map { binomial(n - (t-1) * it, it).toLong() }.sum()
}