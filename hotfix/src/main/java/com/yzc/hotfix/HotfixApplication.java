package com.yzc.hotfix;

import android.app.Application;
import android.content.Context;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

import dalvik.system.BaseDexClassLoader;
import dalvik.system.DexClassLoader;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;

public class HotfixApplication extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
//        File apk = new File(getCacheDir() + "/hotfix.apk");
//
//        try {
//            ClassLoader originLoader = getClassLoader();
//            DexClassLoader dexClassLoader = new DexClassLoader(apk.getPath(), getCacheDir().getParent(), null, null);
//            Class loaderClass = BaseDexClassLoader.class;
//            Field pathListField = loaderClass.getDeclaredField("pathList");
//            pathListField.setAccessible(true);
//            Object pathListObject = pathListField.get(dexClassLoader);
//
//            Class pathListClass = pathListObject.getClass();
//            Field dexElementsField = pathListClass.getDeclaredField("dexElements");
//            dexElementsField.setAccessible(true);
//            Object dexElementsObject = dexElementsField.get(pathListObject);
//
//            Object originPathListObject = pathListField.get(originLoader);
//            dexElementsField.set(originPathListObject, dexElementsObject);
//        } catch (NoSuchFieldException | IllegalAccessException e) {
//            e.printStackTrace();
//        }
    }
}
