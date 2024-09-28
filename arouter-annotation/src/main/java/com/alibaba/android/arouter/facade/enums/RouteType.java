package com.alibaba.android.arouter.facade.enums;

/**
 * Type of route enum.
 *
 * @author Alex <a href="mailto:zhilong.liu@aliyun.com">Contact me.</a>
 * @version 1.0
 * @since 16/8/23 22:27
 */
// 多组件应用、框架可能提供导航的、安卓组件类型：也就是，框架导航的处理能力，超出安卓的这些最常用的几大组件类型，无力再、也不再处理了 UNKNOWN...
// 四大组件Activity/Fragment,Service,ContentProvider,Broadcast,Method, Unknown, 和 PROVIDER
// 自定义？一个PROVIDER: 指向"com.alibaba.android.arouter.facade.template.IProvider", 是什么意思呢？【TODO】：
public enum RouteType {
    ACTIVITY(0, "android.app.Activity"),
    SERVICE(1, "android.app.Service"),
    PROVIDER(2, "com.alibaba.android.arouter.facade.template.IProvider"), // <<<<<<<<<<<<<<<<<<<< 【TODO】：去找使用场景
    CONTENT_PROVIDER(-1, "android.app.ContentProvider"),
    BOARDCAST(-1, ""),
    METHOD(-1, ""),
    FRAGMENT(-1, "android.app.Fragment"),
    UNKNOWN(-1, "Unknown route type");

    int id;
    String className;

    public int getId() {
        return id;
    }

    public RouteType setId(int id) {
        this.id = id;
        return this;
    }

    public String getClassName() {
        return className;
    }

    public RouteType setClassName(String className) {
        this.className = className;
        return this;
    }

    RouteType(int id, String className) {
        this.id = id;
        this.className = className;
    }

    public static RouteType parse(String name) {
        for (RouteType routeType : RouteType.values()) {
            if (routeType.getClassName().equals(name)) {
                return routeType;
            }
        }
        return UNKNOWN; // 找不到的，都返回这个，标记出错
    }
}
