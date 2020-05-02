package com.example.learningmaterials.设计模式.b_策略和简单工厂

class DiscountFactory {

    companion object{

        fun createDiscount(type: Int): Discount{
            return when(type){
                1 -> ReturnDiscount(100.0, 50.0)
                2 -> RebaseDiscount(0.8)
                else -> NormalDiscount()
            }

        }
    }
}
