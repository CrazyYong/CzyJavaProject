package Kotlin

/**
 * Created by czy on 2018/6/13.
 */

open class A(x: Int) {
    public open val y: Int = x
}

interface B {
}

fun main(args: Array<String>) {
    // A(1) 子类必须传递参数给父类的构造函数
    val ab: A = object : A(1), B {
        override val y = 15
    }
    print(ab.y)
}