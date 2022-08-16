package com.akingyin.list

import java.util.TreeMap

/**
 * 在hash 表中 如果 key 是基础类型 则会复制做为key
 * 对于有序非基础类型需要提供比较器
 *位与（&）：二元运算符，两个为1时结果为1，否则为0
位或（|）：二元运算符，两个其中有一个为1时结果就为1，否则为0
位异或（^）：二元运算符，两个数同时为1或0时结果为1，否则为0
位取非（~）：一元运算符，取反操作
左移（<<）：一元运算符，按位左移一定的位置。高位溢出，低位补符号位，符号位不变。
右移（>>）：一元运算符，按位右移一定的位置。高位补符号位，符号位不变，低位溢出。
无符号右移（>>>）：一元运算符，符号位（即最高位）保留，其它位置向右移动，高位补零，低位溢出。

 */
class HashAndTree {



    fun testTree(){

        //展示有序表常用操作
        val treeMap = TreeMap<Int,String>()
        treeMap[1] = "我是1"
        treeMap[5] = "我是5"
        treeMap[4] = "我是4"
        treeMap[3] = "我是3"
        treeMap[9] = "我是9"
        treeMap[2] = "我是2"
        println(treeMap.containsKey(5))
        println(treeMap[5])
        println("firstKey 最小的key=${treeMap.firstKey()}")
        println("lastKey 最大的key=${treeMap.lastKey()}")
        println("floorKey 返回小于等于给定key 的最大键=${treeMap.floorKey(100)}")
        println("ceilingKey 返回大于等于给定key 的最小键=${treeMap.ceilingKey(1)}")
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            HashAndTree().testTree()
        }
    }
}