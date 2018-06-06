package Kotlin.类与继承

/**
 * Created by czy on 2018/6/6.
 */

/**
 * 初始化块中的代码实际上会成为主构造函数的一部分。委托给主构造函数会作为次构造函数的第一条语句，
 * 因此所有初始化块中的代码都会在次构造函数体之前执行。
 * 即使该类没有主构造函数，这种委托仍会隐式发生，并且仍会执行初始化块
 */
class Constructors{
    init {
        println("Init block")
    }

    constructor(i: Int) {
        println("Constructor")
    }

    fun test11(){
        print("te111")
    }
}

class InitOrderDemo(name: String) {
    val firstProperty = "First property: $name".also(::println)

    init {
        println("First initializer block that prints ${name}")
    }

    val secondProperty = "Second property: ${name.length}".also(::println)

    init {
        println("Second initializer block that prints ${name.length}")
    }
}

/**
 * 在 JVM 上，如果主构造函数的所有的参数都有默认值，编译器会生成 一个额外的无参构造函数，它将使用默认值。
 * 这使得 Kotlin 更易于使用像 Jackson 或者 JPA 这样的通过无参构造函数创建类的实例的库
 */
class Customer(customerName: String = ""){

}

//覆盖方法
/**
 * 我们之前提到过，Kotlin 力求清晰显式。
 * 与 Java 不同，Kotlin 需要显式标注可覆盖的成员（我们称之为开放）和覆盖后的成员：
 */
open class Base {
    open fun v() {}
    fun nv() {}
}

/**
 * Derived.v() 函数上必须加上 override标注。如果没写，编译器将会报错。
 * 如果函数没有标注 open 如 Base.nv()，则子类中不允许定义相同签名的函数，
 * 不论加不加 override。在一个 final 类中（没有用 open 标注的类），开放成员是禁止的。
 */
class Derived() : Base() {
    override fun v() {}
}

/**
 * 标记为 override 的成员本身是开放的，也就是说，它可以在子类中覆盖。
 * 如果你想禁止再次覆盖，使用 final 关键字：
 */
open class AnotherDerived() : Base() {
    final override fun v() {}
}

//覆盖属性
/**
 * 属性覆盖与方法覆盖类似；在超类中声明然后在派生类中重新声明的属性必须以 override 开头，
 * 并且它们必须具有兼容的类型。每个声明的属性可以由具有初始化器的属性或者具有 getter 方法的属性覆盖。
 */
open class Foo {
    open val x: Int get() {

        return 5
    }
}

class Bar1 : Foo() {
    override val x: Int =5
}

fun main(args: Array<String>) {
    val constructors= Constructors(1)
    constructors.test11();
    InitOrderDemo("czy")
    Customer()
    val derived= Derived()
    derived.v()
}