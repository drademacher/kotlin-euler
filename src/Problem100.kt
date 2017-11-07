fun main(args: Array<String>) {
    for (total in 1L..1000L) {
//        print(total)
//        val poss =
        val red = (0..total).toList().binarySearchBy(0L, selector = {it -> differ(total - it, it)})
//        println(differ(total - red, red))
        if (red > 0) {
            println("" + red + " blue and " + (total - red) + " red")
        }
    }


    println(differ(15, 6))
}

private fun differ(blue: Long, red: Long) : Long {
    return (blue + red) * (blue + red - 1) - 2 * blue * (blue - 1)
}