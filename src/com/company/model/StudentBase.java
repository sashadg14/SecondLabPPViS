package com.company.model;

import com.company.fileWorking.Parser;

import java.util.ArrayList;

/**
 * Created by alex o n 20.04.2017.
 */
public class StudentBase {
    private ArrayList<Student> students;
    private ArrayList<Student> pageOfStudents;
    private int countOfLists;
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
        students.removeAll(studentArrayList);
    }
    public void saveStudentBase()
    {
        new Parser().writeFile(students);
    }
    public void readStudentBase(){
        students=new Parser().readFromFile();
    }
}
