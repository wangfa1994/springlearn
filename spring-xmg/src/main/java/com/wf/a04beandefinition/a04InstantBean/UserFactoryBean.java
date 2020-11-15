package com.wf.a04beandefinition.a04InstantBean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @Desc : 通过factoryBean 来创建的实例化,注意此类也会被spring管理且命名为&开头
 * @Author : Mr.WangF
 * @Date: 2020/11/15 11:11
 */
public class UserFactoryBean implements FactoryBean {


    @Override
    public Object getObject() throws Exception {
        People people = new People();
        people.setName("implementsFactoryBean");
        people.setAge(18);
        return people;
    }

    @Override
    public Class<?> getObjectType() {
        return People.class;
    }
}
