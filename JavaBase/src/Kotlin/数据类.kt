package Kotlin

/**
 * Created by czy on 2018/6/11.
 */

/**
 * 在 JVM 中，如果生成的类需要含有一个无参的构造函数，则所有的属性必须指定默认值。
 */
data class User(val name: String = "", val age: Int = 0){

}



data class Person(val name: String) {
    var age: Int = 0

    //复制
    /**
     * 在很多情况下，我们需要复制一个对象改变它的一些属性，但其余部分保持不变。
     * copy() 函数就是为此而生成。对于上文的 User 类，其实现会类似下面这样：。
     */
    fun copy(name: String = this.name, age: Int = this.age) = User(name, age)
}


fun main(args: Array<String>) {
    //sampleStart
    val person1 = Person("John")
    val person2 = Person("John")

    person1.age = 10
    person2.age = 20
    //sampleEnd

    println("person1 == person2: ${person1 == person2}")
    println("person1 with age ${person1.age}: ${person1}")
    println("person2 with age ${person2.age}: ${person2}")


    val jack = User(name = "Jack", age = 1)
    val olderJack = jack.copy(age = 2)



    val jane = User("Jane", 35)
    val (name, age) = jane
    println("$name, $age years of age") // 输出 "Jane, 35 years of age"
}


