package com.company.model;

import java.util.ArrayList;

/**
 * Created by alex o n 20.04.2017.
 */
public class StudentBase {
    ArrayList<Student> students;

    public StudentBase(){
        students = new ArrayList<Student>();
    }
    public void addStudent(Student student){
        students.add(student);
    }
    public ArrayList<Student> getStudents() {
        return students;
    }
    public void removeStudents(ArrayList<Student> studentArrayList){
        for(Student student:studentArrayList){
            students.remove(student);
        }
    }
}
