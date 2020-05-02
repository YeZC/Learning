package com.example.learningmaterials.设计模式.b_策略和简单工厂

class ReturnDiscount(val over: Double, val discount: Double) : Discount() {
    override fun getResult(money: Double): Double {
        return if(money > over) money - discount else money
    }

}