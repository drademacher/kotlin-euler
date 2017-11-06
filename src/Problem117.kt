fun main(args: Array<String>) {
    val n = 50

    val maxRed = n / 2
    val maxGreen = n / 3
    val maxBlue = n / 4

    var result = 0L

    for (r in 0..maxRed) {
        for (g in 0..maxGreen) {
            for (b in 0..maxBlue) {
                if (2 * r + 3 * g + 4 * b > n) {
                    continue
                }

                result += binomial(n - r - 2 * g - 3 * b, r + g + b).toLong() * binomial(r + g + b, r).toLong() * binomial(g + b, g).toLong()
            }
        }
    }
    println(result)
}