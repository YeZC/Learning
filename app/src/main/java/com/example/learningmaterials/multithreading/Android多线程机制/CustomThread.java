package com.example.learningmaterials.multithreading.Android多线程机制;

import java.util.concurrent.atomic.AtomicBoolean;

public class CustomThread extends Thread {

    Looper looper = new Looper();
    private Runnable runnable;
    private AtomicBoolean quit = new AtomicBoolean();

    synchronized void setTask(Runnable task){
        this.runnable = task;
    }

    void quit(){
        quit.set(true);
    }

    @Override
    public void run() {
        looper.loop();
    }

    class Looper {
        void loop(){
            while(!quit.get()){
                synchronized (this){
                    if(runnable != null){
                        runnable.run();
                        runnable = null;
                    }
                }
            }
        }
    }
}
