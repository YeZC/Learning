package com.example.learningmaterials.设计模式.h_建造者模式;

/**
 * Created by yzc on 2020-03-21.
 */
public class TestDemo {

    public static void main(String[] args) {

        // 蛋炒饭原料
        FoodBuilder1 foodBuilder1 = new FoodBuilder1();
        // 蛋炒粉原料
        FoodBuilder2 foodBuilder2 = new FoodBuilder2();

        // 根据菜谱做菜
        CookBookDirector.make(foodBuilder1);
        // 通过原料得到food1 蛋炒粉
        Food food1 = foodBuilder1.getFood();
        System.out.println("蛋炒饭：" + food1.raw.toString());

        //
        CookBookDirector.make(foodBuilder2);
        Food food2 = foodBuilder2.getFood();
        System.out.println("炒粉：" + food2.raw.toString());

    }
}
