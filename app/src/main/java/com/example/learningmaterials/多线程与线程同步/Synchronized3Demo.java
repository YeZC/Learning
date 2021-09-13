package com.example.learningmaterials.多线程与线程同步;

public class Synchronized3Demo implements TestDemo {

    private int x = 0;
    private int y = 0;
    private String name;
    private final Object monitor1 = new Object();

    /**
     * 锁的对象一样，都是当前类
     */
//    private synchronized void count(int newValue){
//        x = newValue;
//        y = newValue;
//    }
//    private void count(int newValue){
//        synchronized (this){
//            x = newValue;
//            y = newValue;
//        }
//    }

    private void count(int newValue){
        x = newValue;
        y = newValue;
    }

    private void setName(String newName){
        // 独立的锁这个对象
        synchronized (monitor1){
            name = newName;
        }
    }

    @Override
    public void runTest() {

    }
}
