package DataClass


fun main(args: Array<String>)
{
    val john = User(name = "john", age = 30)
    val olderJohn = john.copy(age = 60)
    println(john)
    println(olderJohn)
}