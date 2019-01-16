package TypeProjection

class Array<T>(val size: Int)
{
    fun get(index: Int){}
    fun set(index: Int, value: T) {/*..*/}
    fun copy(from: Array<out Any>, to: Array<Any>)
    {
        assert(from.size == to.size)
    }
}