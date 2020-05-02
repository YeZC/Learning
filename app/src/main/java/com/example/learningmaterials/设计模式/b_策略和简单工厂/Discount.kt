package com.example.learningmaterials.设计模式.b_策略和简单工厂

abstract class Discount {


    abstract fun getResult(money: Double): Double
}