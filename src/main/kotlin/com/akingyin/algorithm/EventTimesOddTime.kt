package com.akingyin.algorithm

class EventTimesOddTime {

    fun printOddTimesNum(arr:IntArray){
        var eor  = 0
        for (i in arr.indices){
            eor  = eor xor arr[i]
        }
        // eor = a^b
        // eor != 0
        // eor 必然 有一个位置上是 1

        // 提取出最右的1  ，任何包含有1的数，通过取反+1 并与
        val rightOne = eor and (eor.inv() + 1)

        var onlyOne = 0//eor1
        arr.forEach {cur->
            if(cur and rightOne == 1){
                onlyOne = onlyOne xor cur
            }
        }
        println("${onlyOne}:"+(eor xor onlyOne))
    }
}