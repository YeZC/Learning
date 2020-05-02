package com.example.learningmaterials.设计模式.f_方法模板;

public class Test {

    public static void main(String[] args) {

        TestPaper paper = new StudentATestPaper();
        System.out.println("StudentA 的答案: ");
        paper.requestA();
        paper.requestB();
        paper.requestC();

        paper = new StudentBTestPaper();
        System.out.println("StudentB 的答案: ");
        paper.requestA();
        paper.requestB();
        paper.requestC();
    }

}
