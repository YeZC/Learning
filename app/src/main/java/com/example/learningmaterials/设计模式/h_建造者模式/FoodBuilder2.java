package com.example.learningmaterials.设计模式.h_建造者模式;

/**
 * Created by yzc on 2020-03-21.
 *
 * 炒粉的原料
 */
public class FoodBuilder2 implements CookBuilder{

    private Food food = new Food();

    @Override
    public void pushStapleFood() {
        food.raw.append(" 粉 ");
    }

    @Override
    public void pushEgg() {
        food.raw.append(" 两个鸡蛋 ");
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
