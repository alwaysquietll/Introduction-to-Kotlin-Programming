package Extend

open class Parent(val value1:Int, val value2:Int)
{
    var mValue1: Int = value1
    var mValue2: Int = value2
    fun add():Int
    {
        return mValue1 + mValue2
    }
}
class Child(value1: Int, value2: Int): Parent(value1, value2)
{
    fun sub(): Int
    {
        return mValue1 - mValue2
    }
}
fun Parent.printResult()
{
    println("${mValue1} + ${mValue2} = ${add()}")
}
fun Child.printResult()
{
    println("${mValue1} - ${mValue2} = ${sub()}")
}

fun main(args: Array<String>)
{
    var parent1: Parent = Parent(1,2)
    var parent2: Parent = Child(1,2)
    parent1.printResult()
    parent2.printResult()
}