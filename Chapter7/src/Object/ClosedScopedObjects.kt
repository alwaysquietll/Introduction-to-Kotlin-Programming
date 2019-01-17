package Object

open class MyClass2()
{
    open fun test()
    {}
}

fun process(obj: MyClass2){
    obj.test()
}

fun main(args: Array<String>)
{
    var n = 20
    process(object:MyClass2(){
        override fun test() {
            if(n == 20)
            {
                println("success")
                n = 30
            }
            else
            {
                println("failed")
            }
        }
    })
}