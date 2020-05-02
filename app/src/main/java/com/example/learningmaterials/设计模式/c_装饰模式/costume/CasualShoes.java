package com.example.learningmaterials.设计模式.c_装饰模式.costume;

import androidx.annotation.NonNull;

import com.example.learningmaterials.设计模式.c_装饰模式.Costume;

public class CasualShoes extends Costume {

    String DESCRIBE = "休闲鞋 ";

    @Override
    public String getInfo() {
        return super.getInfo() + DESCRIBE;
    }

    @NonNull
    @Override
    protected CasualShoes clone() throws CloneNotSupportedException {
        return new CasualShoes();
    }
}
