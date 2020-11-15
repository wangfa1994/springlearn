package com.wf.a04beandefinition.a05InitializationBean;

import lombok.Data;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

/**
 * @Desc :
 * @Author : Mr.WangF
 * @Date: 2020/11/15 15:38
 */
@Data
public class TeacherBean implements InitializingBean {

    private String name;
    private Integer age;


    /**
     * 注意这个注解是来自于java
     */
    @PostConstruct
    public void init(){
        System.out.println("@Postconstruct注解方法 初始化");
    }

    /**
     * 自定义方法初始化
     * Java API：AbstractBeanDefinition#setInitMethodName(String)
     * 注意在使用AbstractBeanDefinition#setInitMethodName(String) 时，
     * 这个方法本来是在AbstractBeanDefinition的抽象类中存在一个属性initMethodName赋值
     * 在5.1版本的时候，进行了向父类中升级，在BeanDefinition中进行了定义。
     */
    public void initMethod(){
        System.out.println("自定义初始化方法 初始化");
    }

    /**
     * 实现InitializingBean接口初始化
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean 方法初始化");
    }



    /**
     * 三种方式的执行顺序为 java注解的PostConstruct 、实现接口的InitializingBean、自定义初始化方法的init
     *
     */
}
