package com.xdclass.thread;

/**
 * @author Obsession.yin
 * @date 2020/3/8
 */
public class Demo1 extends Thread {
    public static void main(String[] args) {
       // Thread thread = new Thread(new Demo1());
        Demo1 thread = new Demo1();
        thread.setName("thread 1");
        thread.start();
    }

    @Override
    public void run() {
        System.out.println("extends thread ...." + Thread.currentThread().getName());
    }


}
