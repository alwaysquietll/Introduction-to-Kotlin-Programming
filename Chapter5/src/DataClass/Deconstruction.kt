package DataClass

fun main(args: Array<String>)
{
    val jane = User("Jane", 35)
    val (name, age) = jane
    println("$name, $age years of age")
}