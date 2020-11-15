package com.wf.a04beandefinition.a03RegisterBeanDefinition;

import com.wf.model.Student;
import org.springframework.context.annotation.Bean;

/**
 * @Desc :
 * @Author : Mr.WangF
 * @Date: 2020/11/8 17:36
 */
public class JavaAnnotationConfig {

    @Bean(name = {"fafa","qiuqiu"})
    private Student student(){
        Student student = new Student();
        student.setId(1);
        student.setName("fafa");
        return student;
    }
}
