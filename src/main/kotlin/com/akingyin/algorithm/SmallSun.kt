package com.akingyin.algorithm

import java.util.*
import kotlin.random.Random

/**
 * TODO 小和排序法
 *求小和的意思是将数组中每一个数左边比它小的数累积起来，称为小和
 */
class SmallSun {


    /**
     * TODO
     * 即要排序 也要求小和
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private fun  process(arr:IntArray,l:Int,r:Int):Int{
        if(l  == r){
            return  0
        }
        //计算中间值
        val mid  = l + ((r-l) shr 1)
        return process(arr,mid+1,r) + process(arr,l,mid)+merge(arr, l, mid, r)
    }

    /**
     * TODO
     *求小和
     * @param arr
     * @param l
     * @param mid
     * @param r
     * @return
     */
    private fun  merge(arr: IntArray ,l:Int,mid:Int,r:Int):Int{
        val help = IntArray(r-l +1)
        var  i  = 0
        var p1 = l
        var p2 = mid+1
        var res = 0

        //如果 左右指针没有越界
        while (p1 <= mid && p2 <= r){
            /**
             * 如果左指针的数字小与右指针的数字，那么就去计算右指针及其后面的长度（假设为n），那么小和的值为n*左指针的值
             * (r - p2 +1)计算出个数
             */
            res += if (arr[p1] < arr[p2]) (r - p2 + 1) * arr[p1] else 0

             //进行排序（如果相等必须要先让右边部分进去，为了方便计算长度）
            help[i++] = if( arr[p1] < arr[p2]) arr[p1++] else arr[p2++]
        }

        //这两步是如果上面的操作完成后有多余的数字，那么把他依次填入数组进行排序
        while (p1 <= mid){
            help[i++] = arr[p1++]
        }
        while (p2<= r){
            help[i++] = arr[p2++]
        }

        //复制数组
        help.forEachIndexed { index, i ->
            arr[l+index] = help[index]
        }
        return  res
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
            println(SmallSun().process(arr,0,arr.size-1))
            println("arr sort1=${arr.contentToString()}")
            Arrays.sort(arr)

            println("arr sort2=${arr.contentToString()}")
        }
    }
}