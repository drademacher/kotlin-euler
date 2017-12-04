package centum3

fun main(args: Array<String>) {
    val periodic = 104
    val n = 1000000000000000000L
    val m = (periodic * 100) + (n % periodic)

    val grid = Array(1000, { BooleanArray(1000, { false }) })


    val directions = arrayOf(Pair(0, -1), Pair(1, 0), Pair(0, 1), Pair(-1, 0))

    var ant = Pair(500, 500)
    var dir = 0

    // phase 1 result, takes m time steps
    for (a in 0 until m) {
        dir = if (grid[ant.first][ant.second]) {
            (dir + 3) % 4
        } else {
            (dir + 1) % 4
        }

        grid[ant.first][ant.second] = !grid[ant.first][ant.second]
        ant = Pair(ant.first + directions[dir].first, ant.second + directions[dir].second)
    }
    val phase1 = grid.map { it.filter { it }.count() }.sum()


    // phase 2, takes 104 time steps and is repeated periodically
    for (a in 0 until periodic) {
        dir = if (grid[ant.first][ant.second]) {
            (dir + 3) % 4
        } else {
            (dir + 1) % 4
        }

        grid[ant.first][ant.second] = !grid[ant.first][ant.second]
        ant = Pair(ant.first + directions[dir].first, ant.second + directions[dir].second)
    }
    val phase2 = grid.map { it.filter { it }.count() }.sum() - phase1


    println("Result: ${(n - m) / periodic * phase2 + phase1}")
}
