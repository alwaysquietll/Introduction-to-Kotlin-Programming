package FunctionRange

fun saveFile(){
    var fn:String
    fn = "text.txt"
    fun getFullFileName():String{
        return "/users/${fn}"
    }
    var filename = getFullFileName()
    println("${filename} 已经保存成功")
}