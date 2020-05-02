package com.example.learningmaterials.设计模式.b_策略和简单工厂

class RebaseDiscount(val percent: Double) : Discount() {
    override fun getResult(money: Double): Double {
        return money * percent
    }

}