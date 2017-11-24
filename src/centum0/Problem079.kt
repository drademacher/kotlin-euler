package centum0

import java.util.Collections.sort

fun main(args: Array<String>) {
    // raw input file
    val rawFile = "319,680,180,690,129,620,762,689,762,318,368,710,720,710,629,168,160,689,716,731,736,729,316,729,729,710,769,290,719,680,318,389,162,289,162,718,729,319,790,680,890,362,319,760,316,729,380,319,728,716"

    // comfort definitions
    val file = rawFile.split(",").toSet().map { it.toCharArray() }
    val usedKeys = rawFile.filter { it != ',' }.toList().distinct()
    val id: (Char) -> Int = { c -> usedKeys.indexOf(c) }


    val priorities = (1..usedKeys.size).toMutableList()


    var swapOccurred = true
    while (swapOccurred) {
        swapOccurred = false
        for (three in file) {
            if (priorities[id(three[0])] > priorities[id(three[1])]) {
                val temp = priorities[id(three[0])]
                priorities[id(three[0])] = priorities[id(three[1])]
                priorities[id(three[1])] = temp
                swapOccurred = true
            }

            if (priorities[id(three[1])] > priorities[id(three[2])]) {
                val temp = priorities[id(three[1])]
                priorities[id(three[1])] = priorities[id(three[2])]
                priorities[id(three[2])] = temp
                swapOccurred = true
            }

            if (priorities[id(three[0])] > priorities[id(three[2])]) {
                val temp = priorities[id(three[0])]
                priorities[id(three[0])] = priorities[id(three[2])]
                priorities[id(three[2])] = temp
                swapOccurred = true
            }
        }
    }

    val result = usedKeys.toMutableList()
    sort(result, { a, b -> priorities[id(a)] - priorities[id(b)] })



    println("Result: " + result.map{ it.toString() }.reduce { acc , c -> acc + c })


    // THE ANSWER IS 73162890

}