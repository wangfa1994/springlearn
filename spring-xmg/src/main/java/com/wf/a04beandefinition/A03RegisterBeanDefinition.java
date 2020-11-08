package com.wf.a04beandefinition;

import com.wf.model.Student;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Map;

/**
 * @Desc :
 * @Author : Mr.WangF
 * @Date: 2020/11/8 17:22
 */
public class A03RegisterBeanDefinition {


    public static void main(String[] args) {

        // java注解方式bean 和import
        //javaAnnotationBean();
        //javaAnnotationImport();


        // java api方式
//        javaApiBeanDefinitionRegistry();

//        javaApiBeanDefinitionReaderUtils();
      //  javaApiAnnotatedBeanDefinitionReader();

    }

    private static void javaApiAnnotatedBeanDefinitionReader() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(A03RegisterBeanDefinition.class);
        context.refresh();

        AnnotatedBeanDefinitionReader annotatedBeanDefinitionReader = new AnnotatedBeanDefinitionReader(context);

        annotatedBeanDefinitionReader.register(Student.class);

        Map<String, Student> beansOfType = context.getBeansOfType(Student.class);
        // 此方法注册会没有初始化值
        System.out.println(beansOfType);

    }

    private static void javaApiBeanDefinitionReaderUtils() {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(A03RegisterBeanDefinition.class);
        context.refresh();

        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(Student.class);
        beanDefinitionBuilder
                .addPropertyValue("id",1)
                .addPropertyValue("name","fafa");


        String s = BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(), context);

        Student student= (Student) context.getBean(s);
        System.out.println("ApiBeanDefinitionReaderUtils:"+student);

    }


    private static void javaApiBeanDefinitionRegistry() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(A03RegisterBeanDefinition.class);
        context.refresh();

        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(Student.class);
        builder.addPropertyValue("id", 1);
        builder.addPropertyValue("name", "fafa");

        // 注意:context 也是一个beanDefinitionRegister注册器，实现了BeanDefinitionRegistry
        context.registerBeanDefinition("fafa",builder.getBeanDefinition());

        Student fafa = (Student) context.getBean("fafa");
        System.out.println("javaApiBeanDefinitionRegistry:" + fafa);
    }





    /**
     * Annotation 方式
     **/

    public static void javaAnnotationBean() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        // 加载指定配置类
        context.register(Config.class);
        context.refresh();
        Student fafa = (Student) context.getBean("fafa");
        System.out.println("javaAnnotationBean:" + fafa);
    }


    public static void javaAnnotationImport() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        // 加载指定配置类 ，通过Import注解，可以将其他bean进行注册
        context.register(JavaAnnotationImportConfig.class);
        context.refresh();
        Student fafa = (Student) context.getBean("fafa");
        System.out.println("javaAnnotationImport:" + fafa);
    }

    /**
     * 配置的内部类为什么要public static 才可以使用 ,而对于外部的JavaApiConfig可以直接使用
     **/
    public static class Config {
        @Bean(name = {"fafa", "qiuqiu"})
        private Student student() {
            Student student = new Student();
            student.setId(1);
            student.setName("fafa");
            return student;
        }
    }

}
