package com.akingyin.segregation;

import java.util.concurrent.atomic.AtomicInteger;

public class Test {

    public void  test(){
        AtomicInteger  atomicInteger = new AtomicInteger(1);
        atomicInteger.getAndDecrement();
    }

}
