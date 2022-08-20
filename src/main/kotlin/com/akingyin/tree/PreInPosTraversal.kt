package com.akingyin.tree

import java.util.Stack


/**
 * 遍历二叉树
 * 先序遍历：根->左->右
 * 中序遍历：左->根->右
 * 后序遍历：左->右->根
 */
class PreInPosTraversal {

    /**
     * TODO
     *递归先序
     * @param head
     */
   fun preOrder(head: Node<String>){
       println("value=${head.value}")
       head.left?.let {
           preOrder(it)
       }
       head.right?.let {
           preOrder(it)
       }
   }

    fun laterOrder(head: Node<String>){

        head.left?.let {
            laterOrder(it)
        }
        head.right?.let {
            laterOrder(it)
        }
        println("value=${head.value}")
    }

    /**
     * TODO
     * 递归中序
     * @param head
     */
    fun inOrder(head: Node<String>){
        head.left?.let {
            inOrder(it)
        }
        println("value=${head.value}")
        head.right?.let {
            inOrder(it)
        }
    }

    /**
     * TODO
     * 先序遍历 非新递归
     * @param head
     */
    fun preOrderUnRecur(head: Node<String>){
        val stack:Stack<Node<String>> = Stack()
        stack.add(head)
        var  temp:Node<String>
        while (stack.isNotEmpty()){
            temp = stack.pop()
            println("value=${temp.value}")

            //先压右，再压左，取出时会从左往右
            if(null != temp.right){
                stack.push(temp.right)
            }
            if(null != temp.left){
                stack.push(temp.left)
            }
        }
    }

    /**
     * TODO
     *非递归中序
     * @param head
     */
    fun inOrderUnRecur(head: Node<String>){
        val stack:Stack<Node<String>> = Stack()
        var  temp  :Node<String> ?= head
        while (stack.isNotEmpty() || null != temp){
            if(null != temp){
                //当前节点（左边界）放栈中
                stack.push(temp)
                temp = temp.left
            }else{
                //依次取出则为左，并判是否有右节点，有则将其左边界存入栈中
                temp = stack.pop()
                println("value=${temp?.value}")

                temp = temp.right
            }
        }
    }

    /**
     * TODO
     * 非递归后序遍历
     * @param head
     */
    fun posOrderUnRecur(head:  Node<String>){

        val stack:Stack<Node<String>> = Stack()

        //栈内存的顺序为 头 右 左
        val tempStack : Stack<Node<String>> = Stack()
        //压头部
        stack.push(head)
        var temp:Node<String>
         while (stack.isNotEmpty()){
             temp  = stack.pop()
             //每次弹出时装入临时的栈
             tempStack.push(temp)
             temp.left?.let {
                 //先压左
                 stack.push(it)
             }
             temp.right?.let {
                 //再压右
                 stack.push(it)
             }
         }
         while (tempStack.isNotEmpty()){
             //取出时则顺序为 左 右 头 仅为后序
             println("value=${tempStack.pop().value}")
         }
    }


    companion object{
        private var treeValues = listOf("a", "b", "#", "d", "#", "#", "c","E","#", "#","F","#")
        /**
         * 创建二叉树
         *
         * @param node
         */
        var  index = 0
        private fun createTree(node: Node<String>?): Node<String>? {
            var  temp:Node<String>? = node
            if( index>= treeValues.size || treeValues[index] == "#" ){
                index++
                temp = null
            }else{

                if(index != 0){
                   temp = Node()
                }
                temp?.value = treeValues[index]
                index++
                temp?.left = createTree(node?.left)
                temp?.right = createTree(node?.right)
            }

            return temp
        }

        private fun createTree2(): Node<String> {
            val temp:Node<String> = Node()
            temp.value="1"
            temp.left = Node<String>().apply {
                value = "2"
            }
            temp.right = Node<String>().apply {
                value = "3"
            }
            temp.left?.left = Node<String>().apply {
                value = "4"
            }
            temp.left?.right = Node<String>().apply {
                value = "5"
            }
            temp.right?.left = Node<String>().apply {
                value = "6"
            }
            temp.right?.right = Node<String>().apply {
                value = "7"
            }
            return temp
        }

        @JvmStatic
        fun main(args: Array<String>) {

            val  head:Node<String> =  createTree2()
            head.let {
               PreInPosTraversal().preOrderUnRecur(it)
                println("------递归先序---")
                PreInPosTraversal().preOrder(it)
                println("------递归后序---")
                PreInPosTraversal().laterOrder(it)
                println("------非递归后序---")
                PreInPosTraversal().posOrderUnRecur(it)

                println("------递归中序---")
                PreInPosTraversal().inOrder(it)
                println("------非递归中序---")
                PreInPosTraversal().inOrderUnRecur(it)
            }

        }
    }
}