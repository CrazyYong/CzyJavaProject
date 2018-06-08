package Kotlin.接口

import javax.swing.text.Position

/**
 * Created by czy on 2018/6/7.
 */

interface MyInterface {
    fun bar()
    fun foo() {
        // 可选的方法体
    }
}

class Child : MyInterface {
    override fun bar() {
        // 方法体
    }
}

//interface MyInterface {
//    val prop: Int // 抽象的
//
//    val propertyWithImplementation: String
//        get() = "foo"
//
//    fun foo() {
//        print(prop)
//    }
//}
//
//class Child : MyInterface {
//    override val prop: Int = 29
//}

//接口继承
interface Named {
    val name: String
}

interface Person : Named {
    val firstName: String
    val lastName: String

    override val name: String get() = "$firstName $lastName"
}

data class Employee(
        // 不必实现“name”
        override val firstName: String,
        override val lastName: String,
        val position: Position
) : Person



//解决覆盖冲突
interface A {
    fun foo() { print("A") }
    fun bar()
}


interface B {
    fun foo() { print("B") }
    fun bar() { print("bar") }
}

class C : A {
    override fun foo() {
        super.foo()
    }
    override fun bar() { print("bar") }
}

class D : A, B {
    override fun foo() {
        super<A>.foo()
        super<B>.foo()
    }

    override fun bar() {
        super<B>.bar()
    }
}