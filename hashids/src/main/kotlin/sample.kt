import org.hashids.Hashids

fun main() {
    val hashids = Hashids("this is my salt")
    val hash: String = hashids.encode(12345)
    println(hash)
    println(hashids.decode(hash)[0])
}