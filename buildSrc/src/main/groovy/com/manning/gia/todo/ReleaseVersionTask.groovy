package com.manning.gia.todo

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Optional
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction

/**
 * 自定义task类型
 */
class ReleaseVersionTask extends DefaultTask {
    //使用注解@Input、@OutputFile声明task的输入\输出，也可以使用默认的输入\输出(inputs\outputs)。@Input注解在配置期间验证属性值，如果为null抛出异常，所以需要添加@Optional
    @Optional
    @Input
    Boolean release
    @OutputFile
    File destFile

    //使用注解声明task的执行方法
    @TaskAction
    void action(){
        project.version.release = true
        ant.propertyfile(file: destFile) {
            entry(key: 'release', value: 'true') //同步版本信息文件
        }
    }
}
