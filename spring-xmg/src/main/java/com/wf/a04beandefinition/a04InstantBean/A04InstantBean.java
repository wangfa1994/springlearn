package com.wf.a04beandefinition.a04InstantBean;

import com.wf.a04beandefinition.a04InstantBean.spi.Services;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.serviceloader.ServiceLoaderFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;

/**
 * @Desc : 实例化bean
 *
 * @Author : Mr.WangF
 * @Date: 2020/11/15 10:17
 */
public class A04InstantBean {


    public static void main(String[] args) {

        BeanFactory beanFactory  = new ClassPathXmlApplicationContext("bean-instant.xml");

        // 通过构造器
        People peopleXml = (People)beanFactory.getBean("peopleXml");
        System.out.println(peopleXml);
        // 通过静态工厂方法
        People peopleStaticMethod = (People)beanFactory.getBean("peopleStaticMethod");
        System.out.println(peopleStaticMethod);
        // 通过实例工厂方法
        People peopleFactoryBean = (People)beanFactory.getBean("peopleFactoryBean");
        System.out.println(peopleFactoryBean);
        // 通过实现FactoryBean构造特殊的bean
        People peopleFactoryBeanImplement = (People)beanFactory.getBean("peopleFactoryBeanImplement");
        System.out.println(peopleFactoryBeanImplement);

        // 通过实现FactoryBean的类，会被spring管理生成一个&开头的bean
        Map<String, UserFactoryBean> beansOfType = ((ClassPathXmlApplicationContext) beanFactory).getBeansOfType(UserFactoryBean.class);
        System.out.println("getBeansOfType"+beansOfType);


        // 通过ServiceLoaderFactoryBean进行实例化 ServiceLoad 主要是使用了SPI的机制进行了加载
        ServiceLoader<Services> serviceLoader = beanFactory.getBean("serviceLoadFactoryBeans",ServiceLoader.class);
        // 从serviceLoad 中获取数据
        Iterator<Services> iterator = serviceLoader.iterator();
        while (iterator.hasNext()){
            Services next = iterator.next();
            next.fn();
        }



        // 通过AutowireCapableBeanFactory 创建bean
        ApplicationContext applicationContext  = new
                ClassPathXmlApplicationContext("bean-instant.xml");
        AutowireCapableBeanFactory autowireCapableBeanFactory = applicationContext.getAutowireCapableBeanFactory();

        /*此方式创建的bean为null的
        People bean = autowireCapableBeanFactory.createBean(People.class);
        System.out.println("autowireCapableBeanFactory:"+bean);
        */
        CreateBeanFactory bean = autowireCapableBeanFactory.createBean(CreateBeanFactory.class);
        System.out.println(bean.createPeople());


        /**
         * 后面两种方式基本为了融合spring而使用
         *
         * 还需要特别理解的是 ApplicationContext 和 BeanFactory的区别，以及
         * ApplicationContext 中的 BeanFactory属性
         * (官网前三种https://docs.spring.io/spring-framework/docs/5.2.12.BUILD-SNAPSHOT/spring-framework-reference/core.html#beans-factory-class)
         */


    }

}
