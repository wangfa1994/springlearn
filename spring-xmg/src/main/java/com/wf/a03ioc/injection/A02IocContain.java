package com.wf.a03ioc.injection;

import com.wf.repository.StudentRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Desc : beanFactory 与 ApplicationContext 谁才是真正的容器
 * @Author : Mr.WangF
 * @Date: 2020/10/25 17:35
 */
public class A02IocContain {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("bean-injection.xml");

        StudentRepository studentRepository = (StudentRepository) classPathXmlApplicationContext.getBean("studentRepositoryAuto");

        System.out.println("context自动注入的bean:" + studentRepository.getBeanFactory());


        //BeanFactory beanFactoryByTypeWithContext = classPathXmlApplicationContext.getBean(BeanFactory.class);
        //System.out.println("context根据类型获取" + beanFactoryByTypeWithContext);


        BeanFactory beanFactory = new ClassPathXmlApplicationContext("bean-injection.xml");

        StudentRepository studentRepositoryWithBeanFactory = (StudentRepository) beanFactory.getBean("studentRepositoryAuto");

        System.out.println("beanFactory自动注入的bean:" + studentRepositoryWithBeanFactory.getBeanFactory());


        //BeanFactory beanFactoryByType = beanFactory.getBean(BeanFactory.class);
       // System.out.println("beanFactory" + beanFactoryByType);

        BeanFactory defaultListableBeanFactory = beanFactory.getBean(DefaultListableBeanFactory.class);
        //System.out.println("defaultListableBeanFactory" + defaultListableBeanFactory);





        /*
         * 为什么注入内建的bean的时候回返回 DefaultListableBeanFactory 而从容器中获取却获取不到？
         *
         *
         * ClassPathXmlApplicationContext -> AbstractRefreshableApplicationContext ->BeanFactory
         *
         * 在 AbstractRefreshableApplicationContext 中存在一个属性 DefaultListableBeanFactory ,这个是beanFactory，
         *
         * 再注意看getBean这个实现方法，这个是 getBeanFactory().getBean(requiredType) ,
         * 有代理模式的感觉，
         * AbstractRefreshableApplicationContext 本身就是一个BeanFactory, 但是在我的内部，我又维护了一个BeanFactory 实例
         * 这样的话，就可以通过这个BeanFactory实例DefaultListableBeanFactory帮我做一些事情，
         *
         * */


    }
}
