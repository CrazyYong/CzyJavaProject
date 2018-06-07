package Kotlin.类与继承

/**
 * Created by czy on 2018/6/7.
 */

open class Base2 {
    open fun f() {}
}

abstract class Derived2 : Base2() {
    override abstract fun f()
}