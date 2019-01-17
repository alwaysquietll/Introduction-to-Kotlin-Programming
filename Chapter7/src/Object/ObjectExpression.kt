package Object

open class MyClass(name: String)
{
    open var name = name
    open fun verify()
    {
        println("verify")
    }
}
interface MyInterface
{
    fun closeData()
    {
        println("closeData")
    }
}
fun process(obj: MyClass)
{
    obj.verify()
    if (obj is MyInterface)
    {
        obj.closeData()
    }
}
fun foo()
{
    val adHoc = object
    {
        var x:Int = 0
        var y:Int = 0
    }
    print(adHoc.x + adHoc.y)
}
fun main(args:Array<String>)
{
    process(object: MyClass("Bill"),MyInterface{
        override fun verify() {
            println("object verify")
        }
    })
}