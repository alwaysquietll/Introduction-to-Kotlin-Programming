//主构造器以及初始化成员属性
class Person(firstName: String) {
    var name = firstName
    init {
        println(firstName)
    }
}

//声明第二构造器
class Person1 {
    constructor(parent: Person1) {
        println(parent)
    }
}

//主构造器和第二构造器演示
class QACommunity(var url: String)
{
    init {
        println(url)
    }
    constructor(value: Int):this("geekori.com")
    {
        println(value)
    }
    constructor(description: String, url:String):this("[" + url + "]")
    {
        println(description + ":" + url)
    }
    constructor():this(20)
    {
        println("<https://geekori.com>")
    }
}

//Singleton模式
class Singleton private constructor()
{
    public var value:Singleton? = null
    private object mHolder { val INSTANCE = Singleton()}
    companion object Factory {
        fun getInstance(): Singleton
        {
            return mHolder.INSTANCE;
        }
    }
}

//带默认参数的函数
class Customer(val customerName: String = "Bill", var value: Float = 20.4F)
{

}

fun main(args: Array<String>)
{
    QACommunity("https://geekori.com")
    QACommunity(100)
    QACommunity("IT问答社区", "https://geekori.com")
    QACommunity()

    var obj1 = Singleton.getInstance()
    var obj2 = Singleton.getInstance()
    println(obj1)
    println(obj2)

    Customer()
}