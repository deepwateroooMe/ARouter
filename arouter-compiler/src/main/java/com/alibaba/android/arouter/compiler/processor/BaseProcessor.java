package com.alibaba.android.arouter.compiler.processor;

import com.alibaba.android.arouter.compiler.utils.Logger;
import com.alibaba.android.arouter.compiler.utils.TypeUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static com.alibaba.android.arouter.compiler.utils.Consts.*;
import static com.alibaba.android.arouter.compiler.utils.Consts.NO_MODULE_NAME_TIPS;

/**
 * Base Processor
 *
 * @author zhilong [Contact me.](mailto:zhilong.lzl@alibaba-inc.com)
 * @version 1.0
 * @since 2019-03-01 12:31
 */
// 【抽象基类】：会有不同【注解类型、所对应相应的、注解处理器】子类实现类，如 AutowiredProcessor extends BaseProcessor
// AbstractProcessor: 定义和实现了，所有【注解处理器】都会用到的处理器基本方法，如获取支持的注解标签等；定义了几个可以被覆盖的方法、或被实现的抽象方法 
public abstract class BaseProcessor extends AbstractProcessor { // 实现，【抽象基类】里申明过的、几个抽象或是需要覆写的方法 
    Filer mFiler; // 
    Logger logger;
    Types types;
    Elements elementUtils;
    TypeUtils typeUtils;
    // Module name, maybe its 'app' or others
    String moduleName = null;
    // If need generate router doc
    boolean generateDoc;

    @Override // 与最抽象基类父类 AbstractProcessor 的区别是： 
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv); // 父类方法调用
        // ARouter 框架的【抽象基类】：定义框架里，几个【注解处理器】的通用【初始化】逻辑，框架里的日志、必要的初始化等
        mFiler = processingEnv.getFiler();
        types = processingEnv.getTypeUtils();
        elementUtils = processingEnv.getElementUtils();
        typeUtils = new TypeUtils(types, elementUtils);
        logger = new Logger(processingEnv.getMessager());

        // Attempt to get user configuration [moduleName]
        Map<String, String> options = processingEnv.getOptions(); // 【TODO】：这个过程：用户配置、框架扫描、编译处理等、事件的前后顺序，过程，感觉，不明白！
        // 【TODO】：理解这个过程，一种方法是，从 app-demo 的应用出发、顺藤摸瓜，把这个过程、弄明白、
        // 【TODO】：现在，先试直接从源码，理解这个过程；看不懂，找不到。。。
        // 再 app-demo 看一遍！！现在看这个。。。
        if (MapUtils.isNotEmpty(options)) { // 怎么会想要用 org.apache.commons 里、什么狗屁的 MapUtils 呢？这个库，应该是提供了必要的类型转换工具之类的帮助方法 API
            moduleName = options.get(KEY_MODULE_NAME);
            generateDoc = VALUE_ENABLE.equals(options.get(KEY_GENERATE_DOC_NAME));
        }

        if (StringUtils.isNotEmpty(moduleName)) {
            moduleName = moduleName.replaceAll("[^0-9a-zA-Z_]+", ""); // 模块的名字，只能由【0-9a-zA-z】字符集组成
            logger.info("The user has configuration the module name, it was [" + moduleName + "]");
        } else { // 没有申明，模块的名字，会抛异常、编译不通过
            logger.error(NO_MODULE_NAME_TIPS);
            throw new RuntimeException("ARouter::Compiler >>> No module name, for more information, look at gradle log.");
        }
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    @Override
    public Set<String> getSupportedOptions() {
        return new HashSet<String>() {{
            this.add(KEY_MODULE_NAME);
            this.add(KEY_GENERATE_DOC_NAME);
        }};
    }
}
