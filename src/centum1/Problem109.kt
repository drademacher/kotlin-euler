package centum1

fun main(args: Array<String>) {
    val scores = (1..20).toList() + 25
    val outs = scores.map { 2 * it }
    val darts = scores + scores.map { 2 * it } + (1..20).map { 3 * it }

    var result = 0

    result += outs.size

    for (fst in 0 until 62) {
        result += outs.filter { darts[fst] + it < 100 }.size
        result += (fst until 62).sumBy { snd -> outs.filter { darts[fst] + darts[snd] + it < 100 }.size }
    }

    println("Result: $result")
}

