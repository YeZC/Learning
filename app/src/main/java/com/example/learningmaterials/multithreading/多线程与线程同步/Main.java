package com.example.learningmaterials.多线程与线程同步;

import com.example.learningmaterials.multithreading.多线程与线程同步.Synchronized1Demo;
import com.example.learningmaterials.multithreading.多线程与线程同步.Synchronized2Demo;
import com.example.learningmaterials.multithreading.多线程与线程同步.Synchronized3Demo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {
//        thread();
//        runnable();
//        threadFactory();
//        executor();
//        callable();
//        runSynchronized1Demo();
//        runSynchronized2Demo();
        runSynchronized3Demo();
    }

    /**
     * 使用 Thread 类来定义工作
     */
    static void thread(){
        Thread thread = new Thread(){
            @Override
            public void run() {
                System.out.println("Thread started!");
            }
        };
        thread.start();
    }

    /**
     * 使用 Runnable 定义工作
     */
    static void runnable(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread with Runnable started!");
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    static void threadFactory(){
        ThreadFactory factory = new ThreadFactory() {
            AtomicInteger count = new AtomicInteger(0);
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "Thread-" + count.incrementAndGet());
            }
        };

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " started!");
            }
        };

        Thread thread1 = factory.newThread(runnable);
        thread1.start();
        Thread thread2 = factory.newThread(runnable);
        thread2.start();
    }

    static void executor(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread with Runnable started!");
            }
        };

        Executor executor = Executors.newCachedThreadPool();
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
    }

    static void callable(){
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                try{
                    Thread.sleep(1_000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                return "Done!";
            }
        };

        ExecutorService service = Executors.newCachedThreadPool();
        Future<String> future = service.submit(callable);
        try{
            String result = future.get();
            System.out.println("result: " + result);
        }catch (InterruptedException | ExecutionException e){
            e.printStackTrace();
        }
    }

    static void runSynchronized1Demo(){
        new Synchronized1Demo().runTest();
    }

    static void runSynchronized2Demo(){
        new Synchronized2Demo().runTest();
    }

    static void runSynchronized3Demo(){
        new Synchronized3Demo().runTest();
    }
}
