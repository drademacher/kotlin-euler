package centum1

fun main(args: Array<String>) {

    val input = arrayOf(Pair("90342", 2), Pair("70794", 0), Pair("39458", 2), Pair("34109", 1), Pair("51545", 2), Pair("12531", 1))
            .sortedBy { pair -> pair.second }
    val n = input.size
    val m = input[0].first.length

//    val n = 16
//    val codes = "5616185650518293,3847439647293047,5855462940810587,9742855507068353,4296849643607543,3174248439465858,4513559094146117,7890971548908067,8157356344118483,2615250744386899,8690095851526254,6375711915077050,6913859173121360,6442889055042768,2321386104303845,2326509471271448,5251583379644322,1748270476758276,4895722652190306,3041631117224635,1841236454324589,2659862637316867".split(",")
//    val correct = intArrayOf(2, 1, 3, 3, 3, 1, 2, 3, 1, 2, 3, 1, 1, 2, 0, 2, 2, 3, 1, 3, 3, 2)
//    val m = codes.size

    println(input)


    var result = CharArray(n)

    fun backtrack(i: Int, guessed: IntArray) {
//        if (i == n) {
//            if (guessed.contentEquals(correct)) {
//                println("Result: ${result.toList()}")
//            }
//            return
//        }
//
//        for (c in '0'..'9') {
////            println("c $c")
//            val next = guessed.copyOf()
//
//            (0 until m)
//                    .filter { codes[it][i] == c }
//                    .forEach { next[it] += 1 }
//
//            if ((0 until m).any { next[it] > correct[it] }) {
////                println("wow")
//                continue
//            }
//            result[i] = c
//            backtrack(i+1, next)
//        }
    }

    backtrack(0, IntArray(m, { 0 }))
//    println("Result: ${result.toList()}")
}