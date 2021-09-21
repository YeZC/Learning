package com.example.learningmaterials.multithreading.线程间通信;

import com.example.learningmaterials.multithreading.TestDemo;

public class ThreadInterractionDemo implements TestDemo {

    @Override
    public void runTest() {
        Thread thread = new Thread(){
            @Override
            public void run() {
//                for (int i = 0; i < 1_000_000; i++) {
//                    // 设置中断
//                    if(isInterrupted()){
//                        return;
//                    }
//                    System.out.println("number: " + i);
//                }

                try{
                    Thread.sleep(10_000);
                }catch (InterruptedException e){
                    // 回收资源，结束线程
                }
            }
        };
        thread.start();

        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
