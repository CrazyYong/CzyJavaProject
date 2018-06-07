package Kotlin.属性和字段

/**
 * Created by czy on 2018/6/7.
 */
class Address {
    var name: String = "Garen"
    var street: String ="software 4 root"
    var city: String ="ShenZhen"
    var state: String? ="Good"
    var zip: String ="What"
    var nameStudent: String = "abc"
        get() = field.toUpperCase()
        set(value){
            field = "Name: $value"
        }

    var counter = 0 // the initializer value is written directly to the backing field
        set(value) {
            if (value >= 0)
                field = value
        }

    //延迟初始化属性
    

}

fun copyAddress(address: Address): Address {
    val result = Address() // Kotlin 中没有“new”关键字
    result.name = address.name // 将调用访问器
    result.street = address.street
    // ……
    return result
}