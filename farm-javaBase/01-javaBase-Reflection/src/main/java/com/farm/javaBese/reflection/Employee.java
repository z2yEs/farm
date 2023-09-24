package com.farm.javaBese.reflection;

import lombok.Data;

/**
 * @author z2yEs
 * @create 22:45
 */
@Data
public class Employee {

    private String name;

    public String publicName;

    private String age;

    public void working(){
        System.out.println(name + "working");
    }

}
