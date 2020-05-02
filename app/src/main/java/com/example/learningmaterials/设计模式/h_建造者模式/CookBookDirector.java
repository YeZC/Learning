package com.example.learningmaterials.设计模式.h_建造者模式;

/**
 * Created by yzc on 2020-03-21.
 * 炒粉的顺序控制类
 */
public class CookBookDirector {


    public static void make(CookBuilder builder){
        builder.pushStapleFood();
        builder.pushEgg();
        builder.pushSoySauce();
    }
}
