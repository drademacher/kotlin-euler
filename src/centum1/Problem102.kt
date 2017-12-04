package centum1

import java.io.File

fun main(args: Array<String>) {
//    private int isRightOf(Point p, Point q, Point r) {
//        double d = (r.getX() - p.getX()) * (q.getY() - p.getY()) - (r.getY() - p.getY()) * (q.getX() - p.getX());
////        double determinant = p.getX() * q.getY() - p.getX() * r.getY() - p.getY() * q.getX() + p.getY() * r.getX() + q.getX() * r.getY() - q.getY() * r.getX();
////        System.out.println(Math.signum(d));
//        return (int) Math.signum(d);
//    }

//    data class Point(val x : Int, val y : Int)

    fun isRightOf(x1: Int, y1: Int, x2: Int, y2: Int) = Math.signum((y1 * (x2 - x1) - x1 * (y2 - y1)).toDouble()).toInt()

    fun containsOrigin(coords: List<Int>): Boolean {
        if (coords.size != 6) println("err")

        val a = isRightOf(coords[0], coords[1], coords[2], coords[3])
        val b = isRightOf(coords[2], coords[3], coords[4], coords[5])
        val c = isRightOf(coords[4], coords[5], coords[0], coords[1])
        if (a == 0 || b == 0 || c == 0) println("origin is on the border, not interior!")

        return a == b && b == c
    }

    val triangles = File("res/p102_triangles.txt").readText()
            .split("\n").filter { it != "" }
            .map { it.split(",").map { it.toInt() } }

    println("Result: ${triangles.filter { containsOrigin(it) }.size}")
}