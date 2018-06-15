package Kotlin

/**
 * Created by czy on 2018/6/11.
 */


fun MutableList<Int>.swap(index1: Int, index2: Int) {
    val tmp = this[index1] // “this”对应该列表
    this[index1] = this[index2]
    this[index2] = tmp
}

//fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
//    val tmp = this[index1] // “this”对应该列表
//    this[index1] = this[index2]
//    this[index2] = tmp
//}

fun main(args: Array<String>) {
    val l = mutableListOf(1, 2, 3)
    l.swap(0, 2) // “swap()”内部的“this”得到“l”的值
}