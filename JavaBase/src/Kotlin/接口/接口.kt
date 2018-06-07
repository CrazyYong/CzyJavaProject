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