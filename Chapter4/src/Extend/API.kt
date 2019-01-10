package Extend

fun ArrayList<Int>.swap(index1:Int, index2:Int)
{
    val tmp = this[index1]
    this[index1] = this[index2]
    this[index2] = tmp
}

fun main(args: Array<String>)
{
    var list:ArrayList<Int> = ArrayList()
    list.add(20)
    list.add(30)
    list.add(40)
    list.swap(0,2)
    println(list)
}