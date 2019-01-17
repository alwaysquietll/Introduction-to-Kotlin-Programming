package StandardDelegation

class User2(var map:Map<String, Any>){
    val name: String by map
    val age: Int     by map
}
fun main(args: Array<String>){
    var map = mapOf(
            "name" to "John",
            "age" to 25
    )
    val user = User2(map)
    println(user.name)
    println(user.age)
}