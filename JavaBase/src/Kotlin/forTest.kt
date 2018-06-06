package Kotlin

/**
 * Created by czy on 2018/6/5.
 */

fun main(args: Array<String>) {

    val asc = Array(5, { i -> (i * i).toString() })
    for(item in asc){
        print("item is $item\n")
    }

    for (i in 1..3){
        print(i)
    }

    for(i in 6 downTo 0 step 2){
        print(i)
    }

    for (i in asc.indices) {
        println(asc[i])
    }

    for ((index, value) in asc.withIndex()) {
        println("the element at $index is $value")
    }



}


