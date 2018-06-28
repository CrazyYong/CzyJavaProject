package Kotlin


fun getName():String?{

    return null
}

fun main(args: Array<String>) {
    val name= getName()?:null
    print(name?.length)

    val value:String? ="HelloWorld"
    print(value!!.length)//!!表示已经信任不为null

}