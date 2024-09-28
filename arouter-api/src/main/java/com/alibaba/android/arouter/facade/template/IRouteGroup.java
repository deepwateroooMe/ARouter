package com.alibaba.android.arouter.facade.template;

import com.alibaba.android.arouter.facade.model.RouteMeta;

import java.util.Map;

/**
 * Group element.
 *
 * @author Alex <a href="mailto:zhilong.liu@aliyun.com">Contact me.</a>
 * @version 1.0
 * @since 16/8/22 16:27:32
 */
// IRouteGroup实现类是编译时生成，代表一个组，即path第一级相同的所有路由，包括Activity和Provider服务。【源】
// RouteProcessor 是一个注解处理器，是 AbstractProcessor 的子类。
// 在 RouteProcessor 的 process() 方法中，会调用 parseRoutes() 方法，parseRoutes() 方法会用 JavaPoet API 来生成 Java 代码，具体的代码就是 Activity 等类的 Class 信息
// 除了 RouteProcessor ，ARouter 中还有参数注解处理器 AutowiredProcessor 和拦截器注解处理器 InterceptorProcessor ，它们的原理和 RouteProcessor 是一样的。
// 【导航、组】的引入与功用：提升框架性能。
// 既不能，编译时批量、一次性扫描、加载和处理，源码里所有的【此框架定义过的、四个注解】容易暴内存、暴CPU? 显著延迟
// 又不能，【懒加载】。懒加载，在扫描注解、注解处理器处理，想不出，性能优化上，会有什么帮助。
// 引入【组】的概念后，框架提供【按需加载、必要时加载】。当需要、必要时，框架提供，扫描和加载【本组 IRouteGroup】里所有导航相关？
// 【TODO】：这只是活宝妹的 impression, 去确认
public interface IRouteGroup { // 它的实现类，是编译时自动生成的？不明白【TODO】：今天上午，可以把它看明白 
    /**
     * Fill the atlas with routes in group.
     */
    void loadInto(Map<String, RouteMeta> atlas);
}
