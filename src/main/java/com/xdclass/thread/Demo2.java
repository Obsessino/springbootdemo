package com.xdclass.thread;

/**
 * @author Obsession.yin
 * @date 2020/3/8
 */
public class Demo2 implements Runnable {
    @Override
    public void run() {
        System.out.println("implements Runnable " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new Demo2());
        thread.setName("Demo2 thread");
        thread.start();
    }
}
