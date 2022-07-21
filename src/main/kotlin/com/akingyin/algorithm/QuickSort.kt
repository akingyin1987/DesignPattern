package com.akingyin.algorithm

import java.util.*
import kotlin.random.Random

/**
 * TODO快排，采用荷兰国旗问题
 * 将指定一个数据M，小于 m 在数组 左边，等于 m 在数组中间  大于m 在数据右边
 */
class QuickSort {


    fun quickSort(arr: IntArray,L:Int,R:Int){
        if(L < R){
            swap(arr,L+ (Math.random() *(R - L +1)).toInt(),R)
            val p  = partition(arr, L, R)
            //小于区域
            quickSort(arr, L, p[0]-1)

            //大于区域
            quickSort(arr,p[1]+1,R)
        }
    }

    /**
     * TODO
     * 默认以 arr[r] 做划分,
     * 返回等于区域(左边界，右边界)，返回一个长度为2的数组 res,res[0] res[1]
     * @param arr
     * @param L
     * @param R
     * @return
     */
    private fun partition(arr:IntArray,L:Int,R:Int):IntArray{
        //当前数组的游标
        var  index  = L

        //小于区域的右边界
        var less = L-1
        //大于区域的左边界
        var  more = R

        println("arr sort11=${arr.contentToString()},L=${L},R=${R}")
        while (index < more){
            if(arr[index] < arr[R]){
                //当前数 小于指定划分 的数，则将当前数与 最小区域的下一个数据进行交换 ，游标进入下一个继续判断
                swap(arr,++less,index++)
                println("arr sort33=${arr.contentToString()}")
            }else if(arr[index] > arr[R]){
                //当前数 大于 指定 划分值 ，则将当前数 与 最大区域的上一个数进行交换，游标不变
                swap(arr,--more,index)
                println("arr sort44=${arr.contentToString()}")
            }else{
                //相等则继续下一个
                index++
            }
        }

        swap(arr,more,R)
        println("arr sort22=${arr.contentToString()}")
        return intArrayOf(less+1,more)
    }

    private fun swap(arr: IntArray,i:Int ,j:Int){
        val temp  = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
    }
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            val  arr = IntArray(10)
            val random = Random.Default
            for (i in arr.indices){
                arr[i] =  random.nextInt(1,2000)
            }
            println("arr sort0=${arr.contentToString()}")
            var  time  = System.currentTimeMillis()
            QuickSort().quickSort(arr,0,arr.size-1)
            println("time=${System.currentTimeMillis()-time}")
            println("arr sort1=${arr.contentToString()}")
            time = System.currentTimeMillis()
            Arrays.sort(arr)
            println("time2=${System.currentTimeMillis()-time}")
            println("arr sort2=${arr.contentToString()}")
        }
    }
}