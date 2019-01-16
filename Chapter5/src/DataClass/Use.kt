package DataClass

data class User(val name: String, var age: Int)

fun main(args: Array<String>)
{
    var user1 = User("Mike", 34)
    var user2 = User("Mike", 34)
    println(user1.equals(user2))
    println(user1)
    println(user2)
}