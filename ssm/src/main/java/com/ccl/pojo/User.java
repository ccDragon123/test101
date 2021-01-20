package com.ccl.pojo;


import org.apache.ibatis.type.Alias;

//实体类
public class User {
    private String name;
    private String pwd;
    private int id;

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User(String name, String pwd, int id) {
        this.name = name;
        this.pwd = pwd;
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", id=" + id +
                '}';
    }
}
