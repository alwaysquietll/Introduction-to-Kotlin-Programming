package Object

class MyClass1
{
    private fun foo() = object {
        val x: String = "x"
    }

    fun publicFoo() = object
    {
        val x: String = "x"
    }

    fun bar()
    {
        val x1 = foo().x
    }
}