fun main(args: Array<String>)
{
    var a = 20
    var b = 30
    val max = if (a > b) a else b
    println(max)

    val min = if (a > b) {
        println("Choose a")
        a
    } else {
        println("Choose b")
        b
    }

    var n = 25
    when(n)
    {
        in 1..10 -> println("满足条件")
        in 11..20 -> println("不满足条件")
        !in 30..60 -> println("hello world")
        else->println("条件未知")
    }

    var arr =  intArrayOf(2,4,6,8,10)
    for ((index, value) in arr.withIndex()) {
        println("arr[$index] = " + value)
    }
}