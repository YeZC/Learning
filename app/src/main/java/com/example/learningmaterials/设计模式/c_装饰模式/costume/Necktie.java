package com.example.learningmaterials.设计模式.c_装饰模式.costume;

import com.example.learningmaterials.设计模式.c_装饰模式.Costume;

public class Necktie extends Costume {

    String DESCRIBE = "领带 ";

    @Override
    public String getInfo() {
        return super.getInfo() + DESCRIBE;
    }
}
