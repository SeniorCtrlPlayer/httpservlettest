package com.lwk.model;

import java.io.Serializable;
import java.util.Date;

public class Userinfo implements Serializable {

    /**
     * create table users(
     id int auto_increment primary key,
     name varchar(30),
     nickName varchar(30),
     pwd varchar(24),
     gender varchar(2),
     birthday datetime,
     hobby varchar(50),
     tel varchar(20),
     email varchar(30),
     grade int default 1,
     description varchar(200)
     );
     *
     */

    private Integer id;
    private String name;
    private String nickName;
    private String pwd;
    private String gender;
    private Date birthday;
    private String hobby;
    private String tel;
    private String email;
    private int grade;
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
