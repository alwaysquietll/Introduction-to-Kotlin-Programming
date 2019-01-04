fun main(args: Array<String>)
{
    //第一类字符串（与Java类似）
    var s1 = "hello \nworld"
    var s2:String = "世界\n你好"
    println(s1)
    println(s2)
    //第二类字符串，保留原始格式
    var s3 = """
        hello
            world
        I love you.
    """
    println(s3)
    //字符串模版
    s2 = "abc"
    val str = "$s2 的长度是 ${s2.length}"
    println(str)
}