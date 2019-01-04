fun main(args: Array<String>)
{
    //arrayOf函数可以存储任意值的数组
    val arr1 = arrayOf(1, 2, 3, 'a')
    println(arr1[3])
    arr1[2] = 'b'
    println(arr1[2])

    //arrayOfNulls函数定义数组
    var arr2 = arrayOfNulls<Int>(10)
    println("arr2的长度：" + arr2.size)

    //使用Array类的构造器定义数组，其中第二个参数是指初始化每一个数组元素的值
    //每个数组元素的值就是当前数组索引的乘积
    val arr3 = Array(10, { i -> (i * i).toString() })
    println(arr3[3])

    //使用intArrayOf函数定义数组
    var arr4:IntArray = intArrayOf(20,30,40,50,60)
    println("arr4[2] = " + arr4[2] )
}