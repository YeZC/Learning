package com.example.learningmaterials.设计模式.h_建造者模式;

/**
 * Created by yzc on 2020-03-21.
 *
 * 蛋炒饭的核心步骤
 */
public interface CookBuilder {

    void pushStapleFood();

    void pushEgg();

    void pushSoySauce();

    Food getFood();
}
