package StandardDelegation

import kotlin.properties.Delegates

class User
{
    var name: String by Delegates.observable("Mike") {
        prop, old, new ->
        println("旧值： $old 新值： $new")
    }
}
fun main(args: Array<String>)
{
    val user = User()
    user.name = "Bill"
    user.name = "John"
}