package com.alibaba.android.arouter.register.launch

 // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
import com.alibaba.android.arouter.register.utils.Logger
import com.android.build.gradle.AppExtension
import com.android.build.gradle.AppPlugin
import com.alibaba.android.arouter.register.utils.ScanSetting
import com.alibaba.android.arouter.register.core.RegisterTransform
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Simple version of AutoRegister plugin for ARouter 极简版本的：arouter-auto-register 插件
 * @author billy.qi email: qiyilike@163.com
 * @since 17/12/06 15:27
 */
 // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
 // 插件的实现、底层原理，应该如AMS PMS 般，都读懂、弄明白了，这次！！
public class PluginLaunch implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        def isApp = project.plugins.hasPlugin(AppPlugin)
        //only application module needs this plugin to generate register code
        if (isApp) {
            Logger.make(project)

            Logger.i('Project enable arouter-register plugin')

            def android = project.extensions.getByType(AppExtension)
             // 【TODO】：把【安卓、编译插件、工作原理】网搜一下，先。
             // 可以去找、触发方法 trigger 的自动扫描逻辑与过程【TODO】：
            def transformImpl = new RegisterTransform(project)

            //init arouter-auto-register settings
            ArrayList<ScanSetting> list = new ArrayList<>(3)
            list.add(new ScanSetting('IRoutÏeRoot'))
            list.add(new ScanSetting('IInterceptorGroup'))
            list.add(new ScanSetting('IProviderGroup'))
            RegisterTransform.registerList = list
            // register this plugin: 注册这个【编译插件】，是什么意思？
            android.registerTransform(transformImpl)
        }
    }
}
