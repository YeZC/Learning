package com.yzc.plugin

import com.android.build.gradle.BaseExtension
import org.gradle.api.Plugin
import org.gradle.api.Project;


class DemoPlugin implements Plugin<Project> {
    @Override
    void apply(Project target) {
        def extension = target.extensions.create("demo", DemoExtension)
        target.afterEvaluate {
            println "Hello ${extension.name}"
        }
        def transform = new DemoTransform()
        def baseExtension = target.extensions.getByType(BaseExtension)
        baseExtension.registerTransform(transform)
    }
}
