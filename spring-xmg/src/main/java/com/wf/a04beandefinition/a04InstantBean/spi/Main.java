package com.wf.a04beandefinition.a04InstantBean.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @Desc :
 * @Author : Mr.WangF
 * @Date: 2020/11/15 11:47
 */
public class Main {

    public static void main(String[] args) {

        //ServiceLoader 获取
        ServiceLoader<Services> services = ServiceLoader.load(Services.class);
        Iterator<Services> iterator = services.iterator();

        while (iterator.hasNext()){
            Services next = iterator.next();
            next.fn();
            System.out.println(next);
        }
    }
}
