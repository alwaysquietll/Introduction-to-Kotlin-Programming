class QACommunity2
{
    //schema参数有默认值
    fun printQACommunity2(url: String,schema:String = "https")
    {
        println("${schema}://${url}")
    }
}

class Person2(name:String)
{
    private var mName:String = name
    fun getName():String
    {
        return mName
    }
}

class Persons
{
    fun addPersons(vararg persons: Person2):List<Person2> {
        val result = ArrayList<Person2>()
        for (person in persons)
            result.add(person)
        return result
    }
}

fun main(args: Array<String>)
{
    QACommunity2().printQACommunity2("geekori.com")

    var persons = Persons().addPersons(Person2("Bill"), Person2("Mike"), Person2("John"))
            for(person in persons)
            {
                println(person.getName())
            }
}