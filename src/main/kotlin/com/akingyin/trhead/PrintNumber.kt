package com.akingyin.trhead

/**
 * TODO 线程 交替打印 如：1 2 1 2 1 2
 * 必须要在同步代码块中执行
 *void notify() ：唤醒在此对象监视器上等待的单个线程
 void notifyAll() ：唤醒在此对象监视器上等待的所有线程
 void wait( ) ：使当前的线程等待，直到其他线程调用此对象的notify( ) 方法或 notifyAll( ) 方法
void wait(long timeout) ：使当前的线程等待，直到其他线程调用此对象的notify() 方法或 notifyAll() 方法，或者超过指定的时间。
void wait(long timeout, int nanos) ：使当前的线程等待，直到其他线程调用此对象的notify( ) 方法或 notifyAll( ) 方法，或者其他线程打断了当前线程，或者超过指定的时间。
 */
class PrintNumber {





    inner class PrintThread(var  threadNo:Int) : Thread(){

        override fun run() {
            super.run()
            while (true){
                synchronized(LOCK){
                    while (value % THREAD_COUNT != threadNo){
                        //如果不是当前线程
                        LOCK.wait()
                    }
                    sleep(1000); // 为了更好的看到打印效果，可有可无
                    println(currentThread().name + " : " + (value % THREAD_COUNT + 1));
                    value++

                    // 因为最外层是 while(true) , 为了防止无限制变大
                    if (value == 10) {
                        value = 0;
                    }
                    LOCK.notifyAll(); // 唤醒线程
                }
            }
        }
    }

    companion object{
        private val LOCK = Object()
        private var value = 0
        private val THREAD_COUNT = 2 // 线程的数量
        @JvmStatic
        fun main(args: Array<String>) {
            PrintNumber().PrintThread(0).start()
            PrintNumber().PrintThread(1).start()
        }
    }
}