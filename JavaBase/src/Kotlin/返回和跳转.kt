package Kotlin

/**
 * Created by czy on 2018/6/5.
 */

fun main(args: Array<String>) {

    loop@ for (i in 1..100) {
        for (j in 1..100) {
            if (j==10) break@loop
        }
    }
   print(foo() )
}


fun foo() {
    listOf(1, 2, 3, 4, 5).forEach {
        if (it == 3) return // 非局部直接返回到 foo() 的调用者
        print(it)
    }
    println("this point is unreachable")
}

fun foo1() {
    listOf(1, 2, 3, 4, 5).forEach lit@{
        if (it == 3) return@lit // 局部返回到该 lambda 表达式的调用者，即 forEach 循环
        print(it)
    }
    print(" done with explicit label")
}
