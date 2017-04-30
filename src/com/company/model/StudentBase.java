package com.company.model;

import com.company.fileWorking.Parser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex o n 20.04.2017.
 */
public class StudentBase {
    private List<Student> students;
    private List<Student> pageOfStudents;
    private int countOfLists;
    public StudentBase(){
        students = new ArrayList<Student>();
    }
    public void addStudent(Student student){
        students.add(student);
    }
    public List<Student> getStudents() {
        return students;
    }
    public void removeStudents(List<Student> studentList){
        students.removeAll(studentList);
    }
    public void saveStudentBase()
    {
        new Parser().writeFile(students);
    }
    public void readStudentBase(){
        students=new Parser().readFromFile();
    }
}
