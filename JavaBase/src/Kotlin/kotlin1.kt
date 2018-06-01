package Kotlin

/**
 * Created by czy on 2018/6/1.
 */


fun main(args: Array<String>) {

    fun printLength(obj:Any){
        print("'$obj' string length is ${getStringLength(obj) ?: "... err, not a string"} ")
    }
//    printLength("Incomprehensibilities")
//    printLength(1000)


    val items=listOf("apple","banbana","kewida")
    for(item in items.indices){
        print(item)
    }


    for(a in 1..5){
        print(a)
    }
}


fun getStringLength(obj:Any):Int?{
    if(obj is String){
        return obj.length
    }

    return null
}