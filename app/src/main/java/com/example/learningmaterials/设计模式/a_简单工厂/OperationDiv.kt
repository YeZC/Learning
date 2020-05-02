package com.example.learningmaterials.设计模式.a_简单工厂

class OperationDiv(): Operation() {

    override fun getResult(): Double {
        if(num2 == 0.0) return throw Exception("num2 被除数不能为0")
        return num1 / num2
    }
}