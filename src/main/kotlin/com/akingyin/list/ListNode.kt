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
     *
     *
     * 快慢指针可以很快的找到链表的中点。
     * 在不知道链表长度的情况下，找到链表的中点，
     *
     * @param head
     */
    fun fastAndSlowPoint(head:Node<V>):Node<V>{
        var  slow:Node<V>?= head
        var  fast:Node<V>?= head
        while (null != slow?.next && null != fast?.next?.next){
            //针对偶时，中心点是有两个，是要前一个或后一个
            slow = slow.next
            fast = fast.next?.next


        }

        println("中点1=${slow?.value}")
        if(null != fast){
            if(null != fast.next && null == fast.next?.next){
                //当前为偶数长度，则有两个中心点
                println("中心点2=${slow?.next?.value}")
            }
        }
        return head
    }

    /**
     * 判断链表是否回文，采用指针快慢法
     * 回文是指正序和逆序均相同的链表，中心点两边数据对称
     * @param head
     * @return
     */
    fun isPail(head: Node<V>):Boolean{
        var  slow:Node<V>?= head
        var  fast:Node<V>?= head
        while (null != slow?.next && null != fast?.next?.next){
            //针对偶时，中心点是有两个，是要前一个或后一个
            slow = slow.next
            fast = fast.next?.next

        }
        var  temp :Node<V>?= null
        //当前下一个
        var  cur :Node<V>?=slow?.next

        var  last :Node<V>?= null

        println("slow=${slow?.value},next=${slow?.next?.value}")

        //修改右侧部分next 指针 倒序
        while (null != cur ){
            temp  = cur
            cur = cur.next
            temp.next = last
            last = temp
        }

        val tempData  = slow?.next
        slow?.next = null

        var leftNode : Node<V>?=head
        var  rightNode :Node<V>?= last
        val lastRightDataNode  = rightNode

        var  isPail = true
        //从两边开始往中间判断
        while (null != leftNode && null != rightNode){
            println("left.value=${leftNode.value},${rightNode.value}")
            if(leftNode.value != rightNode.value){
                isPail = false
                break
            }
            leftNode = leftNode.next
            rightNode = rightNode.next
          //  println("循环2=")
        }

        //判断完成后再交换回去
        slow?.next = tempData
        cur = lastRightDataNode
        last = null

        println("tempData=${tempData?.value}")
        //把之前倒序的还原
        while (null != cur){
            temp  = cur
            cur = cur.next
            temp.next = last
            last = temp
        }
        println("isPail=${isPail}")
        return  isPail
    }

    /**
     * TODO
     * 判断链表是否有环，通过快慢指针的方式，当最后快指针为空则表示，当前无环
     * 若快指针最后与慢指针相同，则表示 有环 （因速度是其两倍，所以在环内不超过2圈就会追上慢指针）
     * @param head
     * @return
     */
    fun  isLinkedRing(head: Node<V>):Boolean{
        var  slow:Node<V>?= head
        var  fast:Node<V>?= head
        while (null != slow && null != fast){
            slow = slow.next
            fast = fast.next?.next
            if(null == fast || fast == slow){
                return true
            }
        }
        return false
    }

    /**
     * TODO
     * 找到有环链表的起始节点为(环的开始点)，
     * 使用快慢指针，当两个指针相遇时，将快指针移到表头，两指针每次都只执行一步 相遇后的节点仅开当前环开始节点
     * @param head
     * @return
     */
    fun  findLinkRingStartNode(head: Node<V>):Node<V>?{
        var  slow:Node<V>?= head
        var  fast:Node<V>?= head
        while (null != slow && null != fast){
            slow = slow.next
            fast = fast.next?.next
            if(null == fast){
                return null
            }
            if(slow == fast){
                fast = head
                break
            }
        }
        //将快指针移到head

        while (null != slow && null != fast){
            slow = slow.next
            fast = fast.next
            if(slow == fast){
                return fast
            }
        }
        return null
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
//            for(i in 9 downTo 0 ){
//                list.add(Node<String>().apply {
//                    value = "value${i}"
//                })
//            }
            for (i in list.indices){
                if(i < list.size - 1){
                    list[i].next = list[i+1]
                }else{
                    list[i].next = list[i/2]
                }
            }
            list.forEach {
                println(it.value+":"+it.next?.value)
            }
         //   ListNode<String>().fastAndSlowPoint(list[0])
         //   ListNode<String>().reverseList2(list[0])
          //  ListNode<String>().isPail(list[0])
            println("当前列表是否有环：${ListNode<String>().isLinkedRing(list[0])}")
            ListNode<String>().findLinkRingStartNode(list[0])?.let {
                println("当前链表环的开始节点：${it.value}")
            }

            println("-----------------------------")
            list.forEach {

                println(it.value+":"+it.next?.value)
            }
//            println("-------------double----------------")
//            val listDouble = mutableListOf<NodeDouble<String>>()
//            for(i in 0..10){
//                listDouble.add(NodeDouble<String>().apply {
//                    value = "value${i}"
//                })
//            }
//            for (i in listDouble.indices){
//                if(i < listDouble.size - 1){
//                    listDouble[i].next = listDouble[i+1]
//                }
//                if(i>0){
//                    listDouble[i].last = listDouble[i-1]
//                }
//
//            }
//            listDouble.forEach {
//                println(it.last?.value+":"+it.value+":"+it.next?.value)
//            }
//            ListNode<String>().reverseDoubleList(listDouble[0])
//            println("-----------------------------")
//            listDouble.forEach {
//                println(it.last?.value+":"+it.value+":"+it.next?.value)
//            }
        }
    }
}