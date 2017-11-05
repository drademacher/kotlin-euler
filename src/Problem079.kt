import java.io.File.separator
import java.util.Collections.copy

fun main(args: Array<String>) {
    // raw input file
    val rawFile = "319,680,180,690,129,620,762,689,762,318,368,710,720,710,629,168,160,689,716,731,736,729,316,729,729,710,769,290,719,680,318,389,162,289,162,718,729,319,790,680,890,362,319,760,316,729,380,319,728,716"

    // comfort definitions
    val file = rawFile.split(",").toSet().map { it.toCharArray() }
    val usedKeys = rawFile.filter { it != ',' }.toList().distinct()
    val id : (Char) -> Int = {c -> usedKeys.indexOf(c)}





    var result = (1..usedKeys.size).toMutableList()



//    println(usedKeys)



    // noob assumption: length = usedKeys.size

    var swapOccured = true
    while (swapOccured) {
//        println("iter")
        swapOccured = false
        for (three in file) {
            if (result[id(three[0])] > result[id(three[1])]) {
                val temp = result[id(three[0])]
                result[id(three[0])] = result[id(three[1])]
                result[id(three[1])] = temp
                swapOccured = true
            }

            if (result[id(three[1])] > result[id(three[2])]) {
                val temp = result[id(three[1])]
                result[id(three[1])] = result[id(three[2])]
                result[id(three[2])] = temp
                swapOccured = true
            }

            if (result[id(three[0])] > result[id(three[2])]) {
                val temp = result[id(three[0])]
                result[id(three[0])] = result[id(three[2])]
                result[id(three[2])] = temp
                swapOccured = true
            }
        }
    }

    var output = usedKeys.toMutableList()


    //
    for (c in usedKeys) {
        println(c + " - " + result[id(c)])
    }

    println(result[id('3')])
    println("Result: " + result)


    // THE ANSWER IS 73162890

}