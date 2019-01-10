package Enum

enum class Direction private constructor (val d:Int)
{
    NORTH(1),SOUTH(2),WEST(3),EAST(4);

    override fun toString(): String {
        return d.toString()
    }
}

fun main(args: Array<String>)
{
    var direction1: Direction = Direction.NORTH
    var direction2 = Direction.WEST
    println(direction1)
    println(direction2)
}