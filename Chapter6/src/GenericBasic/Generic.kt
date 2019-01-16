package GenericBasic

class Box<T>(t: T)
{
    var value = t
}
fun main(args: Array<String>)
{
    var box1:Box<Int> = Box(20)
    var box2:Box<String> = Box("Bill")
    println(box1.value)
    println(box2.value)
}