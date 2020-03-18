package com.xdclass.thread;


import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Obsession.yin
 * @date 2020/3/8
 */
public class ThreadPrint {

    public static void main(String[] args) {
        //用于线程的锁
        Object obj = new Object();
        //t1线程是否已经启动，用于t2线程判断是否可以开始打印
        AtomicBoolean isT1Started = new AtomicBoolean(false);
        //打印数字的线程
        Thread t1 = new Thread(() -> {
            synchronized (obj) {
                for (int i = 1; i < 53; i++) {
                    System.out.print(i);
                    //i打印完‘2’告诉t2可以开始打印了
                    if (i == 2) {
                        isT1Started.set(true);
                    }
                    //打印到偶数即唤醒t2，同时进入wait状态
                    if (i % 2 == 0) {
                        obj.notify();
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (obj) {
                for (int i = 0; i <= 26; i++) {
                    //如果是第一次循环，而且t1还未开始，进入wait状态，等待t1唤醒
                    if (!isT1Started.get() && i == 0) {
                        try {
                            obj.wait();
                            continue;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print((char) (i + 'A'));
                    obj.notify();
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t1.start();
        t2.start();
//        try {
//            //休眠5秒，让两个打印线程执行完成,不然会有诡异的问题出现
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("hello world");
//    }
    }
}
