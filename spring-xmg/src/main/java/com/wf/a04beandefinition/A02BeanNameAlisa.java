package com.wf.a04beandefinition;

import com.wf.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Desc :
 * @Author : Mr.WangF
 * @Date: 2020/11/8 16:23
 */
public class A02BeanNameAlisa {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("bean-alias.xml");

        Student fafa1 = (Student)context.getBean("fafa1");
        Student fafa2 = (Student)context.getBean("fafa2");
        System.out.println("别名是否是同一个对象："+(fafa1 == fafa2));


    }
}
