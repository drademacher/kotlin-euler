package centum3

fun main(args: Array<String>) {
    val n = 50

    val lose = BooleanArray(n + 1, { false })
    val win = BooleanArray(n + 1, { false })
    lose[0] = true
    lose[1] = true
    win[2] = true
    win[3] = true


    for (i in 4..n) {
//        win[i] = 1
        for (k in 0..i - 2) {
            if (win[k] == win[i - 2 - k]) {
                win[i] = true
//                println("nice")
            }
        }

//        lose[i] = (0..i-2)
//                .takeWhile { it <= i - 2 - it }
//                .all { ( lose[it] && win[i - 2 - it] ) || ( lose[i - 2 - it] && win[it] )  }
//
//        println("$i ${lose[i]}") //  + (0..(i-2)/2).map { Pair(it, i-2-it) })
        // map { it -> lose[it] != win[i - 2 - it] })
//
//        {
//
//                lose[i] = false
//                println("fail")
//            }
//        }

    }
//
//    println("4 ${win[4]}")
//    println("5 ${lose[5]}")

//    (0..n-2).map { Pair(it, n-2-it) }.forEach { println(it) }

    val result = win.filter { it }.count()
    println("Result: $result")
}