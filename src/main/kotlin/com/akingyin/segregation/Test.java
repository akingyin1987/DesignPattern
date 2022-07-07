package com.akingyin.segregation;

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

}
