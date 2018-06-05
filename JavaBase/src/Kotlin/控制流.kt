package Kotlin

/**
 * Created by czy on 2018/6/4.
 */


var a:Int=10
var b:Int=20

fun main(args: Array<String>) {
    test1()
}


fun test1(){
    // 传统用法
    var c = a
    if (a < b) c = b

// With else
    var d: Int
    if (a > b) {
        d = a
    } else {
        d = b
    }

// 作为表达式
    val max = if (a > b) a else b
}