package Reflection

class Person1(val value:String, val num:Int){
    fun process(){
        println("value:${value} num:${num}")
    }
}
fun main(args: Array<String>){
    var p = Person1::process
    p.invoke(Person1("abc",20))
    var method = Person1::class.java.getMethod("process")
    method.invoke(Person1("Bill", 30))
}