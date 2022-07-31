package com.akingyin.algorithm

import java.util.Arrays
import kotlin.random.Random

/**
 * TODO选择排序 时间复杂度 O(N*N)
 *是一种简单直观的排序算法。
 *
 * 第一次从待排序的数据元素中选出最小（或最大）的一个元素，存放在序列的起始位置，
 * 然后再从剩余的未排序元素中寻找到最小（大）元素，然后放到已排序的序列的末尾。
 * 以此类推，直到全部待排序的数据元素的个数为零。选择排序是不稳定的排序方法
 */
class SelectionSort {

    fun  selectionSort(arr : IntArray){
       if(arr.size < 2){
           return
       }
        arr.forEachIndexed { index, v ->
            var minIndex  = index
            var minValue  = v
            //获取最小值,将当前数据与后面所有数据比较
            for (j in index+1 until arr.size){
                minIndex =  if(arr[j] < minValue) j else minIndex
                if(minIndex != index){
                    minValue = arr[minIndex]
                }
            }
            if(minIndex != index){
                //获取到最新的最小值 ，将当前位置与最新最小值进行交换
                swap(arr,index,minIndex)
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
            SelectionSort().selectionSort(arr)
            println("time=${System.currentTimeMillis()-time}")

            time = System.currentTimeMillis()
            Arrays.sort(arr)
            println("time2=${System.currentTimeMillis()-time}")
            println("arr sort2=${arr.contentToString()}")
        }
    }
}