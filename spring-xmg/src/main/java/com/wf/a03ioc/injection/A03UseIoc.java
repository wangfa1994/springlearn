package com.wf.a03ioc.injection;

import com.wf.model.Student;
import lombok.val;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @Desc : IOC的使用
 * @Author : Mr.WangF
 * @Date: 2020/10/25 19:45
 */
public class A03UseIoc {


    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean-lookup.xml");

        Map<String, Student> beansOfType = applicationContext.getBeansOfType(Student.class);

        System.out.println("通过ApplicationContext获取bean"+beansOfType);



        /*
        *  ApplicationContext 是 BeanFactory 封装的企业级实现
        *  所以可以类比ApplicationContext的使用
        *
        *  注意 DefaultListableBeanFactory 本身也是一个 BeanDefinitionRegistry
         */
        //BeanFactory 的使用
        // 1、创建工厂
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2、创建读取器
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);

        //加载配置文件 返回装载的bean的个数

        int i = reader.loadBeanDefinitions("classpath:bean-lookup.xml");

        // 依赖查找
        Map<String, Student> beansOfType1 = beanFactory.getBeansOfType(Student.class);
        System.out.println("通过自己配置进行获取的bean"+beansOfType1);




        // 注解方式

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();

        // 注册配置类
        annotationConfigApplicationContext.register(A03UseIoc.class);
        // 容器刷新
        annotationConfigApplicationContext.refresh();

        Student student = (Student)annotationConfigApplicationContext.getBean("student");
        System.out.println(student);


    }

    @Bean
    public Student student(){
        Student student = new Student();
        student.setId(1);
        student.setName("fafa");
        return student;
    }
}
