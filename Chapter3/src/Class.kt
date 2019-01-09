class Customer2
{
    val name: String
        get() = "Bill"

    var value:Int = 20
        get() = field
        set(value)
        {
            println("value属性被设置")
            field = value
        }
}



fun main(args: Array<String>){
    var c = Customer2()
    c.value = 30
    println(c.value)
}