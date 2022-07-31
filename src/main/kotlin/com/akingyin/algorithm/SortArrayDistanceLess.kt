package com.akingyin.algorithm

import java.util.*


class SortArrayDistanceLess {

    /**
     * TODO通过距离放小跟堆，
     *
     * @param array
     * @param k
     */
    fun sortedArrDistanceLess(array: IntArray,k:Int){
        var  index  = 0
        //系统默认的小根堆，每次插入或删除都会对队列 进行调整，使用得队列始终构成最小堆
        val heap = PriorityQueue<Int>()
        //默认把小于k 的数放入小根堆
        while (index <= array.size.coerceAtMost(k)) {
            heap.add(array[index])
            index++
        }

        var i = 0
        //把大于 k 位置面 放入小根堆，并弹
        while (index < array.size) {
            heap.add(array[index])
            array[i] = heap.poll()
            i++
            index++
        }
        while (!heap.isEmpty()) {
            array[i] = heap.poll()
        }
    }
}