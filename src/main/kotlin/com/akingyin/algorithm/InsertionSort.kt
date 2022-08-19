package com.akingyin.algorithm

import java.util.*
import kotlin.random.Random

/**
 * TODO 插入排序 时间复杂度 O(N*N)
 *插入排序，一般也被称为直接插入排序。对于少量元素的排序，它是一个有效的算法
 *  。插入排序是一种最简单的排序方法，它的基本思想是将一个记录插入到已经排好序的有序表中，
 *  从而一个新的、记录数增1的有序表。在其实现过程使用双层循环，
 *  外层循环对除了第一个元素之外的所有元素，
 *  内层循环对当前元素前面有序表进行待插入位置查找，并进行移动
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
     * 异或交换（陷阱不能给a,b传入同一片地址的变量）
     * a=a^b;b=a^b;a=a^b;
     * 异或运算法则为：a⊕a=0；a⊕b=b⊕a；a⊕b⊕c=a⊕(b⊕c)=(a⊕b)⊕c；d=a⊕b⊕c可以推出a=d⊕b⊕c；a⊕b⊕a=b。异或是一个数学运算符，它应用于逻辑运算，数学符号为“⊕”，计算机符号为“xor”。
    如果a、b两个值不相同，则异或结果为1。如果a、b两个值相同，异或结果为0。
    逻辑异或运算简称异或。英文为exclusive OR，或缩写成xor。
    异或也叫半加运算，其运算法则相当于不带进位的二进制加法：二进制下用1表示真，0表示假，则异或的运算法则为：0⊕0=0，1⊕0=1，0⊕1=1，1⊕1=0（同为0，异为1），这些法则与加法是相同的，只是不带进位，所以异或常被认作不进位加法
     * @param arr
     * @param i
     * @param j
     */
    private fun swap(arr: IntArray,i:Int ,j:Int){
       arr[i] = arr[i] xor arr[j]
       arr[j] =  arr[i] xor arr[j]
       arr[i] = arr[i] xor arr[j]
    }

    /**
     * 通过加减法交换
     *
     * @param i
     * @param j
     */
    private fun swap( i:Int ,j:Int){
       var  a = i -j
       val b = j + a
       a  = b - a

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