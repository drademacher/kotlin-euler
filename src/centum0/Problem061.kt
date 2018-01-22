package centum0

import kotlin.system.exitProcess

fun main(args: Array<String>) {
    val six = 6
    val rng = (0 until six)

    val fns = arrayOf({ n: Int -> n * (n + 1) / 2 },
            { n: Int -> n * n },
            { n: Int -> n * (3 * n - 1) / 2 },
            { n: Int -> n * (2 * n - 1) },
            { n: Int -> n * (5 * n - 3) / 2 },
            { n: Int -> n * (3 * n - 2) }
    ).take(six)


    val nums = fns.map { fn ->
        (1..9999)
                .map { fn(it) }
                .filter { it in 1000..9999 }
    }
    val totalnums = nums
            .flatten()
            .toSet()

    val arrays = fns.map {
        (1000..9999)
                .map { false }
                .toBooleanArray()
    }

    rng.forEach { i ->
        nums[i].forEach { it ->
            arrays[i][it - 1000] = true
        }
    }

    fun cycle(n: Int) = totalnums.filter { it in 100 * (n % 100)..100 * (n % 100) + 99 }


    val choice = IntArray(six)
    val open = BooleanArray(six, { true })


    var count = 0
    fun backtrack(n: Int) {
        if (n == six) {
            if (choice[0] in cycle(choice[six-1])) {
//                println(choice.toList())
                println("Result: ${choice.sum()}")
                exitProcess(0)
            }
            return
        }

        val range = if (n == 0) {
            totalnums
        } else {
            cycle(choice[n - 1])
        }

        for (num in range) {
            for (c in rng) {
                if (arrays[c][num - 1000] && open[c]) {
                    choice[n] = num
                    open[c] = false
                    backtrack(n + 1)
                    open[c] = true
                }
            }

        }

    }

    backtrack(0)
}