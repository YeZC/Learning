package com.example.learningmaterials.多线程与线程同步;

import java.util.concurrent.atomic.AtomicBoolean;

public class Synchronized1Demo implements TestDemo {

//    private boolean running = true;
    /**
     * 1.volatile 有了可见性
     * 2.使用 AtomicBoolean 保证可见性和原子性
     */
    private volatile boolean running = true;

    private void stop(){
        running = false;
    }

    @Override
    public void runTest() {
        new Thread(){
            @Override
            public void run() {
                while(running){
                }
            }
        }.start();

        try{
            Thread.sleep(1_000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        stop();
    }
}
