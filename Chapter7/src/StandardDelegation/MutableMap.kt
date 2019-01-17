package StandardDelegation

class User4(var map: MutableMap<String, Any>){
    var name: String by map
    var age: Int     by map
}
fun main(args: Array<String>){
    var mutableMap = mutableMapOf(
            "name" to "Mike",
            "age" to 30
    )
    val user = User4(mutableMap)
    println(user.name)
    println(user.age)
    user.name = "Mary"
    println(mutableMap)
    mutableMap.put("age", 56);
    println(user.age)
}