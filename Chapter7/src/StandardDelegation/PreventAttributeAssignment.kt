package StandardDelegation

import kotlin.properties.Delegates

class User1{
    var name: String by Delegates.vetoable("Mike")
    {
        prop, old, new ->
        println("旧值： $old 新值： $new")
        var result = true
        if (new.equals("Mary"))
        {
            result = false
            println("name属性值不能是Mary")
        }
        result
    }
}
fun main(args: Array<String>){
    val user = User1()
    user.name = "Bill"
    println(user.name)
    user.name = "Mary"
    println(user.name)
}