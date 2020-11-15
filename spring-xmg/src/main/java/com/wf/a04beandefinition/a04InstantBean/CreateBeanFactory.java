package com.wf.a04beandefinition.a04InstantBean;

/**
 * @Desc : 创建bean的工厂 (可以创建一系列的实例bean )
 * @Author : Mr.WangF
 * @Date: 2020/11/15 10:55
 */
public class CreateBeanFactory {

    public People createPeople(){
        People people = new People();
        people.setName("createBeanFactory");
        people.setAge(18);
        return people;
    }
}
