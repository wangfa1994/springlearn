package com.wf.a02;

import com.wf.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: wangfa
 * @Date: 2020/10/22 21:58
 * @Description: 通过注解配置加载我们的bean
 *
 *
 * @Bean 默认选择我们的方法名作为bean的名称，我们可以通过name进行指定
 */

@Configuration
public class MainConfig {

    @Bean
    public Person person(){
        Person person = new Person();
        person.setId(1);
        person.setName("person");
        return person;
    }

    @Bean(value ={"personMethod1","personMethod2"} )
    public Person personMethod(){
        Person person = new Person();
        person.setId(2);
        person.setName("personMethod");
        return person;
    }

    @Bean(name = "@beanName")
    public Person personBean(){
        Person person = new Person();
        person.setId(3);
        person.setName("@beanName");
        return person;
    }
}
