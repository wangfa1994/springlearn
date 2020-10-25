package com.wf.a03ioc.lookup;

import com.wf.model.Student;
import com.wf.model.SuperStudent;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @Desc : 依赖查找
 * @Author : Mr.WangF
 * @Date: 2020/10/25 10:23
 */
public class A01DependenceLookUp {


    public static void main(String[] args) {

        BeanFactory beanFactory = new ClassPathXmlApplicationContext("bean-lookup.xml");


//        getBeanByName(beanFactory);
        getBeanByType(beanFactory);
        getBeanByAnnotation(beanFactory);

    }



    /**
     * 通过名称去查找对应的bean
     */
    private static void getBeanByName(BeanFactory beanFactory) {
        // 实时查找
        Student wangfa = (Student) beanFactory.getBean("wangfa");
        System.out.println("根据名称实时查找" + wangfa);

        /*
         *ObjectFactory 和org.springframework.beans.factory.config.ObjectFactoryCreatingFactoryBean 实现延迟查找
         *
         * 延迟查找的缘由是啥， ObjectFactory BeanFactory FactoryBean 的区别是啥
         */
        ObjectFactory<Student> objectFactoryCreatingFactoryBean = (ObjectFactory<Student>) beanFactory.getBean("objectFactoryCreatingFactoryBean");
        Student student = objectFactoryCreatingFactoryBean.getObject();
        System.out.println("根据名称通过ObjectFactory延迟查找:" + student);
    }

    /**
      * @Desc: 通过类型去查找对应的bean
      * @Author: Mr.WangF
      * @Date: 2020/10/25 11:27
      */
    private static void getBeanByType(BeanFactory beanFactory) {

        // 支持了泛型查找，是3.0之后新增的 3.0支持java5
        Student user = beanFactory.getBean(Student.class);
        System.out.println("根据类型实时单一查找：" + user);

        // 根据类型，查找对应的符合类型的列表 查出多个,注意在查找多个时候，在获取单个的时候，会进行报错，可以利用Primary Key
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;

            Map<String, Student> beansOfType = listableBeanFactory.getBeansOfType(Student.class);
            System.out.println("根据类型实时查找对应的列表：" + beansOfType);
        }

    }

    /**
      * @Desc: 通过注解查找对应的bean
      * @Author: Mr.WangF
      * @Date: 2020/10/25 11:27
      */
    private static void getBeanByAnnotation(BeanFactory beanFactory) {


        // 为什么需要进行实例instanceOf 判断
        if(beanFactory instanceof  ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, SuperStudent> beansWithAnnotation = (Map)listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("根据注解实时查找对应的列表：" + beansWithAnnotation);

        }




    }


}

