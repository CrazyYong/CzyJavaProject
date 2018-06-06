package Kotlin.类与继承

/**
 * Created by czy on 2018/6/6.
 */
//sampleStart
open class Base1(val name: String) {

    init { println("Initializing Base") }

    open val size: Int =
            name.length.also { println("Initializing size in Base: $it") }
}

class Derived1(
        name: String,
        val lastName: String
) : Base1(name.capitalize().also { println("Argument for Base: $it") }) {

    init { println("Initializing Derived") }

    override val size: Int =
            (super.size + lastName.length).also { println("Initializing size in Derived: $it") }
}
//sampleEnd

fun main(args: Array<String>) {
    println("Constructing Derived(\"hello\", \"world\")")
    val d = Derived1("hello", "world")
}