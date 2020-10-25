package com.wf.repository;

import com.wf.model.Student;
import com.wf.model.SuperStudent;
import lombok.Data;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;

import java.util.List;

/**
 * @Desc : 学生操作动作
 * @Author : Mr.WangF
 * @Date: 2020/10/25 15:37
 */
@Data
public class StudentRepository {



    private List<Student> studentList;



    // 注入spring容器的内置bean，非bean
    private BeanFactory beanFactory;


    // 延迟加载
    private ObjectFactory<BeanFactory> objectFactory;



}
