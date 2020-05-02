package com.example.learningmaterials.设计模式.a_简单工厂

class OperationFactory {

    companion object{

        fun createOperation(operationStr: String): Operation{
            val op: Operation = when(operationStr){
                "+" -> OperationAdd()
                "-" -> OperationSub()
                "*" -> OperationMul()
                "/" -> OperationDiv()
                else -> OperationAdd()
            }
            return op
        }
    }

}