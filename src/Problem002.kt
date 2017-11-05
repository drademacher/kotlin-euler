fun main(args: Array<String>) {
    var a = 1
    var b = 2
    var result = 0

    while (a < 4e6) {
        if (a % 2 == 0) {
            result += a
        }

        val temp = a
        a = b
        b += temp
    }

    print("Result: " + result)

}