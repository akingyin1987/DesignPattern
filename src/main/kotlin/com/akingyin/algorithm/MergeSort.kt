package com.akingyin.algorithm

import kotlin.random.Random

/**
 * TODO 递归排序
 *
 */
class MergeSort {

    fun process(array: IntArray,L:Int,R:Int){
        if(L == R){
            return
        }
        val mid = L + ((R-L) shr 1)
        process(array,L,mid)
        process(array,mid+1,R)
        merge(array,L,mid,R)
    }

    private fun merge(array: IntArray, L:Int, M:Int, R:Int){
        val  help  = IntArray(R-L+1)
        var i  = 0
        var p1 = L
        var p2  = M+1
        while (p1<= M && p2 <= R){
            // 比较左右两侧数据大小 小的直接放入 help
            help[i++] = if(array[p1] <= array[p2]) array[p1++] else array[p2++]
        }

        while (p1<= M){
            //当前 p1 （左边数据未处理完，则直接复制到 help）
            help[i++] = array[p1++]
        }
        while(p2 <= R){
            //当前 p2 （右边数据未处理完，则直接复制到 help）
            help[i++] =  array[p2++]
        }
        for (k in help.indices){
            array[L+k] = help[k]
        }
    }


    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            val  arr = IntArray(1000)
            val random = Random.Default
            for (i in arr.indices){
                arr[i] =  random.nextInt(1,2000)
            }
            println(arr.contentToString())
            MergeSort().process(arr,0,arr.size-1)
            println(arr.contentToString())
        }
    }
}