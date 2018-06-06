package Kotlin.类与继承

/**
 * Created by czy on 2018/6/6.
 */

/**
 * 派生类中的代码可以使用 super 关键字调用其超类的函数与属性访问器的实现：
 */
open class Foo1 {
    open fun f() { println("Foo.f()") }
    open val x: Int get() = 1
}

class Bar : Foo1() {
    override fun f() {
        super.f()
        println("Bar.f()")
    }

    override val x: Int get() = super.x + 1
}


/***
 * 在一个内部类中访问外部类的超类，可以通过由外部类名限定的 super 关键字来实现：super@Outer：
 */
class Bar2 : Foo1() {
    override fun f() { /* …… */ }
    override val x: Int get() = 0

    inner class Baz1 {
        fun g() {
            super@Bar2.f() // 调用 Foo 实现的 f()
            println(super@Bar2.x) // 使用 Foo 实现的 x 的 getter
        }
    }
}