package com.example.learningmaterials;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.LinkedList;

import kotlin.collections.unsigned.UArraysKt;

public class Demo {

    public static void main(String[] args) {
        String test = a(1);
        if (test != null) {
            System.out.println(test.length());
        }
    }

    @Nullable
    public static String a(int value){
        return value == 1 ? "1" : null;
    }
}
