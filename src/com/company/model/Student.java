package com.company.model;

import java.util.ArrayList;

/**
 * Created by alex o n 11.04.2017.
 */
public class Student {
    String firstName;
    String lastName;
    String surName;
    String group;
    ArrayList<String> publicWork;

    public Student(){
        publicWork=new ArrayList<String>();
        for(int i=0;i<10;i++)
            publicWork.add("");
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getGroup() {
        return group;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setPublicWork(ArrayList<String> publicWork) {
        this.publicWork = publicWork;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSurName() {
        return surName;
    }

    public ArrayList<String> getPublicWork() {
        return publicWork;
    }

}
