package Kotlin

import java.lang.Integer.parseInt


fun main(args: Array<String>) {
    tesWhe(5)
    hasPrefix(5)
}



fun tesWhe(x:Int){
    when(x){
        1-> print("x==1")
        2-> print("x==2")

        else->{
            print("x is neither 1 nor 2\n")
        }
    }
//如果很多分支需要用相同的方式处理，则可以把多个分支条件放在一起，用逗号分隔
    when(x){
        0,1-> print("x==0 or x==1")
        else-> print("otherwise\n")
    }

//我们可以用任意表达式（而不只是常量）作为分支条件
    when (x) {
        parseInt("5") -> print("s encodes x\n")
        else -> print("s does not encode x\n")
    }
//我们也可以检测一个值在（in）或者不在（!in）一个区间或者集合中：
    when (x) {
        in 1..10 -> print("x is in the range\n")
        !in 10..20 -> print("x is outside the range\n")
        else -> print("none of the above\n")
    }
}


fun hasPrefix(x: Any) = when(x) {
    is String -> x.startsWith("prefix\n")
    is Int-> print("is Int")
    else -> false
}