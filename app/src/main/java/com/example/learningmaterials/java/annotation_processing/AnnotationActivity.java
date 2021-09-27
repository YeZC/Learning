package com.example.learningmaterials.java.annotation_processing;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.example.learningmaterials.R;
import com.yzc.binding.Binding;
import com.yzc.binding_annotation.BindView;

public class AnnotationActivity extends AppCompatActivity{

    @BindView(R.id.textview1)
    TextView textview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_annotation);

        Binding.bind(this);

        textview.setText("yezhaochu");
    }

}
