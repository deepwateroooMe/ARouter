package com.alibaba.android.arouter.register.utils

 // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
import org.gradle.api.Project

/**
 * Format log
 *
 * @author zhilong <a href="mailto:zhilong.lzl@alibaba-inc.com">Contact me.</a>
 * @version 1.0
 * @since 2017/12/18 下午2:43
 */
class Logger {
    static org.gradle.api.logging.Logger logger

    static void make(Project project) {
        logger = project.getLogger()
    }

    static void i(String info) {
        if (null != info && null != logger) {
            logger.info("ARouter::Register >>> " + info)
        }
    }

    static void e(String error) {
        if (null != error && null != logger) {
            logger.error("ARouter::Register >>> " + error)
        }
    }

    static void w(String warning) {
        if (null != warning && null != logger) {
            logger.warn("ARouter::Register >>> " + warning)
        }
    }
}
