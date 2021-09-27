package com.yzc.binding;

import android.app.Activity;

import com.yzc.binding_annotation.BindView;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Binding {

    /**
     * 反射实现
     * @param activity
     */
//    public static void bind(Activity activity){
//        for (Field field : activity.getClass().getDeclaredFields()) {
//            BindView bindView = field.getAnnotation(BindView.class);
//            if(bindView != null){
//                try {
//                    field.setAccessible(true);
//                    field.set(activity, activity.findViewById(bindView.value()));
//                } catch (IllegalAccessException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }

    public static void bind(Activity activity){
        try {
            Class<?> classz = Class.forName(activity.getClass().getCanonicalName() + "Binding");
            Constructor<?> constructor = classz.getConstructor(activity.getClass());
            constructor.newInstance(activity);
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
