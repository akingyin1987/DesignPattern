package com.akingyin.tree

class Node<V> {
    var  value:V?=null
    var  left:Node<V>?= null
    var  right:Node<V>?=null
    override fun toString(): String {
        return "Node(value=$value, left=${left?.value}, right=${right?.value})"
    }


}