package com.wf.a04beandefinition.a04InstantBean;

import lombok.Data;
import lombok.val;

/**
 * @Desc :
 * @Author : Mr.WangF
 * @Date: 2020/11/15 10:33
 */
@Data
public class People {

    private String name;
    private Integer age;



    public static People newPeople(){
        People people = new People();
        people.setName("staticsNew");
        people.setAge(18);
        return people;
    }
}
