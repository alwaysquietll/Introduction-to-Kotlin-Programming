package Set

fun main(args:Array<String>){
    val numbers: MutableList<Int> = mutableListOf(1, 2, 3)
    val readOnlyView: List<Int> = numbers
    println(numbers)
    numbers.add(4)
    println(readOnlyView)

    val strings = hashSetOf("a", "b", "c", "c")
    assert(strings.size == 3)
}