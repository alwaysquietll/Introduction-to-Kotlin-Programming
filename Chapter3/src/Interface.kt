interface MyInterface
{
    fun process()
    fun getName():String {
        return "Bill"
    }
}
class MyClass:MyInterface
{
    override fun process() {
        println("process")
    }

    override fun getName(): String {
        return "Mike"
    }
}
fun main(args: Array<String>){
    println(MyClass().getName())
    MyClass().process()
}