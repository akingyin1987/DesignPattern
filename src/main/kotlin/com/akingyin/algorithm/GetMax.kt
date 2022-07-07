package com.akingyin.algorithm

import kotlin.math.max
import kotlin.random.Random

/**
 * TODO 找到数组中最大值
 *
 */
class GetMax {

    /**
     * TODO
     *求 arr[L--R] 范围上求最大值
     * @param arr
     * @param L
     * @param R
     * @return
     */
    private fun process(arr:IntArray,L:Int,R:Int):Int{
        if(L == R){
            return arr[L]
        }

        // 获取 L 到 R 的中点
        val mid  = L + ((R-L) shr  1)
        val leftMax  = process(arr,L,mid)
        val rightMax  = process(arr,mid+1,R)
        return max(leftMax,rightMax)
    }


    fun getMax(arr: IntArray) = process(arr,0,arr.size-1)

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            val  arr = IntArray(10)
            val random = Random.Default
            for (i in arr.indices){
                arr[i] =  random.nextInt(1,2000)
            }
            println(arr.contentToString())
            println("max=${GetMax().getMax(arr)}")
        }
    }
}