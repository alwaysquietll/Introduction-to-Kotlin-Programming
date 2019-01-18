package OperatorsOverloading

operator fun String.times(other: Any?):String{
    var result = ""
    if (other != null){
        if (other is Int){
            for (i in 1..other){
                result += this
            }
        }
    }
    return result
}
operator fun String.div(other: Any?):String{
    var result = ""
    if (other != null){
        if (other is String){
            return this.replace(other, "")
        }
    }
    return result
}
fun main(args: Array<String>){
    var str1 = "hello"
    println(str1 * 10)
    println(str1 / "l")
}