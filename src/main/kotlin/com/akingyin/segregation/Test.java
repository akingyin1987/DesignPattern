package com.akingyin.segregation;

import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {

    public void  test(){
        AtomicInteger  atomicInteger = new AtomicInteger(1);
        atomicInteger.getAndDecrement();
        int eor =0;
        int rightOne  = eor & (~eor +1);
        int a = 10;
        int b = 2;
        a = a >> 1;

    }

    void testSort(){
        int[] arr = new int[6];
        int k = 8;
        PriorityQueue<Integer>  heap = new PriorityQueue<>();
        int index  = 0;
        for (; index< Math.min(arr.length,k);index++){
            heap.add(arr[index]);
        }
        int i  = 0;
        for (; index< arr.length;i++,index++){
            heap.add(arr[index]);
            arr[i] = heap.poll();
        }
        while (!heap.isEmpty()){
            arr[i++] = heap.poll();
        }

    }

}
