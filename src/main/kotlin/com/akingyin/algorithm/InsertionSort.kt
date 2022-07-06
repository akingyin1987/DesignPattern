package com.akingyin.algorithm

import java.util.*
import kotlin.random.Random

/**
 * TODO 插入排序 时间复杂度 O(N*N)
 *
 */
class InsertionSort {

    fun  insertionSort(arr:IntArray){
        if(arr.size < 2){
            println("123")
            return
        }
        //0-0位置有序
        //0-i 位置相有序（处理）
        for (i in 1 until arr.size){
            //对0-i 位置进行排序  因为 0-i-1 位置已排序好，即只需要当前I 位置与前面数据依次比较小则进行交换，大则插入指定位置
            for (j in i-1 downTo 0){
                if(arr[j] > arr[j+1]){
                    //说明当前位置数据比之前的小，需要进行交换
                    swap(arr,j,j+1)
                }else{
                    //说明当前位置数据比之前的大，无需再与前面的数据进行比较
                    break
                }
            }
        }
    }

    /**
     * TODO
     * 异或交换
     * a=a^b;b=a^b;a=a^b;
     * @param arr
     * @param i
     * @param j
     */
    private fun swap(arr: IntArray,i:Int ,j:Int){
       arr[i] = arr[i] xor arr[j]
       arr[j] =  arr[i] xor arr[j]
       arr[i] = arr[i] xor arr[j]
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
            InsertionSort().insertionSort(arr)
            println("time=${System.currentTimeMillis()-time}")
            println("arr sort1=${arr.contentToString()}")
            time = System.currentTimeMillis()
            Arrays.sort(arr)
            println("time2=${System.currentTimeMillis()-time}")
            println("arr sort2=${arr.contentToString()}")
        }
    }

}