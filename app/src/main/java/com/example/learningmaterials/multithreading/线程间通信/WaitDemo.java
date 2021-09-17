package com.example.learningmaterials.multithreading.线程间通信;

import com.example.learningmaterials.multithreading.TestDemo;

public class WaitDemo implements TestDemo {

    private String sharedString;

    private synchronized void intString(){
        sharedString = "yezhaochu";
        notifyAll();
        // 唤醒所有等待锁
    }

    private synchronized void printString(){
        while(sharedString == null){
            try {
                wait();
                // 释放锁，等待下一次
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("String: " + sharedString);
    }

    @Override
    public void runTest() {
        final Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                printString();
            }
        };
        thread.start();

        Thread thread2 = new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(2_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                intString();
            }
        };
        thread2.start();

        try {
            // 执行完thread后回来，这个阻塞
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("thread finish");
    }
}
