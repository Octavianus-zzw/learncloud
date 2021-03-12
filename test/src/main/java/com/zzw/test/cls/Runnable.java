package com.zzw.test.cls;

class MyThread implements Runnable {
    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i=0; i<100; i++) {
            System.out.println(name + "运行: i=" + i);
        }
    }
}

class RunnableDemo01 {
    public static void main(String args[]) {
        MyThread mt1 = new MyThread("线程A");
        MyThread mt2 = new MyThread("线程B");
        MyThread mt3 = new MyThread("线程C");
        Thread t1 = new Thread(mt1);
        Thread t2 = new Thread(mt2);
        Thread t3 = new Thread(mt3);
        t1.start();
        t2.start();
        t3.start();
    }
}
