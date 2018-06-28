package Kotlin

val arrayOfInt:IntArray = intArrayOf(1,2,3,4)
val arrayOfChar:CharArray= charArrayOf('H','e','l','l')
val arrayofString:Array<String> = arrayOf("我","是","码农")

val FINAL_HELLO_WORLD:String="Hello World"
var helloWorld:String= FINAL_HELLO_WORLD
var nullHelloWorld:String?=helloWorld
var helloWorldArray:Array<String> = arrayOf("H","e","l","l","o")
var helloWorldCharArray:CharArray = charArrayOf('H','e','l','l')
var helloWorldLength:Int=helloWorld.length
var helloWorldLengthLong:Long=helloWorldLength.toLong()



fun main(args: Array<String>) {
    print(arrayOfChar.size)
    for(i in arrayOfInt){
        print(i)
    }

    print(arrayOfInt[1])

    print("final hello world"+ FINAL_HELLO_WORLD)
}