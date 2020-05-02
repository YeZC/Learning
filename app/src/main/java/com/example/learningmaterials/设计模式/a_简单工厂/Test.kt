package com.example.learningmaterials.设计模式.a_简单工厂

fun main() {

    val operation = OperationFactory.createOperation("/")
    operation.num1 = 9.0
    operation.num2 = 2.0

    println(operation.getResult())
}