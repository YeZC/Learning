# 热更新

### 热更新实现，demo介绍：
 show text -> hot fix -> kill myself -> 重新启动App -> show text -> 内容更新

原理：
1. 把更新的java文件编译成dex
2. 通过任何方式将dex放到本地缓存目录
3. 反射使用ClassLoader将新dex放在旧dex之前
4. 重启app使ClassLoader生效

### 生成dex文件
```
/*
1.patchPath 指定需要打dex的文件路径
2.执行./gradlew hotfix
*/
def patchPath = 'com/yzc/hotfix/Title'
task hotfix {
    doLast {
        exec {
            commandLine 'rm', "-rf", './build/patch'
        }
        exec {
            commandLine 'mkdir', './build/patch'
        }
        exec {
            commandLine 'javac', "./src/main/java/${patchPath}.java", '-d', './build/patch'
        }
        exec {
            commandLine '/Users/yezhaochu/Library/Android/sdk/build-tools/29.0.3/d8', "./build/patch/${patchPath}.class", '--output', './build/patch'
        }
        exec {
            commandLine 'mv', "./build/patch/classes.dex", './build/patch/hotfix.dex'
        }
    }
}
```