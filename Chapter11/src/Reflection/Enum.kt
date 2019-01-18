package Reflection

import kotlin.reflect.full.memberFunctions
import kotlin.reflect.full.memberProperties

class Person(val value:String, val num:Int){
    fun process(){}
}
var c = Person::class
fun main(args: Array<String>){
    println("成员数：" + c.members.size)
    for (member in c.members){
        print(member.name + " " + member.returnType)
        println()
    }
    println("属性个数：" + c.memberProperties.size)
    for (property in c.memberProperties){
        print(property.name + " " + property.returnType)
        println()
    }
    println("函数个数：" + c.memberFunctions.size)
    for (function in c.memberFunctions){
        println(function.name + " " + function.returnType)
    }
}