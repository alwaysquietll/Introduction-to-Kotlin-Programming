package ValueRange

fun main(args:Array<String>){
    for (i in 1..10 step 2){
        println(i*i)
    }
    for (i in 10 downTo 1 step 3){
        println(i*i)
    }
    for (i in 1 until 10){
        println(i)
    }
}