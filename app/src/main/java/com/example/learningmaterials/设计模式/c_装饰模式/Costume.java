package com.example.learningmaterials.设计模式.c_装饰模式;

public class Costume extends Person {

    private Person person;

    public void wear(Person person){
        this.person = person;
    }

    @Override
    public String getInfo() {
        return person.getInfo();
    }

}
