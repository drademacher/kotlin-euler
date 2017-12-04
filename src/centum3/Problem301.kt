package centum3

typealias IntTriple = Triple<Int, Int, Int>

fun main(args: Array<String>) {
    fun X(fst: Int, snd: Int, trd: Int): Boolean {
        if (fst == 0 && snd == 0 && trd == 0) {
            return false
        }

        return true
    }

    println(X(0, 0, 0))

}
