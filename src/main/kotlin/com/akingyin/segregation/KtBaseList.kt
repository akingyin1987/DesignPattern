package com.akingyin.segregation

import java.util.Collections

/**
 *
 * 主构造函数，临时的输入类型不能直接用
 * @constructor
 *
 *
 * @param _name
 * @param _sex
 * @param _age
 * @param _info
 */
class KtBaseList (_name:String,_sex:Char,_age:Int,_info:String){

    var info = _info
        get() = field //get 方法不可以被 私有化
        private set(value) {
           field = value
       }

    fun showInfo(){
        requireNotNull(info)
    }
}

class KtBaseList1(var name:String,var sex:Char,age:Int,info:String){
    fun showInfo(){
        name ="2"
    }
    init {
        println("name=${name}")
    }
}

fun main() {
    test1()
}


/**
 * 当前生成java 代码是不会有 number2 的属性定义，这属于计算属性 的功能 只会生成 getNumber2() 的方法，因为number2 的属性根本用不上
 */
val number2:Int
  get() = (1 ..1000).shuffled().first()

fun test2(){

  val  str ="123"
    str.let {

    }

}

fun test1(){
    val list = listOf("A","B","C","D")
    list.forEach {
        println(it)
    }
    for (i in list){
        println(i)
    }
    list.forEachIndexed { index, s ->
        println("index=${index},s=${s}")
    }
    list.binarySearch {
        it.compareTo("B")
    }.let {
        println("index=$it")
    }
    println(list[0])
    println(list.getOrNull(5))
    println(list.getOrElse(5){
        1
    })
}