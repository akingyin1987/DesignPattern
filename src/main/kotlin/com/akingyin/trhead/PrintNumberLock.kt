package com.akingyin.trhead

import java.util.concurrent.locks.ReentrantLock


class PrintNumberLock {

    private val lock = ReentrantLock()
    private val even = lock.newCondition()
    private val odd = lock.newCondition()
    private var runOdd = true

    private fun printOdd(){
        while (true){
            lock.lock()
            try {
                while (!runOdd){
                    odd.await()
                }
                println(1)
                Thread.sleep(1000);
                runOdd = false;
                even.signalAll();
            }catch (e:Exception){
                e.printStackTrace()
            }finally {
                lock.unlock()
            }
        }
    }

    private fun printEven() {
        while (true) {
            lock.lock()
            try {
                while (runOdd) {
                    even.await()
                }
                println(2)
                Thread.sleep(1000)
                runOdd = true
                odd.signalAll()
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                lock.unlock()
            }
        }
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            val lock  = PrintNumberLock()
            Thread{
                lock.printEven()
            }.start()

            Thread{
                lock.printOdd()
            }.start()
        }
    }
}