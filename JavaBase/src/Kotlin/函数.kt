package Kotlin

/**
 * Created by czy on 2018/6/12.
 */


/**
 * 如果一个默认参数在一个无默认值的参数之前，那么该默认值只能通过使用命名参数调用该函数来使用：
 */
fun foo(bar: Int = 0, baz: Int) { /* …… */ }



fun main(args: Array<String>) {
    foo(baz = 1) // 使用默认值 bar = 0
}