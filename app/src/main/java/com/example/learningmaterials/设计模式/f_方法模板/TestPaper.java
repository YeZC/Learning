package com.example.learningmaterials.设计模式.f_方法模板;

public abstract class TestPaper {

    public void requestA(){
        System.out.println("题目一的答案为: " + answerA());
    }

    public void requestB(){
        System.out.println("题目二的答案为: " + answerB());
    }

    public void requestC(){
        System.out.println("题目三的答案为: " + answerC());
    }

    public abstract String answerA();
    public abstract String answerB();
    public abstract String answerC();
}
