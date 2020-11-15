package com.wf.a04beandefinition;

import com.wf.model.Student;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * @Desc : 创建beanDefinition
 * @Author : Mr.WangF
 * @Date: 2020/11/8 15:19
 */
public class A01CreateBeanDefinition {



    public static void main(String[] args) {

        // 一、通过BeanDefinitionBuilder 创建对象
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(Student.class);

        // 属性设置 注意builder模式是可以返回本身的
        beanDefinitionBuilder.addPropertyValue("id",2);
        beanDefinitionBuilder.addPropertyValue("name","huahua");

        beanDefinitionBuilder
                .addPropertyValue("id",2)
                .addPropertyValue("name","huahua");

        // 获取beanDefinition 实例 beanDefinition 并非是bean的终态，可以自定义修改
        AbstractBeanDefinition beanDefinition =
                beanDefinitionBuilder.getBeanDefinition();





        // 二、通过AbstractBeanDefinition以及实现类进行创建BeanDefinition
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
        mutablePropertyValues
                .add("id",3)
                .add("name","qiuqiu");
        genericBeanDefinition.setPropertyValues(mutablePropertyValues);





    }
}
