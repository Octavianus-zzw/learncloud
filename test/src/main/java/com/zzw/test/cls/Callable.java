package com.zzw.test.cls;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class NumThread implements Callable {
    private int sum = 0;

    @Override
    public Object call() throws Exception {
        for (int i = 0; i <= 10000; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
                sum += i;
            }
        }
        return sum;
    }
}

class ThreadNew {
    public static void main(String[] args) {
        NumThread numThread1 = new NumThread();
        NumThread numThread2 = new NumThread();
        FutureTask futureTask1 = new FutureTask(numThread1);
        FutureTask futureTask2 = new FutureTask(numThread2);
        Thread t1 = new Thread(futureTask1);
        Thread t2 = new Thread(futureTask2);
        t1.setName("线程1");
        t2.setName("线程2");
        t1.start();
        t2.start();

        try {
            Object sum1 = futureTask1.get();
            Object sum2 = futureTask2.get();
            System.out.println(Thread.currentThread().getName() + ":" + sum1);
            System.out.println(Thread.currentThread().getName() + ":" + sum2);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
