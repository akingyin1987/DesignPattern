package com.akingyin.algorithm

import java.util.*
import kotlin.random.Random

/**
 * 堆排序
 *是指利用堆这种数据结构所设计的一种排序算法。
 * 堆是一个近似完全二叉树的结构，并同时满足堆积的性质：
 * 即子结点的键值或索引总是小于（或者大于）它的父节点
 */
class HeapSort {


    fun heapSort(arr: IntArray){
        if(arr.size < 2){
            return
        }
        for (i in arr.indices){
            heapInsert(arr,i)
        }
        var heapSize = arr.size
        swap(arr,0,--heapSize)
        while (heapSize > 0){
            heapIfy(arr,0,heapSize)
            swap(arr,0,--heapSize)
        }
    }

    /**
     * 大根堆
     * TODO某个数现在处理在 index 位置，微上继续移动
     * 二叉数获取最大值
     * @param arr
     * @param index
     */
    private fun heapInsert(arr: IntArray, index:Int){
        var  sort  = index
        while (arr[sort] > arr[(sort -1)/2]){
            //当前数大于 父节点数，则直播交换
            swap(arr,sort,(sort-1)/2)
            sort = (sort-1)/2
        }
    }


    /**
     * TODO
     *  大根堆中 去掉一个数后重排
     * @param arr
     * @param index
     * @param heapSize
     */
    private fun  heapIfy(arr: IntArray,index: Int,heapSize:Int){
        var  sort  = index

        //左孩子的下标
        var  left  = sort * 2 +1
        while (left < heapSize){
            //下方还有孩子的时候

            //两个孩子中，谁的值大，把下标给largest
            var largest  = if (left+1 < heapSize && arr[left+1] > arr[left]) left+1 else left

            largest = if(arr[largest] > arr[sort]) largest else sort

            if(largest == sort){
                break
            }
            swap(arr,largest,sort)

            sort = largest
            left = sort *2 +1
        }
    }


    private fun swap(arr: IntArray,i:Int ,j:Int){
        val temp  = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            val  arr = IntArray(40)
            val random = Random.Default
            for (i in arr.indices){
                arr[i] =  random.nextInt(1,2000)
            }
            var  time  = System.currentTimeMillis()
            HeapSort().heapSort(arr)
            println("time=${System.currentTimeMillis()-time}")
            println("arr sort1=${arr.contentToString()}")
            time = System.currentTimeMillis()
            Arrays.sort(arr)
            println("time2=${System.currentTimeMillis()-time}")
            println("arr sort2=${arr.contentToString()}")
        }
    }
}