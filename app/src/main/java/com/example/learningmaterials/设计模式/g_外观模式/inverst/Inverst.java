package com.example.learningmaterials.设计模式.g_外观模式.inverst;

public abstract class Inverst {

    private String name;

    public Inverst(String name) {
        this.name = name;
    }

    public void buy(){
        System.out.println("买入 " + name);
    }

    public void sell(){
        System.out.println("卖出 " + name);
    }
}
