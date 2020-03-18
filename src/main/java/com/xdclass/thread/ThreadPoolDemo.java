package com.xdclass.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Obsession.yin
 * @date 2020/3/8
 */
public class ThreadPoolDemo implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+".....");
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i ++){
            executorService.execute(new ThreadPoolDemo());
        }
        System.out.println(Thread.currentThread().getName());
        executorService.shutdown();

    }
}
