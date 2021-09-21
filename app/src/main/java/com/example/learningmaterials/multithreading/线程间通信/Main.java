package com.example.learningmaterials.multithreading.线程间通信;

public class Main {

    public static void main(String[] args) {
//        runThreadInteractionDemo();
        runWaitDemo();
//        runCustomizableThreadDemo();
    }

    static void runThreadInteractionDemo(){
        new ThreadInterractionDemo().runTest();
    }

    static void runWaitDemo(){
        new WaitDemo().runTest();
    }

    static void runCustomizableThreadDemo(){

    }
}
