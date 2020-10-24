package com.wf.a01;

import com.wf.model.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: wangfa
 * @Date: 2020/10/22 21:54
 * @Description: 通过xml配置我们的bean
 */
public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Person person = (Person)context.getBean("person");
        System.out.println(person);
    }
}
