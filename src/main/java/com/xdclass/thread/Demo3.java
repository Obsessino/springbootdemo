package com.xdclass.thread;

/**
 * @author Obsession.yin
 * @date 2020/3/8
 */
public class Demo3 {

    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            System.out.println("Lombad 表达式实现thread 创建"+Thread.currentThread().getName());
        });
        thread.setName("demo3");
        thread.start();
    }
}
