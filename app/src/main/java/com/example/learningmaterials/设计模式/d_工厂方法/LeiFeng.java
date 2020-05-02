package com.example.learningmaterials.设计模式.d_工厂方法;


/**
 * 雷锋抽象类
 */
public class LeiFeng {

    public String name = "雷锋";

    public void sweep(){
        System.out.println(name + "扫地");
    }

    public void wash(){
        System.out.println(name + "洗衣服");
    }

    public void buyRice(){
        System.out.println(name + "买米");
    }

}
