package com.akingyin

object Test {
    @JvmStatic
    fun main(args: Array<String>) {

        /**
         * 筒右移无符号移动一位，即相当于除2
         */
       val a  = -2 ushr 1


        /**
         * 向右移去一位，除2 带符号
         */
        val b  = -2 shr 1
        println("a=$a,b=$b")
        println(Int.MAX_VALUE)
    }
}