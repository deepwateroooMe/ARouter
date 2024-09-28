package com.alibaba.android.arouter.facade.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Mark a interceptor to interception the route.
 * BE ATTENTION : This annotation can be mark the implements of #{IInterceptor} ONLY!!!
 *
 * @author Alex <a href="mailto:zhilong.liu@aliyun.com">Contact me.</a>
 * @version 1.0
 * @since 16/8/23 14:03
 */
// 作用在：ElementType.TYPE 上。ElementType.TYPE
// 【修饰类型】：比如接口、类、枚举、注解
@Target({ElementType.TYPE}) // TYPE: 是指，类、接口(包括注解类型)、枚举、Annotation类型
@Retention(RetentionPolicy.CLASS)
public @interface Interceptor {
    /**
     * The priority of interceptor, ARouter will be excute them follow the priority.
     根据优先级来，也就是，必要的时候，框架可能会不处理、优先级低的拦截 request. 【TODO】：把这个逻辑、找出来
     */
    int priority();

    /**
     * The name of interceptor, may be used to generate javadoc.
     */
    String name() default "Default";
}
