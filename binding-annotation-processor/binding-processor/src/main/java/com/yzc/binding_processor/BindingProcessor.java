package com.yzc.binding_processor;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;
import com.yzc.binding_annotation.BindView;

import java.io.IOException;
import java.util.Collections;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;

public class BindingProcessor extends AbstractProcessor {

    private Filer filer;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
        filer = processingEnvironment.getFiler();
    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        String packageName = "com.example.learningmaterials.java.annotation_processing";
        ClassName className = ClassName.get(packageName, "AnnotationActivityBinding");
        TypeSpec buildClass = TypeSpec.classBuilder(className)
                .addModifiers(Modifier.PUBLIC)
                .addMethod(MethodSpec.constructorBuilder()
                        .addModifiers(Modifier.PUBLIC)
                        .addParameter(ClassName.get(packageName, "AnnotationActivity"), "activity")
                        .addStatement("activity.textview = activity.findViewById(com.example.learningmaterials.R.id.textview1)")
                        .build())
                .build();
        try {
            JavaFile.builder(packageName, buildClass)
                    .build()
                    .writeTo(filer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return Collections.singleton(BindView.class.getCanonicalName());
    }
}
