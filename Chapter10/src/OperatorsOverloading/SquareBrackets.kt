package OperatorsOverloading

operator fun Array<Any>.get(i:Int):Int{
    if (this[i] is Int){
        return this[i] as Int
    }
    else if (this[i] is String){
        try {
            return this[i].toString().toInt()
        }catch (e:Exception){}
    }
    return 0
}
operator fun Array<Array<Any>>.get(i:Int,j:Int):Int{
    if (this[i][j] is Int){
        return this[i][j] as Int
    }else if (this[i][j] is String){
        try {
            return this[i][j].toString().toInt()
        }catch (e:Exception){}
    }
    return 0
}
fun main(args: Array<String>){
    var arr1:Array<Any> = arrayOf("5","4","c")
    var arr2:Array<Any> = arrayOf("x","5","z")
    var arr:Array<Array<Any>> = arrayOf(arr1, arr2)
    println("arr1[1] = ${arr1[1]} arr1[2] = ${arr1[2]} arr[1,0] = ${arr[1,0]} arr[0,0] = ${arr[0,0]}")
}