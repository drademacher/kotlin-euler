package centum1

import getPrimeTester
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    val prime = getPrimeTester(100000)

    fun first(n: Int): Int {
        if (n == 0) {
            return 1
        }
        return 3 * n * (n - 1) + 2
    }

    fun last(n: Int) = first(n + 1) - 1

    data class Hex(val q: Int, val r: Int) {
        private val s: Int
            get() = -q - r

        fun add(other: Hex): Hex {
            return Hex(q + other.q, r + other.r)
        }

        fun sub(other: Hex): Hex {
            return Hex(q - other.q, r - other.r)
        }

        fun mul(scalar: Int): Hex {
            return Hex(q * scalar, r * scalar)
        }

        fun distToOrigin() = (Math.abs(q) + Math.abs(r) + Math.abs(s)) / 2


        override fun toString(): String {
            return "($q, $r)"
        }
    }


    val directions = arrayOf(Hex(-1, +1), Hex(0, +1), Hex(+1, 0), Hex(+1, -1), Hex(0, -1), Hex(-1, 0))

    fun neighbors(hex: Hex) = directions.map { it.add(hex) }


    var outerRingTable = HashMap<Hex, Int>()
    var midRingTable = HashMap<Hex, Int>()
    var innerRingTable = HashMap<Hex, Int>()

    fun lookup(hex: Hex): Int {
        outerRingTable[hex]?.let { return it }
        midRingTable[hex]?.let { return it }
        innerRingTable[hex]?.let { return it }
        return 1
    }


    val maxRing = 50000
    var resCounter = 1
    val resGoal = 10


    var curNum = 2
    for (outerRing in 0..maxRing) {
        innerRingTable = midRingTable
        midRingTable = outerRingTable
        outerRingTable = HashMap()

        var outerHex = directions[4].mul(outerRing)

        for (i in 0 until 6) {
            for (j in 0 until outerRing) {
//                println("$curHex: " + (curHex.q + maxRing) + " - " + (curHex.r + maxRing))
                outerRingTable[outerHex] = curNum

                outerHex = outerHex.add(directions[i])
                curNum += 1
            }
        }

        val midRing = outerRing - 1
        var midHex = directions[4].mul(midRing)

        for (i in 0 until 6) {
            for (j in 0 until midRing) {
//                println("${lookup(midHex)}: ${neighbors(midHex).map { lookup(it) }}")
                val pd = neighbors(midHex).map { Math.abs(lookup(it) - lookup(midHex)) }.filter(prime).size
                if (pd == 3) {
                    println("- ${lookup(midHex)}")
                    resCounter += 1
//                    println(resCounter)
                    if (resCounter == resGoal) {
                        println("Result: ${lookup(midHex)}")
                        exitProcess(0)
                    }
                }


                midHex = midHex.add(directions[i])
            }
        }
    }

    println("failed at $resCounter, missed by ${resGoal - resCounter}")


//    (0..5).map { first(it) }.forEach { println(it) }


}