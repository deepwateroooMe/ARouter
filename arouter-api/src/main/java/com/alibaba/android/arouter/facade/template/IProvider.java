package com.alibaba.android.arouter.facade.template;

import android.content.Context;

/**
 * Provider interface, base of other interface.
 *
 * @author Alex <a href="mailto:zhilong.liu@aliyun.com">Contact me.</a>
 * @version 1.0
 * @since 16/8/23 23:08
 */
public interface IProvider {

    /**
     * Do your init work in this method, it will be called when processor has been load.
     【TODO】：【注解处理器】加载后，为什么、会调用这里呢？
     *
     * @param context ctx
     */
    void init(Context context);
}
