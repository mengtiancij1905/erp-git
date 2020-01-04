package com.itqf.erp.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
//emp{uuid:10,username:zhangsan,pwd:123}->{uuid:10,username:zhangsan,pwd:123}

//JavaBean规范
    //1.带有无参的构造方法
    //2.私有字段提供,get/set方法,get/set方法又被称为属性

//emp{uuid:10,username:zhangsan,pwd:123}->{uuid:10,username:zhangsan}
public class Emp {
    private Integer uuid;

    private String username;

    //Emp对象进行json转换时忽略当前属性
    @JsonIgnore(value = true)
    private String pwd;

    private String name;

    private Integer gender;

    private String email;

    private String tele;

    private String address;

    //"03/4/2019"->Date

    //2019-03-4->Date
    //String->Date
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date birthday;

    private Integer depuuid;

    private Dep dep;

    public Dep getDep() {
        return dep;
    }

    public void setDep(Dep dep) {
        this.dep = dep;
    }

    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele == null ? null : tele.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getDepuuid() {
        return depuuid;
    }

    public void setDepuuid(Integer depuuid) {
        this.depuuid = depuuid;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "uuid=" + uuid +
                ", username='" + username + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", tele='" + tele + '\'' +
                ", address='" + address + '\'' +
                ", birthday=" + birthday +
                ", depuuid=" + depuuid +
                ", dep=" + dep +
                '}';
    }
}