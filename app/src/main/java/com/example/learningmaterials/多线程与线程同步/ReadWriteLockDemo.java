package com.example.learningmaterials.多线程与线程同步;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo implements TestDemo{

    private int x = 0;
    // 可重入锁
//    ReentrantLock lock = new ReentrantLock();
    //
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    Lock readLock = lock.readLock();
    Lock writeLock = lock.writeLock();

//    private void count(){
//        lock.lock();
//        try{
//            x++;
//        }finally {
//            lock.unlock();
//        }
//    }

    private void count(){
        writeLock.lock();
        try{
            x++;
        }finally {
            writeLock.unlock();
        }
    }

    private void print(int time){
        readLock.lock();
        try{
            System.out.println(x + " ");
        }finally {
            readLock.unlock();
        }
    }

    @Override
    public void runTest() {

    }
}
