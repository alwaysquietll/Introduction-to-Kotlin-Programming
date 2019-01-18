package TypeCheckingAndTypeConversion

fun demo(x: Any){
    if (x is String){
        print(x.length)
    }
}
fun main(args: Array<String>){
    var x:Any = "abc"
    when(x){
        is Int -> print(x + 1)
        is String -> print(x.length + 1)
        is IntArray -> print(x.sum())
    }
}