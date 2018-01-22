package centum0

import java.io.File

// IntArray of exact length 81, just numbers between 0 and 9
private typealias Sudoku = IntArray

fun main(args: Array<String>) {
    val rawFile = File("res/p096_sudoku.txt").readText()
    val file : List<Sudoku> = rawFile
            .split("Grid ")
            .filterNot { it == "" }
            .map { it.drop(3).filter { it.isDigit() }.map { it.toInt() - '0'.toInt()} }
            .map { it.toIntArray() }
    val INDICES : Sudoku = IntArray(81, {it})
//    println(INDICES.toList())


    fun Sudoku.get(x : Int, y : Int) = this[y * 9 + x]
    fun Sudoku.set(x : Int, y : Int, value : Int) {
        this[y * 9 + x] = value
    }


    fun Sudoku.row(r : Int) = this.drop(9 * (r)).take(9)
    fun Sudoku.column(c : Int) = this.filterIndexed { index, _ -> index % 9 == c }
    fun Sudoku.box(b : Int) = this.filterIndexed { index, _ -> (index % 9) / 3 == b % 3 }.drop(9 * (b / 3)).take(9)

    fun rowIndices(r : Int) = INDICES.row(r)
    fun columnIndices(c : Int) = INDICES.column(c)
    fun boxIndices(b : Int) = INDICES.box(b)






    // SOLVER JUST DOING BACKTRACKING
    fun getBox(x : Int, y : Int) = x / 3 + 3 * (y / 3)
    fun possibilities(sudoku: Sudoku, x : Int, y : Int) = when(sudoku.get(x, y)) {
        0 -> (1..9)
                .subtract(sudoku.row(y))
                .subtract(sudoku.column(x))
                .subtract(sudoku.box(getBox(x, y)))
                .toMutableSet()
        else -> mutableSetOf()
    }



    fun solveBacktracking(sudoku: Sudoku) : Sudoku? {
        fun backtrack(sudoku : Sudoku, pos : Int) : Sudoku? {
            if (pos == 81) {
                return sudoku
            }

            val x = pos % 9
            val y = pos / 9

            if(sudoku.get(x, y) != 0) {
                return backtrack(sudoku, pos + 1)
            } else {
                var result: Sudoku?
                for (p in possibilities(sudoku, x, y)) {
                    sudoku.set(x, y, p)
                    result = backtrack(sudoku, pos + 1)
                    if (result != null) return result
                    sudoku.set(x, y, 0)
                }
            }

            return null
        }

        return backtrack(sudoku, 0)
    }


    // FAST SOLVER
    fun solveFast(sudoku: Sudoku) : Sudoku? {
        val poss = Array(81, {it -> possibilities(sudoku, it % 9, it / 9)})

        fun backtrack(sudoku : Sudoku, pos : Int) : Sudoku? {
            if (pos == 81) {
                return sudoku
            }

            val x = pos % 9
            val y = pos / 9

            if(sudoku.get(x, y) != 0) {
                return backtrack(sudoku, pos + 1)
            } else {
                var result: Sudoku?
                for (p in possibilities(sudoku, x, y)) {
                    sudoku.set(x, y, p)
                    result = backtrack(sudoku, pos + 1)
                    if (result != null) return result
                    sudoku.set(x, y, 0)
                }
            }

            return null
        }



        var updated = true
        while (updated) {
            updated = false
            for (i in 0 until poss.size) {
                if (poss[i].size == 1) {
                    updated = true
                    val x = i % 9
                    val y = i / 9
                    val choice = poss[i].first()

                    sudoku.set(x, y, choice)
                    rowIndices(y).forEach { poss[it].remove(choice) }
                    columnIndices(x).forEach { poss[it].remove(choice) }
                    boxIndices(getBox(x, y)).forEach { poss[it].remove(choice) }
                }
            }
        }

//        if (sudoku.contains(0)) {
//            val result = backtrack(sudoku, 0)
//            if (result != null) {
//                return result
//            }
//        }

        return backtrack(sudoku, 0)
    }


//    val fst = file[0]
//    val r = solveFast(fst)
//    if (r != null) {
//        println(r.toList())
//    }



    // COMPUTE NUMBER FOR PROJECT EULER FROM SUDOKU
    var result = 0
    for (sudoku in file) {
        val solved = solveFast(sudoku)
        if (solved != null) {
            result += solved.take(3).map { (it+'0'.toInt()).toChar() }.joinToString(separator = "").toInt()
        }
    }
    println("Result: $result")
}