package com.akingyin.list



/**
 * 链表
 *
 */
class ListNode<V> {
    /**
     * 单链表节点
     *
     * @param V
     */
    class Node<V>{
        var value:V?= null
        var next:Node<V>?=null
    }


    /**
     * 返转单列表
     *
     * @param head 传入链表头部参数
     * @return
     */
    fun reverseList(head:Node<V>):Node<V>{
        //用于表示反转后链表的第一个结束 ，也就是返转之前的head
        var last  = head
        //当前关联的下一个指针
        var cur  = head.next
        var  temp :Node<V>?= null
        while (null != cur){
           temp  = cur
           cur = cur.next
           temp.next = last
           last = temp

        }
        //之前head 变为尾 next 指针需要清除
        head.next = null
        return  last
    }

    fun reverseList2(head:Node<V>):Node<V>?{

        //当前node
        var cur:Node<V>?  = head
        //之前Node
        var pre :Node<V>?= null
        // 当前下一个（当前node 下一个指针）
        var curNext :Node<V>?= null
        // 返回的新head
        var newHead:Node<V>?= null
        while (null != cur){
            curNext = cur.next
            if(null == curNext){
                //当前已是最后一个
                newHead = cur
            }

            cur.next = pre
            pre = cur
            cur = curNext

        }

        return  newHead
    }


    /**
     * 双向链表每个节点结构
     * 需要关联上一个，下一个
     * @param V
     */
    class NodeDouble<V>{
        var value:V?= null
        var next:NodeDouble<V>?=null
        var last:NodeDouble<V>?= null
    }

    /**
     * 返转双向列表
     *
     * @param head 传入链表头部参数
     * @return
     */
    fun reverseDoubleList(head:NodeDouble<V>):NodeDouble<V>{
        //用于表示反转后链表的第一个结束 ，也就是返转之前的head
        var last  = head
        //当前关联的下一个
        var curNext  = head.next

        var  temp :NodeDouble<V>?= null
        while (null != curNext){
            temp  = curNext
            curNext = curNext.next

            temp.next = last
            temp.last = curNext
            last = temp

        }
        //之前head 变为尾 next 指针需要清除
        head.last = head.next
        head.next = null

        return  last
    }


    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            val list = mutableListOf<Node<String>>()
            for(i in 0..10){
                list.add(Node<String>().apply {
                    value = "value${i}"
                })
            }
            for (i in list.indices){
                if(i < list.size - 1){
                    list[i].next = list[i+1]
                }


            }
            list.forEach {
                println(it.value+":"+it.next?.value)
            }
            ListNode<String>().reverseList2(list[0])
            println("-----------------------------")
            list.forEach {
                println(it.value+":"+it.next?.value)
            }
            println("-------------double----------------")
            val listDouble = mutableListOf<NodeDouble<String>>()
            for(i in 0..10){
                listDouble.add(NodeDouble<String>().apply {
                    value = "value${i}"
                })
            }
            for (i in listDouble.indices){
                if(i < listDouble.size - 1){
                    listDouble[i].next = listDouble[i+1]
                }
                if(i>0){
                    listDouble[i].last = listDouble[i-1]
                }

            }
            listDouble.forEach {
                println(it.last?.value+":"+it.value+":"+it.next?.value)
            }
            ListNode<String>().reverseDoubleList(listDouble[0])
            println("-----------------------------")
            listDouble.forEach {
                println(it.last?.value+":"+it.value+":"+it.next?.value)
            }
        }
    }
}