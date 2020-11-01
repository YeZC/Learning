package com.example.learningmaterials.多线程;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Demo {

    public static void main(String[] args) {
        final DelegatingVehicleTracker monitor = new DelegatingVehicleTracker(initData());

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while(true){
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("read Thread id: " + Thread.currentThread().getId() + " " + monitor.getLocations().get("0").toString());
                    }
                }
            }).start();
        }


        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while(true){
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        int x = new Random().nextInt(100);
                        int y = new Random().nextInt(100);
                        monitor.setLocation("0", x, y);
                        System.out.println("modify value x=" + x + " y=" + y);
                    }
                }
            }).start();
        }
    }

    public static Map<String, Point> initData(){
        HashMap map = new HashMap();
        for (int i = 0; i < 100; i++) {
            int x = new Random().nextInt(100);
            int y = new Random().nextInt(100);
            map.put(String.valueOf(i), new Point(x, y));
        }
        return map;
    }
}
