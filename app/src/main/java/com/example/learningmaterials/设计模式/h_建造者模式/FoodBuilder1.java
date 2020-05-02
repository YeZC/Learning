package com.example.learningmaterials.设计模式.h_建造者模式;

/**
 * Created by yzc on 2020-03-21.
 *
 * 蛋炒饭的原料
 */
public class FoodBuilder1 implements CookBuilder{

    private Food food = new Food();

    @Override
    public void pushStapleFood() {
        food.raw.append(" 饭 ");
    }

    @Override
    public void pushEgg() {
        food.raw.append(" 鸡蛋 ");
    }

    @Override
    public void pushSoySauce() {
        food.raw.append(" 酱油 ");
    }

    @Override
    public Food getFood() {
        return food;
    }
}
