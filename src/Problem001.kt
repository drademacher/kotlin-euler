fun main(args: Array<String>) {
    val result = (1 .. 999)
            .filter { it % 3 == 0 || it % 5 == 0 }
            .sum()
    print(result)
}