val Boolean.int
    get() = if (this) 1 else 0

private data class Dart(
        val num : Int,
        val multi: Int) {
    val value : Int
        get() = num * multi

    override fun toString() : String = if (multi in 1..3) "" + "SDT"[multi - 1] + num else "invalid"
}

val NUMS = (1..20).toList() + 25
//val MULTIS = (1..3).toList()

fun main(args: Array<String>) {
//    val x = Dart(10, 3)
//    println(x)
//    println(NUMS)
//    println(doubleOut(6))

//    println( (6 % 2 == 0).int * 4 )
//    (1..99).forEach( { it -> println("$it: ${doubleOut(it)}") })

    println(doubleOut(170))
//    println("Result: " + ( (1..99).map { it -> doubleOut(it) }.sum() ))
}

private fun doubleOut(n : Int) : Int {
    return NUMS
            .takeWhile { 2 * it <= n }
            .map { it -> score(n - Dart(it, 2).value) }
            .sum()

}

private fun score(n : Int) : Int {
    if (n == 0) {
        return 1
    }

//    println("$n ${oneDarters(n)}")

//    println("! $n")
//    (1..(n-1)/2).forEach({it -> println("$it, ${n- it}: " + (oneDarters(it) * oneDarters(n- it))) } )
    return oneDarters(n) + (1..(n-1)/2).sumBy { oneDarters(it) * oneDarters(n- it) } + (n % 2 == 0).int * (oneDarters(n/2) + (oneDarters(n/2) + (oneDarters(n/2) - 1)) / 2)
}

private fun oneDarters(n : Int) : Int {
    var result = 0

    if (n in NUMS) result++
    if (n % 2 == 0 && n / 2 in NUMS) result++
    if (n % 3 == 0 && n / 3 in NUMS) result++

    return result
}
