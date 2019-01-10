package Extend

class MyClass
{
    var mValue:Int = 0
    var str:String = ""
        get() = field
        set(value) {
            field = value
        }
}
var MyClass.value:Int
    get() = mValue
    set(value)
    {
        mValue = value
    }
fun main(args: Array<String>)
{
    var myClass = MyClass()
    myClass.str = "hello"
    myClass.value = 400
    println(myClass.str)
    println(myClass.value)
}