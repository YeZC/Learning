package com.yzc.hotfix;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Process;
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
    Button removeHotfixBT;
    Button killBT;

    File apk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotfix_main);
        apk = new File(getCacheDir() + "/hotfix.dex");

        showTV = findViewById(R.id.tv_show);
        showBT = findViewById(R.id.bt_show);
        hotfixBT = findViewById(R.id.bt_hotfix);
        removeHotfixBT = findViewById(R.id.bt_remove_hotfix);
        killBT = findViewById(R.id.bt_kill);

        showBT.setOnClickListener(v -> {
            Title title = new Title();
            showTV.setText(title.getTitle());
        });
        hotfixBT.setOnClickListener(v -> {
            File apk = new File(getCacheDir() + "/hotfix.dex");
            if(!apk.exists()){
                try(Source source = Okio.source(getAssets().open("hotfix.dex"));
                    BufferedSink sink = Okio.buffer(Okio.sink(apk))){
                    sink.writeAll(source);
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            // 点击后，杀掉程序
        });

        removeHotfixBT.setOnClickListener(v ->{
            if(apk.exists()) apk.delete();
        });

        killBT.setOnClickListener(v ->{
            Process.killProcess(Process.myPid());
        });
    }
}