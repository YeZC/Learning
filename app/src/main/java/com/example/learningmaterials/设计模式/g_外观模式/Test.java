package com.example.learningmaterials.设计模式.g_外观模式;

public class Test {

    public static void main(String[] args) {

        Fund fund = new Fund();
        System.out.println("买入基金");
        fund.buy();
        System.out.println();
        fund.sell();
        System.out.println("赚钱了");
    }

}
