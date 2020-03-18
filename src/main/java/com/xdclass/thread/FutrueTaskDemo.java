package com.xdclass.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Obsession.yin
 * @date 2020/3/8
 */
public class FutrueTaskDemo implements Callable<Object> {

    @Override
    public Object call() throws Exception {
        System.out.println("callable thread.."+ Thread.currentThread().getName());
        return "abc";
    }

    public static void main(String[] args) {
        FutureTask<Object> task = new FutureTask(new FutrueTaskDemo());
        Thread thread = new Thread(task);
        thread.setName("futrueTask ...");
        thread.start();

        try {
            System.out.println(task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
