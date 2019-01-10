package Extend

open class D0 {

}
class D1 : D0() {

}
open class C0 {
    open fun D0.foo() {
        println("D0.foo in C")
    }

    open fun D1.foo() {
        println("D1.foo in C")
    }

    fun caller(d: D0) {
        d.foo()
    }
}
class C1 : C0() {
    override fun D0.foo() {
        println("D0.foo in C1")
    }
    override fun D1.foo() {
        println("D1.foo in C1")
    }
}
fun main(args: Array<String>)
{
    C0().caller(D0())
    C1().caller(D0())
    C0().caller(D1())
}