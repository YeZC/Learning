# Android Gradle Plugin(AGP)


### gradle plugin开发
1.在项目中新建module，命名为buildSrc，AS自动生成可使用的插件依赖
2.继承Plugin<Project>编写插件任务、Extension用于build.gradle文件中配置插件参数、Transform干预代码从java -> class的过程
3.resources中注册让插件生效
4.build.grade中通过apply plugin: 'xxx'应用插件


### 打包流程（粗略的手动打包流程）
这个整理已 gradle-plugin-demo 为例手动使用工具打包apk的流程，
打包目录为 gradle-plugins 下的 build文件：

```
// 产物位置
cd gradle-plugins
mkdir build
// 编译资源文件
aapt2 compile -o build/res.zip --dir ./gradle-plugin-demo/src/main/res
// 资源连接, 生成 R.java文件和 app-debug.apk
aapt2 link build/res.zip -I $ANDROID_HOME/platforms/android-30/android.jar --java build --manifest ./gradle-plugin-demo/src/main/AndroidManifest.xml -o build/app-debug.apk
// 编译源代码文件
cp -r ./gradle-plugin-demo/src/main/java/com ./build
javac -d build -cp $ANDROID_HOME/platforms/android-30/android.jar ./build/com/**/**/*.java
// 输出dex文件
d8 --output build/ --lib $ANDROID_HOME/platforms/android-30/android.jar build/com/yzc/gradle_plugins/*.class
// dex文件和apk文件合并
zip -j build/app-debug.apk build/classes.dex
// apk签名
apksigner sign --ks ~/.android/debug.keystore build/app-debug.apk
// 完了之后需要手动删除该文件夹
// todo 最终包无法安装
```

### 调式gradle源码
1.complieOnly依赖'com.android.tools.build:gradle:4.0.1'
2.Edit Configurations 添加 remote运行模式
3.在Terminal 中执行 ./gradlew assembleDebug -Dorg.gradle.debug=true
4.点运行debug