package com.akingyin

fun main() {
    val  str = "wangYe  is Ok"

    str.run {
        // 匿名函数
        println("it=${this}")
    }
    // str.run（具名函数）
   val result  = str.run(::isStrOk)
    result.run(::println)
    println("result=${result}")

   val result2 = str.apply(::isStrOk)
   println("result2=${result2}")

    //这也是具名函数
    with(str,::isStrOk)
    with(str){
        println(this)
    }

    str.takeIf {
        it.contains("OK")
    }?.let {
        println(it)
    }
}

fun  isStrOk(string: String) = string.length >5