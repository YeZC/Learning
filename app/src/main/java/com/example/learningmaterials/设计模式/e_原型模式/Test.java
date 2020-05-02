package com.example.learningmaterials.设计模式.e_原型模式;

public class Test {

    public static void main(String[] args) throws CloneNotSupportedException {

        Resume resume = new Resume("mike");

        resume.setPersonalInfo("boy", "22");
        resume.setWorkExperience("2019.04-2020.04", "XXX company");

        Resume resume1 = (Resume) resume.clone();
        resume1.setPersonalInfo("gril", "20");
        resume1.setWorkExperience("2018.04-2029.09", "XXX company");

        System.out.println(resume);
        System.out.println(resume1);
    }

}
