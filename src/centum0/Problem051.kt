package centum0

import getPrimeTester


fun main(args: Array<String>) {
    val n = 1e6.toInt() - 1
//    val low = 1e5.toInt()
//    val high = 1e6.toInt() - 1
    var result = n

    val check = getPrimeTester(n)


    for (i in 2..5) {
        for (j in i+1..5) {
//            println("$i $j")
        }
    }

//    for (k in 100..999) {
//        println(k)
//    }

    println(insert(123, 2, 3, 9))
}



private fun insert(n : Int, i : Int, j : Int, l : Int) : Int {
    val result = n
    return -1
}



