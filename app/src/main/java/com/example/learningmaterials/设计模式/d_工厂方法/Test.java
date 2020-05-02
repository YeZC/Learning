package com.example.learningmaterials.设计模式.d_工厂方法;

import com.example.learningmaterials.设计模式.d_工厂方法.具体工厂.UndergraduateFactory;
import com.example.learningmaterials.设计模式.d_工厂方法.具体工厂.VolunteerFactory;

public class Test {

    public static void main(String[] args) {

        ILeiFengFactory iLeiFengFactory = new UndergraduateFactory();
        LeiFeng leiFeng = iLeiFengFactory.createLeiFeng();

        leiFeng.sweep();

        iLeiFengFactory = new VolunteerFactory();
        leiFeng = iLeiFengFactory.createLeiFeng();

        leiFeng.sweep();
    }

}
