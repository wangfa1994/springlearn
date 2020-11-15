package com.wf.a04beandefinition.a06DestroyBean;

import lombok.Data;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PreDestroy;

/**
 * @Desc :
 * @Author : Mr.WangF
 * @Date: 2020/11/15 15:38
 */
@Data
public class TeacherBean implements  DisposableBean {

    private String name;
    private Integer age;

    /**
     * 注意这个注解是来自于java
     */
    @PreDestroy
    public void init(){
            System.out.println("@PreDestroy注解方法 销毁bean");
    }


    public void destroyMethod(){
        System.out.println("自定义初始化方法 销毁bean");
    }

    /**
     * 实现DisposableBean接口初始化
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("通过实现DisposableBean接口 销毁bean");
    }


    /**
     * 三种方式的执行顺序为 java注解的PreDestroy 、实现接口的DisposableBean、自定义初始化方法的destroyMethod
     *
     *
     * 他们是如何实现的 怎么找到 destroyMethod 和 @PreDestroy的
     * 追踪springContext.close()方法
     *  org.springframework.context.support.AbstractApplicationContext#doClose()---->destroyBeans();
     *
     *  在org.springframework.beans.factory.support.DefaultSingletonBeanRegistry中存在属性disposableBeans 通过这个map进行强转销毁
     *  org.springframework.beans.factory.support.DefaultSingletonBeanRegistry#destroySingletons()
     *  所以这个属性的值是如何放进去的才是关键
     *  初始化的也是类似
     *
     */
}
