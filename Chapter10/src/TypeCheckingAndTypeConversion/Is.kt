package TypeCheckingAndTypeConversion

open class ParentClass{}
class ChildClass:ParentClass(){}
fun main(args: Array<String>){
    var obj1 = 123
    var obj2 = "hello"
    var c1 = ParentClass()
    var c2 = ChildClass()

    if (c1 is ChildClass){}
    if (c2 is ChildClass){}
    if (c2 is ParentClass){}
    if (c2 is ChildClass){}
    if (obj2 is String){
        println("obj2是Int类型的值")
    }
}