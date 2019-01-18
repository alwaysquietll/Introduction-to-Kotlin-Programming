package OperatorsOverloading

class MyString{
    var value:String = "hello"
    override fun toString(): String {
        return value
    }
}
operator fun MyString.timesAssign(n:Int):Unit{
    val v = this.value
    for (i in 1..n - 1){
        this.value += v
    }
}
fun main(args: Array<String>){
    val c = MyString()
    c.value = "<https://geekori.com>"
    c *= 3
    print(c)
}