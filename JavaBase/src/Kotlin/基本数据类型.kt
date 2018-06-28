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
val aChar:Char='0'
val bChar:Char='中'
val cChar:Char='\u000f'
val string:String="Hello"
val fromChars:String=String(charArrayOf('H','e','l','l','o'))

fun main(args: Array<String>) {
//    test5()
    print(aChar)
    print(bChar)
    print(cChar+"\n")

    print(string== fromChars)
    print(string === fromChars)

    val arg1:Int=0
    val arg2:Int=1
    print("\n"+"$arg1+$arg2=${arg1+arg2}")

    //Hello "Trump"
   val sayHello:String="Hello\"Trump\""
    print(sayHello)

    val salary:Int=1000
    print("\$salary")

    val rawString:String="""
    \t
    \n
    """
    print(rawString)
    print(rawString.length)
}

/**
 * 在 Java 平台数字是物理存储为 JVM 的原生类型，除非我们需要一个可空的引用（如 Int?）或泛型。
 * 后者情况下会把数字装箱。注意数字装箱不必保留同一性:
 */
fun test0(){
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

/**
 * 创建一个 Array<String> 初始化为 ["0", "1", "4", "9", "16"]
 */
fun test3(){
    val asc = Array(5, { i -> (i * i).toString() })
    for(c in asc){
        print(c+" ")
    }

}

fun test4(){
    val x: IntArray = intArrayOf(1, 2, 3)
    x[0] = x[1] + x[2]
    print(x[0])
}


/***
 * 字符串字面值
 * 可以通过 trimMargin() 函数去除前导空格：
 */
fun test5(){
    val s = "Hello, world!\n"
    print(s)

    val text = """
    for (c in "foo")
        print(c)
"""
    print(text)

    val text1 = """
    |Tell me and I forget.
    |Teach me and I remember.
    |Involve me and I learn.
    |(Benjamin Franklin)
    """.trimMargin()
    print(text1)
}

/***
 * 字符串模板
 */

fun test6(){
    val i=10
    println("i = $i") // 输出“i = 10”

    val s = "abc"
    println("$s.length is ${s.length}") // 输出“abc.length is 3”


    //原始字符串和转义字符串内部都支持模板。 如果你需要在原始字符串中表示字面值 $ 字符（它不支持反斜杠转义）
    val price = """ ${'$'}9.99"""
    print(price)
}