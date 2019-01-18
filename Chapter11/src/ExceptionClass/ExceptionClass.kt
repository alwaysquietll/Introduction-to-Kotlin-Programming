package ExceptionClass

fun main(args: Array<String>){
    try {
        throw Exception("这是错误信息")
    }catch (e: Exception){
        println(e.message)
    }finally {
        println("finally" +
                "")
    }
}