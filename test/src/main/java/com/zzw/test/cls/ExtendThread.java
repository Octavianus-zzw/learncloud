package com.zzw.test.cls;

class MyThreadExtend extends Thread {
    private String name;

    public MyThreadExtend(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(name + "运行：i = " + i);
        }
    }
}

class ThreadDemo02 {
    public static void main(String[] args) {
        MyThreadExtend mte1 = new MyThreadExtend("线程A");
        MyThreadExtend mte2 = new MyThreadExtend("线程B");
        mte1.start();
        mte2.start();
    }
}
