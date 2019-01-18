package OperatorsOverloading

class MyClass(a:Int, b:Int){
    private var a:Int = a
    private var b:Int = b
    operator fun compareTo(c:MyClass):Int{
        var m = this.a + this.b
        var n = c.a + c.b
        return m - n
    }
    operator override fun equals(other: Any?):Boolean {
        if (other is MyClass){
            var m = this.a + this.b
            var n = other.a + other.b
            return m == n
        }
        return false
    }
}
fun main(args: Array<String>){
    var c1 = MyClass(20,30)
    var c2 = MyClass(40,5)
    var c3 = MyClass(35,15)
    println(c1 > c2)
    println(c1 == c3)
}