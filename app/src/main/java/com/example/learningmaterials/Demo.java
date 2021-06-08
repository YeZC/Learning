package com.example.learningmaterials;

import androidx.annotation.IntDef;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import kotlin.collections.unsigned.UArraysKt;

public class Demo {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        setAlpha(in.nextInt());

        setNavigationMode(NAVIGATION_MODE_LIST);
        setDisplayOptions(NAVIGATION_MODE_LIST);
    }

    public static void setAlpha(@IntRange(from = 0, to = 255) int alpha) {
        System.out.println(alpha);
    }

    @IntDef(flag=false, value={
            NAVIGATION_MODE_STANDARD,
            NAVIGATION_MODE_LIST,
            NAVIGATION_MODE_TABS,
    })
    @Retention(RetentionPolicy.SOURCE)
    public @interface DisplayOptions {}

    // Attach the annotation
    public static void setDisplayOptions(@DisplayOptions int mode){};

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({NAVIGATION_MODE_STANDARD, NAVIGATION_MODE_LIST, NAVIGATION_MODE_TABS})
    public @interface NavigationMode {}

    // Declare the constants
    public static final int NAVIGATION_MODE_STANDARD = 0;
    public static final int NAVIGATION_MODE_LIST = 1;
    public static final int NAVIGATION_MODE_TABS = 2;

    // Decorate the target methods with the annotation
    @NavigationMode
    public int getNavigationMode(){return 0;};

    // Attach the annotation
    public static void setNavigationMode(@NavigationMode int mode){};

    @Nullable
    public static String a(int value) {
        return value == 1 ? "1" : null;
    }
}
