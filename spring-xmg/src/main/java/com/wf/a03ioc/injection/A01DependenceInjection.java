package com.wf.a03ioc.injection;

import com.wf.repository.StudentRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

/**
 * @Desc : 依赖注入
 * @Author : Mr.WangF
 * @Date: 2020/10/25 10:23
 */
public class A01DependenceInjection {


    public static void main(String[] args) {


        BeanFactory beanFactory = new ClassPathXmlApplicationContext("bean-injection.xml");

        /*
        * 任何一个有实际意义的应用（肯定比Hello World示例更复杂）都会由两个或者更多的类组成，
        * 这些类相互之间进行协作来完成特定的业务逻辑
        *
        * 依赖注入，讲的是bean与bean之间的写作关系
        *
        * */

        // 依赖注入--手动
        StudentRepository studentRepository = (StudentRepository) beanFactory.getBean("studentRepository");
        System.out.println("依赖注入手动"+ studentRepository);

        // 依赖注入--自动
        StudentRepository studentRepositoryAuto = (StudentRepository) beanFactory.getBean("studentRepositoryAuto");
        System.out.println("依赖注入自动"+ studentRepositoryAuto);


        // 依赖注入 --注入spring容器bean

        StudentRepository studentRepositoryBeanFactoryProperty = (StudentRepository)beanFactory.getBean("studentRepositoryAuto");

        BeanFactory beanFactoryWithProperty = studentRepositoryBeanFactoryProperty.getBeanFactory();
        System.out.println("依赖注入自动，注入spring属性beanFactory："+beanFactoryWithProperty);
        System.out.println("容器beanFactory：" + beanFactory);
        System.out.println("容器beanFactory == 依赖注入的beanFactory："+(beanFactory == beanFactoryWithProperty));

       // System.out.println("根据type 是否可以得到我们的bean:"+beanFactory.getBean(BeanFactory.class));

        // 为什么我们注入的内建的beanFactory可以得到，但是从容器中根据类型却获取不到我们的BeanFactory,为什么，
        // 或者是依赖注入和依赖查找的来源不一致？？ 是非Bean吗？


        // 依赖注入 --延迟注入 也是利用ObjectFactory

        ObjectFactory<BeanFactory> objectFactory = studentRepositoryBeanFactoryProperty.getObjectFactory();
        BeanFactory beanFactoryWithObjectFactory = objectFactory.getObject();
        System.out.println("依赖注入自动，通过延迟注入："+beanFactoryWithObjectFactory);
        System.out.println("通过延迟注入的内建bean，与实时注入的内建bean："+(beanFactoryWithProperty == beanFactoryWithObjectFactory));


        Environment environment = beanFactory.getBean(Environment.class);
        System.out.println(environment);

    }


    public static void whoIsIoc() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("bean-injection.xml");
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("bean-injection.xml");

        StudentRepository studentRepository = (StudentRepository)beanFactory.getBean("studentRepository");

        studentRepository.getBeanFactory();

        classPathXmlApplicationContext.getBean(BeanFactory.class);




    }

}

