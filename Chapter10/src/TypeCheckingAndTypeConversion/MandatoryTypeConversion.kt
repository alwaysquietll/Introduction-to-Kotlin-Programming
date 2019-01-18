package TypeCheckingAndTypeConversion

fun main(args: Array<String>){
    val y:Any? = "abcd"
    val x: Int? = y as? Int?
    print(x)
}