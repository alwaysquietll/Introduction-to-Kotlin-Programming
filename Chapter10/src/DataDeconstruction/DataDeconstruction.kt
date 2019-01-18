package DataDeconstruction

data class MyArrayItem(var key:Int, var value:String, var comment: String)
fun valueArray():Collection<MyArrayItem>{
    var result = arrayListOf<MyArrayItem>(MyArrayItem(20, "A", "Comment1"),
            MyArrayItem(30, "B", "Comment2"), MyArrayItem(40, "C", "Comment3"))
    return result
}
fun main(args:Array<String>){
    for ((key, value, comment) in valueArray()){
        println("key = ${key}, value=${value}, comment=${comment}")
    }
}