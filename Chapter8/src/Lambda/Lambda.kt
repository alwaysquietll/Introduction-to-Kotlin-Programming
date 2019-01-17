package Lambda

fun <T>max(collection: Collection<T>, less: (T, T) -> Boolean): T?{
    var max: T? = null
    for (it in collection)
        if (max == null || less(max, it))
            max = it
    return max
}