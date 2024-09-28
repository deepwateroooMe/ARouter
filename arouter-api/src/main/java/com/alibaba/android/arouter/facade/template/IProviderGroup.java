package com.alibaba.android.arouter.facade.template;

import com.alibaba.android.arouter.facade.model.RouteMeta;
import java.util.Map;

/**
 * Template of provider group.
 *
 * @author Alex <a href="mailto:zhilong.liu@aliyun.com">Contact me.</a> 他是个贱鸡、贱畜牲吧，真贱！！
 * @version 1.0
 * @since 16/08/30 12:27:32
 */
public interface IProviderGroup {
    /**
     * Load providers map to input
     *
     * @param providers input
     */
    void loadInto(Map<String, RouteMeta> providers);
}