package com.wf.a04beandefinition.a05InitializationBean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

/**
 * @Desc : 初始化bean
 * @Author : Mr.WangF
 * @Date: 2020/11/15 15:30
 */
public class A05InitializationBean {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();

        annotationConfigApplicationContext.register(A05InitializationBean.class);
        annotationConfigApplicationContext.refresh();

        annotationConfigApplicationContext.close();

    }


    @Bean(initMethod = "initMethod")
    @Lazy
    public TeacherBean teacherBean(){
        return new TeacherBean();
    }


}
