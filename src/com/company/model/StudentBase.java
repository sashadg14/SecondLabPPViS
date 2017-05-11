package com.company.model;

import com.company.fileWorking.Parser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex o n 20.04.2017.
 */
public class StudentBase {
    private List<Student> students;
    public StudentBase(){
        students = new ArrayList<Student>();
    }
    public void addStudent(Student student){
        students.add(student);
    }
    public List<Student> getStudents() {
        return students;
    }
    public int removeStudents(List<Student> studentList){
        students.removeAll(studentList);
        return studentList.size();
    }
    public void saveStudentBase()
    {
        new Parser().writeFile(students);
    }
    public void readStudentBase(){
        students=new Parser().readFromFile();
    }
}
