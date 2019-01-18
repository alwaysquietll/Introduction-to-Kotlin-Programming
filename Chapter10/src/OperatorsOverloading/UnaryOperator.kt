package OperatorsOverloading

operator fun String.inc():String{
    return this + this
}

fun main(args: Array<String>){
    var str1 = "x"
    var str2 = "y"
    println(str1++)
    println(str1)
    println(++str2)
}