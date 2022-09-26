package com.akingyin.tree

import java.util.*
import kotlin.math.max
import kotlin.math.min

/**
 * TODO
 *二叉查找树（Binary Search Tree），（又：二叉搜索树，二叉排序树）
 * 它或者是一棵空树，或者是具有下列性质的二叉树：
 * 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
 * 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
 * 它的左、右子树也分别为二叉排序树
 * 。二叉搜索树作为一种经典的数据结构，它既有链表的快速插入与删除操作的特点，又有数组快速查找的优势；
 * 所以应用十分广泛，例如在文件系统和数据库系统一般会采用这种数据结构进行高效率的排序与检索操作
 */
class Bst {

    /**
     * TODO通过中序遍历判断当前二叉树 是否 二叉搜索树
     *
     * @param head
     * @return
     *
     */
  //  private var  preValue  = Int.MAX_VALUE
    fun isBstByInOrder(head: Node<Int>, preValue:Int=Int.MAX_VALUE):Boolean{
        val isLeftBst = head.left?.let {
            isBstByInOrder(it)
        }?:true
        if(!isLeftBst){
            //左边不是则直接返回
            return  false
        }
        //获取的是中数节点字
        val value = head.value?:return false
        if(value <= preValue && preValue != Int.MAX_VALUE){
            //判断左数是否比右数小
            return false
        }
//        else{
//            preValue = value
//        }
        return head.right?.let { isBstByInOrder(it,value) }?:true
    }

    /**
     * TODO非递归
     *
     * @param head
     * @return
     */
    fun isBstByInOrder2(head: Node<Int>):Boolean{
        val stack: Stack<Node<Int>> = Stack()
        var preValue  = Int.MAX_VALUE
        var  temp  :Node<Int> ?= head
        while (stack.isNotEmpty() || null != temp){
            if(null != temp){
                //当前节点（左边界）放栈中 （找每个节点的左边界直至没有）
                stack.push(temp)
                temp = temp.left
            }else{
                //依次取出，并判是否有右节点，有则将其左边界存入栈中
                temp = stack.pop()

                if(temp.value!! <= preValue && preValue != Int.MAX_VALUE){
                    return false
                }else{
                    preValue = temp.value?:return false
                }

                temp = temp.right
            }
        }
        return true
    }

    data class ReturnData(
        var isBst: Boolean = false,
        var min:Int = 0,
        var max:Int = 0
    )

    fun  process(node: Node<Int>?):ReturnData?{
        if(null == node){
            return null
        }
        val  leftData  = process(node.left)
        val  rightData  = process(node.right)
        var min  = node.value?:0
        var max  = node.value?:0
        if(null != leftData){
            min = min(min,leftData.min)
            max = max(max,leftData.max)
        }
        if(null != rightData){
            min = min(min,rightData.min)
            max = max(max,rightData.max)
        }
        var  isBst  = true
        if (leftData != null) {
            if( !leftData.isBst || leftData.max>= (node.value?:0)){
                //左树不为搜索二叉树
                isBst = false
            }
        }
        if(null != rightData ){
            //右树不为搜索二叉树
            if( !rightData.isBst || node.value!! >= rightData.min){
                isBst = false
            }

        }

        return ReturnData(max = max, min = min, isBst = isBst)

    }

    private fun createTree(): Node<Int> {
        val temp:Node<Int> = Node()
        temp.value=12
        temp.left = Node<Int>().apply {
            value = 5
        }
        temp.right = Node<Int>().apply {
            value = 18
        }
        temp.left?.left = Node<Int>().apply {
            value = 2
        }
        temp.left?.right = Node<Int>().apply {
            value = 9
        }
        temp.right?.left = Node<Int>().apply {
            value = 15
        }
        temp.right?.right = Node<Int>().apply {
            value = 19
        }
        return temp
    }
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            val isBst = Bst().isBstByInOrder(Bst().createTree())
            println("是否是搜索二叉树=${isBst}")
        }
    }

}