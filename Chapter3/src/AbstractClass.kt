open class Base {
    open fun f() {}
}
abstract class Derived : Base() {
    override abstract fun f() 
}