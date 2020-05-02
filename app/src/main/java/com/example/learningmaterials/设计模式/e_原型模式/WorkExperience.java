package com.example.learningmaterials.设计模式.e_原型模式;

import androidx.annotation.NonNull;

public class WorkExperience implements  Cloneable{

    private String workDate;
    private String company;

    public String getWorkDate() {
        return workDate;
    }

    public void setWorkDate(String workDate) {
        this.workDate = workDate;
    }

    @Override
    public String toString() {
        return "WorkExperience{" +
                "workDate='" + workDate + '\'' +
                ", company='" + company + '\'' +
                '}';
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @NonNull
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
