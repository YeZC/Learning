package com.example.learningmaterials.设计模式.c_装饰模式.costume;

import com.example.learningmaterials.设计模式.c_装饰模式.Costume;

public class CasualPants extends Costume {

    String DESCRIBE = "休闲裤 ";

    @Override
    public String getInfo() {
        return super.getInfo() + DESCRIBE;
    }
}
