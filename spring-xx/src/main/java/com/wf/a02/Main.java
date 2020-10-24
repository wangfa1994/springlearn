package com.wf.a02;

import com.wf.model.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: wangfa
 * @Date: 2020/10/22 22:02
 * @Description:
 */
public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);

        String[] beanNamesForType = context.getBeanNamesForType(Person.class);
        for (int i = 0; i < beanNamesForType.length; i++) {
            System.out.println(beanNamesForType[i]);
        }

    }
}
