package com.akingyin.tree

import java.util.LinkedList

/**
 * TODO
 * 完全叉树
 *一棵深度为k且有 个结点的二叉树称为满二叉树。 [2]
根据二叉树的性质2, 满二叉树每一层的结点个数都达到了最大值, 即满二叉树的第i层上有 个结点 (i≥1) 。 [2]
如果对满二叉树的结点进行编号, 约定编号从根结点起, 自上而下, 自左而右。则深度为k的, 有n个结点的二叉树,
当且仅当其每一个结点都与深度为k的满二叉树中编号从1至n的结点一一对应时, 称之为完全二叉树
从满二叉树和完全二叉树的定义可以看出, 满二叉树是完全二叉树的特殊形态, 即如果一棵二叉树是满二叉树, 则它必定是完全二叉树
 */
class Cbt {

    /**
     * TODO
     * 判断是否为完全二叉树 通过宽度遍历实现
     * @param head
     * @return
     */
    fun  isCbt(head: Node<String>):Boolean{
        val queue = LinkedList<Node<String>>()
        var  temp = head
        //是否遇到过左右两个孩子不双全的节点
        var leaf = false
        var left:Node<String>?=null
        var right:Node<String>?= null
        queue.add(temp)
        while (!queue.isEmpty()){
            temp = queue.poll()
            left = temp.left
            right = temp.right

            if(leaf && (null != left || null != right)){
                //当前遇到节点不双全，则所有后节点都应该为叶子节点才是完全二叉树
                return false
            }
            if( null != right && null == left){
                //当前有左没有右节点
                return false
            }
            if(null != left){
                queue.add(left)
            }
            if(null != right){
                queue.add(right)
            }
            if(null == right || null == left){
                //当前至少有一个为空则表示当前遇到节点不双全
                leaf = true
            }
        }
        return true
    }




    private fun createTree(): Node<String> {
        val temp:Node<String> = Node()
        temp.value="12"
        temp.left = Node<String>().apply {
            value = "5"
        }
        temp.right = Node<String>().apply {
            value = "18"
        }
        temp.left?.left = Node<String>().apply {
            value = "2"
        }
        temp.left?.right = Node<String>().apply {
            value = "9"
        }
        temp.right?.left = Node<String>().apply {
            value = "15"
        }
//        temp.right?.right = Node<String>().apply {
//            value = "19"
//        }
        return temp
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            Cbt().apply {
                println("是否是完全二叉树：${isCbt(createTree())}")
            }
        }
    }
}