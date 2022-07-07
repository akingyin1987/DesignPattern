package com.akingyin.trhead

import java.util.concurrent.Semaphore

/**
 * TODO 使用 信号量
 *每个线程调用acquire方法尝试获取许可，如果成功就会继续执行，否则就会被阻塞，
 * 当获取许可成功后，调用release方法释放许可供其他线程使用，之前被阻塞的线程会被唤醒继续执行
 */
class PrintNumberSemaphore {
    private val semaphoreOdd = Semaphore(1)
    private val semaphoreEven = Semaphore(0)

     fun printOdd() {
        while (true) {
            try {
                semaphoreOdd.acquire()
                println("${semaphoreOdd.availablePermits()}:"+semaphoreOdd.drainPermits())
                println(1)
                Thread.sleep(1000)
                semaphoreEven.release()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

     fun printEven() {
        while (true) {
            try {
                println("even = ${semaphoreEven.availablePermits()}:"+semaphoreEven.drainPermits())

                semaphoreEven.acquire()
                println("even2 = ${semaphoreEven.availablePermits()}:"+semaphoreEven.drainPermits())

                println(2)
                Thread.sleep(1000)
                semaphoreOdd.release()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            val lock  = PrintNumberSemaphore()
            Thread{
                lock.printOdd()
            }.start()

            Thread{
                lock.printEven()
            }.start()
        }
    }
}