package com.example.learningmaterials.多线程与线程同步;

public class Synchronized2Demo implements TestDemo {

    private int x = 0;
//    private volatile int x = 0; 加上 volatile 也会出现问题

    /**
     * 1.加上 synchronized 赋予count 原子性
     * 2.使用 AtomicInteger
     */
    private synchronized void count(){
        x++;
        // 非原子操作
        // 1. temp = x + 1
        // 2. x = temp
    }

    @Override
    public void runTest() {
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 1_000_000; i++) {
                    count();
                }
                System.out.println("final x from 1: " + x);
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 1_000_000; i++) {
                    count();
                }
                System.out.println("final x from 2: " + x);
            }
        }.start();
    }
}
