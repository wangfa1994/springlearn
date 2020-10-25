package com.wf.model;

import com.wf.a03ioc.lookup.Super;
import lombok.Data;
import lombok.ToString;

/**
 * @Desc :
 * @Author : Mr.WangF
 * @Date: 2020/10/25 11:29
 */

@ToString(callSuper=true)
@Data
@Super
public class SuperStudent  extends  Student{

    private String level;
}
