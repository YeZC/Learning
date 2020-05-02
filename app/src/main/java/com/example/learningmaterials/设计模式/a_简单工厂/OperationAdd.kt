package com.example.learningmaterials.设计模式.a_简单工厂

class OperationAdd(): Operation() {

    override fun getResult(): Double {
        return num1 + num2
    }
}