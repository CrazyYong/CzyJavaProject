package Kotlin

/**
 * Created by czy on 2018/6/1.
 */

/***
 * 可以使用下划线使数字常量更易读：
 */
val oneMillion = 1_000_000
val creditCardNumber = 1234_5678_9012_3456L
val socialSecurityNumber = 999_99_9999L
val hexBytes = 0xFF_EC_DE_5E
val bytes = 0b11010010_01101001_10010100_10010010

fun main(args: Array<String>) {
    test2()
}

/**
 * 在 Java 平台数字是物理存储为 JVM 的原生类型，除非我们需要一个可空的引用（如 Int?）或泛型。
 * 后者情况下会把数字装箱。注意数字装箱不必保留同一性:
 */
fun test1(){
    val a: Int = 10000
    print(a === a) // 输出“true”
    val boxedA: Int?= a
    val anotherBoxedA: Int?= a
    print(boxedA === anotherBoxedA) // ！！！输出“false”！！！
}

fun test2(){
    val a: Int = 10000
    print(a == a) // 输出“true”
    val boxedA: Int? = a
    val anotherBoxedA: Int? = a
    print(boxedA == anotherBoxedA) // 输出“true”
}
