package com.wf.a04beandefinition.a03RegisterBeanDefinition;

import org.springframework.context.annotation.Import;

/**
 * @Desc :
 * @Author : Mr.WangF
 * @Date: 2020/11/8 17:43
 */
// 通过import 将JavaApiConfig中的bean进行注册
@Import(JavaAnnotationConfig.class)
public class JavaAnnotationImportConfig {

}
