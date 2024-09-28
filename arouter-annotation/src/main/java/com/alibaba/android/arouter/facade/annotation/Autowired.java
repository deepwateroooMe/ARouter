package com.alibaba.android.arouter.facade.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * Annotation for field, which need autowired.
 * @author zhilong <a href="mailto:zhilong.lzl@alibaba-inc.com">Contact me.</a>
 * @version 1.0
 * @since 2017/2/20 下午4:26
 */
@Target({ElementType.FIELD}) // @Autowired 注解：作用在，【成员变量 Field】上. 网上说，更精确地描述为【域】！！
// 注解 @Retention可以用来修饰注解，是注解的注解，称为元注解。
// RetentionPolicy.CLASS：注解被保留到class文件，但jvm加载class文件时候被遗弃，这是默认的生命周期；
@Retention(RetentionPolicy.CLASS) // 编译器要丢弃的注释、被编译器忽略！【TODO】：是说， @Autowired 注解，永远只注解处理执行一次，便ARouter 库？里存了备份，以后不用顾虑任何了？
// 一般，如果要在编译时进行一些预处理操作，比如生成一些辅助代码（如 ButterKnife），就用 CLASS注解；
public @interface Autowired {

    // Mark param's name or service name.
    String name() default "";

    // If required, app will be crash when value is null.
    // Primitive type wont be check!
    boolean required() default false;

    // Description of the field
    String desc() default "";
}
