# Annotation processing

### 控件绑定注解
1. 通过自定义的@BindView 自动生成控件绑定代码
2. binding-annotation模块，包含声明的注解，定义注解的使用范围包括 Retention：处理注解时机，本模块为保留到编译源码、Target：注解服务对象，本模块为Field
3. binding-processor模块，为代码生成器，操作Filer生成该注解对应的模板代码
4. binding模块，运行期注解功能的入口，一般通过反射调用（3）运行注解的逻辑
5. 理解：@BindView在编译期生成代码，通过Binding类作为注解功能的入口

