package Kotlin

class girl(age:String,state:String,voice:String):man(age,state,voice)

class boy(age:String,state:String,voice:String):man(age,state,voice)

open class man(var age:String,var state:String,var voice:String){
    init {
        print("new了一个${this.javaClass.simpleName},年纪$age，状态$state,声音$voice")
    }
}


fun main(args: Array<String>) {
    val oneGirl:girl= girl("20","好","甜美")
    print(oneGirl is man)
}