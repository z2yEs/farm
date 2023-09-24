package com.farm.javaBese.reflection;

/**
 * @author z2yEs
 * @create 8:53
 */

@Deprecated
public class Person extends PersonF implements PersonInterface{

    public String name;

    protected int age;

    private double sal;

    public Person(){

    }

    public Person(String name) {
        this.name = name;
    }

    private Person(String name, int age){
        this.name = name;
        this.age = age;
    }



    public void m1(String name,int age){
        System.out.println("public m1 调用");
    }

    protected void m2(){
        System.out.println("protected m2 调用");
    }

    void m3(){
        System.out.println("void m3");
    }

    private void m4(){
        System.out.println("private m4 调用");
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSal() {
        return sal;
    }
}
