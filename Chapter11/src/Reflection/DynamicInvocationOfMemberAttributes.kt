package Reflection

class Person2{
    var name:String = "Bill"
    get() = field
    set(v){
        field = v
    }
}
fun main(args: Array<String>){
    var person = Person2()
    var name = Person2::name
    println(name.get(person))
    name.set(person, "Mike")
    println(name.get(person))
    var getName = Person2::class.java.getMethod("getName")
    var setName = Person2::class.java.getMethod("setName", java.lang.String().javaClass)
    setName.invoke(person, "John")
    println(getName.invoke(person))
}