package com.example.learningmaterials.设计模式.e_原型模式;

import androidx.annotation.NonNull;

public class Resume implements Cloneable {

    private String name;
    private String sex;
    private String age;
    private WorkExperience workExperience;

    private Resume(){}

    public Resume(String name) {
        this.name = name;
        workExperience = new WorkExperience();
    }


    public void setPersonalInfo(String sex, String age) {
        this.sex = sex;
        this.age = age;
    }

    public void setWorkExperience(String timeArea, String company) {
        workExperience.setWorkDate(timeArea);
        workExperience.setCompany(company);
    }

    @Override
    public String toString() {
        return "Resume{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                ", workExperience=" + workExperience +
                '}';
    }

    @NonNull
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Resume obj = new Resume();
        obj.workExperience = (WorkExperience) this.workExperience.clone();
        obj.name = this.name;
        obj.sex = this.sex;
        obj.age = this.age;
        return obj;
    }
}
