package com.farm.javaBesee.reflection;

import lombok.Data;

/**
 * 有参构造
 * @author z2yEs
 * @create 22:45
 */
@Data
public class Employee2 {

    private String name;

    private String age;

    public Employee2(String name) {
        this.name = name;
    }
}
