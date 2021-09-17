package com.example.learningmaterials.多线程与线程同步;

/**
 * double check 单例
 */
public class SingleMan {

    private static volatile SingleMan sInstance;

    private SingleMan(){

    }

    static SingleMan newInstance(){
        if(sInstance == null){
            synchronized (SingleMan.class){
                if(sInstance == null){
                    sInstance = new SingleMan();
                }
            }
        }
        return sInstance;
    }
}
