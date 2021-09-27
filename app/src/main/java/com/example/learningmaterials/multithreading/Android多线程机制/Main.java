package com.example.learningmaterials.multithreading.Android多线程机制;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;

import androidx.annotation.UiThread;
import androidx.annotation.WorkerThread;

import java.util.concurrent.Executor;

public class Main {

    public static void main(String[] args) {
        customThread();
//        threadLocal();
//        handlerThread();
    }

    static void customThread(){
        CustomThread thread = new CustomThread();
        thread.start();
        try {
            Thread.sleep(3_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.setTask(new Runnable() {
            @Override
            public void run() {
                System.out.println("set task");
            }
        });
        thread.quit();
    }

    static void threadLocal(){
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        new Thread(){
            @Override
            public void run() {
                threadLocal.set(1);
                threadLocal.get();
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                threadLocal.set(2);
            }
        }.start();
    }

    static void handlerThread(){
        HandlerThread handlerThread = new HandlerThread("threadname");
        Handler handler = new Handler(handlerThread.getLooper());
    }

    // Executor
    // HandlerThread
    // IntentService
    static void asyncTask(){
//        MyAsyncTask asyncTask = new MyAsyncTask();
//        asyncTask.execute()
    }

    // 没有static会发生内存泄漏 1.线程是GC Root对象 2.当MyAsyncTask生命周期比Activity长
//    static class MyAsyncTask extends AsyncTask {
//
//        @UiThread
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//        }
//
//        @WorkerThread
//        @Override
//        protected Object doInBackground(Object[] objects) {
//            return null;
//        }
//
//        @UiThread
//        @Override
//        protected void onPostExecute(Object o) {
//            super.onPostExecute(o);
//        }
//    }
}
