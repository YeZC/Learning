package com.yzc.hotfix;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

import dalvik.system.BaseDexClassLoader;
import dalvik.system.DexClassLoader;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;

public class HotfixMainActivity extends AppCompatActivity {

    TextView showTV;
    Button showBT;
    Button hotfixBT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotfix_main);

        showTV = findViewById(R.id.tv_show);
        showBT = findViewById(R.id.bt_show);
        hotfixBT = findViewById(R.id.bt_hotfix);
        showBT.setOnClickListener(v -> {
            Title title = new Title();
            showTV.setText(title.getTitle());
        });
        hotfixBT.setOnClickListener(v -> {
            File apk = new File(getCacheDir() + "/hotfix.apk");
            if(!apk.exists()){
                try(Source source = Okio.source(getAssets().open("apk/hotfix.apk"));
                    BufferedSink sink = Okio.buffer(Okio.sink(apk))){
                    sink.writeAll(source);
                }catch (IOException e){
                    e.printStackTrace();
                }
            }

            try {
                ClassLoader originLoader = getClassLoader();
                DexClassLoader dexClassLoader = new DexClassLoader(apk.getPath(), getCacheDir().getPath(), null, null);
                Class loaderClass = BaseDexClassLoader.class;
                Field pathListField = loaderClass.getDeclaredField("pathList");
                pathListField.setAccessible(true);
                Object pathListObject = pathListField.get(dexClassLoader);

                Class pathListClass = pathListObject.getClass();
                Field dexElementsField = pathListClass.getDeclaredField("dexElements");
                dexElementsField.setAccessible(true);
                Object dexElementsObject = dexElementsField.get(pathListObject);

                Object originPathListObject = pathListField.get(originLoader);
                dexElementsField.set(originPathListObject, dexElementsObject);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }
}