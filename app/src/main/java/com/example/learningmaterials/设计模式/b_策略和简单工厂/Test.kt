package com.example.learningmaterials.设计模式.b_策略和简单工厂

fun main() {

    val total = 300.0
    // 0 正常收费 1 满100减50 2 8折
    val discount = DiscountFactory.createDiscount(1)

    println("${discount.getResult(total)}")
}