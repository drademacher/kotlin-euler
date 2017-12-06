package centum0

fun main(args: Array<String>) {
    val count = HashMap<String, Int>()

    var i = 1L
    val result : String
    while (true) {
        val num = (i*i*i).toString().toCharArray().sorted().toString()
        count[num] = count.getOrDefault(num, 0) +1
        if (count[num] == 5) {
            result = num
            break
        }
        i += 1
    }

    i = 1L
    while (true) {
        val num = (i*i*i).toString().toCharArray().sorted().toString()
        if (num == result) {
            break
        }
        i += 1
    }

    println("Result: ${i * i * i}")


}