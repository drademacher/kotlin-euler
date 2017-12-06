package centum1

fun main(args: Array<String>) {
    val n = 99
    val singles = (1..20).toList() + 25
    val doubles = singles.map { 2 * it }
    val trebles = (1..20).map { 3 * it }
    val darts = singles + doubles + trebles

    var result = 0

    // outs with 1 dart
    result += doubles.size

    for (fst in 0 until darts.size) {
        // outs with 2 darts
        result += doubles
                .filter { darts[fst] + it <= n }
                .size

        // outs with 3 darts
        for (snd in fst until darts.size) {
            result += doubles
                    .filter { darts[fst] + darts[snd] + it <= 99 }
                    .size
        }

    }

    println("Result: $result")
}

