package FunctionParametersAndReturnValues

fun <T> asList(vararg ts: T, value1:Int, value2:String): List<T>
{
    val result = ArrayList<T>()
    for (t in ts)
        result.add(t)
    println("value1=${value1} value2=${value2}")
    return  result
}

fun main(args: Array<String>){
    var list = asList(1,2,3,value1 = 2,value2 = "abc")
    println(list)
}