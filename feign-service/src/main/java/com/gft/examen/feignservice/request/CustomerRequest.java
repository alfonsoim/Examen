package com.gft.examen.feignservice.request;

import io.swagger.annotations.ApiModel;

import java.util.Date;

@ApiModel("CustomerRequest")
public class CustomerRequest {

    private String name;
    private String lastName;
    private Date birthday;
    private String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
