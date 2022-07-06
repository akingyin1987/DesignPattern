package com.akingyin.algorithm

import java.util.*
import kotlin.random.Random

/**
 * TODO冒泡排序 时间复杂度 O(N*N)
 *
 */
class BubbleSort {

    fun bubbleSort(arr:IntArray){
        if(arr.size < 2){
            return
        }

        for(e in arr.size-1 downTo 0){
            //从左到右找到 找到 0-i 的最大数
            for (i in 0 until e){
                if(arr[i] > arr[i+1]){
                    //如果当前位置的数据 大于后面个位置的数据则 往右移
                    swap(arr,i,i+1)
                }
            }
        }
    }

    /**
     * TODO将I 位置与J 位置数据交换
     *
     * @param arr
     * @param i
     * @param j
     */
    private fun swap(arr: IntArray,i:Int ,j:Int){
        val temp  = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
    }
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            val  arr = IntArray(4000)
            val random = Random.Default
            for (i in arr.indices){
                arr[i] =  random.nextInt(1,2000)
            }
            var  time  = System.currentTimeMillis()
            BubbleSort().bubbleSort(arr)
            println("arr sort1=${arr.contentToString()}")
            println("time=${System.currentTimeMillis()-time}")

            time = System.currentTimeMillis()
            Arrays.sort(arr)
            println("time2=${System.currentTimeMillis()-time}")
            println("arr sort2=${arr.contentToString()}")
        }
    }
}