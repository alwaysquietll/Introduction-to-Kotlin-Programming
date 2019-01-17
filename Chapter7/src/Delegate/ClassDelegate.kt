package Delegate

interface Base
{
    fun print()
}
class BaseImpl(val x: Int) : Base
{
    override fun print() {
        print(x)
    }
}
class Derived(b: Base) : Base by b
{
    fun getName():String
    {
        return "Bill"
    }
}
fun main(args: Array<String>){
    val b = BaseImpl(10)
    Derived(b).print()
}