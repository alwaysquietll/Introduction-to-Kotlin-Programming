open class Parent
{
    open var name:String = "Bill"

    get()
    {
        println("获得Parent.name属性值")
        return field
    }
}
open class Child:Parent()
{
    override var name:String = "Mike"
    get()
    {
        println("获取Child.name属性值")
        return field
    }
    set(value)
    {
        field = value
        println("Child.name被写入")
    }
}
fun main(args: Array<String>)
{
    var child = Child();
    child.name = "John"
    println(child.name)
}