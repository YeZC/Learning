package com.example.learningmaterials.设计模式.c_装饰模式;

public class Person {

    private String name;


    public Person(String name) {
        this.name = name;
    }

    public Person() {
    }

    public String getInfo(){
        return name + " 的衣着 : ";
    }
}
