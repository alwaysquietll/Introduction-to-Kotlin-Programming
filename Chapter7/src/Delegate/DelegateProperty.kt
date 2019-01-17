package Delegate

import kotlin.reflect.KProperty

class Delegate
{
    var name:String = ""
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String
    {
        val className = thisRef.toString().substringBefore('@')
        println("${className}.get已经被调用")
        return name
    }
    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String)
    {
        val className = thisRef.toString().substringBefore('@')
        println("${className}.set已经被调用")
        name = value
    }
}
class MyClass1
{
    /*var name:String = ""
    get():String
    {
        println("MyClass1.get已经被调用")
        return field
    }
    set(value:String) {
        println("MyClass1.set已经被调用")
        field = value
    }*/
    var name:String by Delegate()
}
class MyClass2
{
    /*var name:String = ""
        get():String
        {
            println("MyClass2.get已经被调用")
            return field
        }
        set(value:String) {
            println("MyClass2.set已经被调用")
            field = value
        }*/
    var name:String by Delegate()
}
fun main(args: Array<String>)
{
    var c1 = MyClass1()
    var c2 = MyClass2()
    c1.name = "Bill"
    c2.name = "Mike"
    println(c1.name)
    println(c2.name)
}