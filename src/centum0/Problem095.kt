package centum0

import java.util.*


fun main(args: Array<String>) {
    val n = 1000000

    // calculate all divisors
    val divisors = IntArray(n + 1, { 1 })
    for (i in 2..n) {
        for (j in 2 * i..n step i) { //
            divisors[j] += i
        }
    }


    var maxCycle = 0
    var result = 0

    for (i in 2..n) {
        val visited = HashSet<Int>()

        var k = i
        var cycle = 0
        do {
            visited.add(k)
            k = divisors[k]
            cycle += 1
        } while (i != k && k <= n && !visited.contains(k))

        if (k < n && i == k) {
            if (cycle > maxCycle) {
                maxCycle = cycle
                result = i
            }
        }
    }

    println("Result: $result (len = $maxCycle)")

}