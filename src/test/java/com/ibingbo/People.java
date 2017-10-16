package com.ibingbo;

/**
 * @author zhangbingbing
 * @title People
 * @date 17/10/16
 */
public class People {
    private String name;

    public void show(String name) {
        System.out.println("hello," + name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
