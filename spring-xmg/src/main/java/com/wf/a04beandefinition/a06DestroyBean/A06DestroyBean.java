package com.wf.a04beandefinition.a06DestroyBean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

/**
 * @Desc : 初始化bean
 * @Author : Mr.WangF
 * @Date: 2020/11/15 15:30
 */
public class A06DestroyBean {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();

        annotationConfigApplicationContext.register(A06DestroyBean.class);
        annotationConfigApplicationContext.refresh();

        System.out.println("即将关闭容器");
        annotationConfigApplicationContext.close();
        System.out.println("关闭容器");

    }



    @Bean(destroyMethod = "destroyMethod")
    public TeacherBean teacherBean(){
        return new TeacherBean();
    }


}
