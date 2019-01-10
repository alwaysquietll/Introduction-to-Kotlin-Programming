package Extend

class D {
    fun bar()
    {
        println("D.bar")
    }
}
class C {
    fun baz()
    {
        println("C.baz")
    }
    fun D.foo()
    {
        bar()
        baz()
    }
    fun caller(d: D)
    {
        d.foo()
    }
}

fun main(args: Array<String>)
{
    C().caller(D())
}