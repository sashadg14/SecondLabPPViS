package com.company.controllers;

import com.company.AddView;
import com.company.View;
import com.company.model.Student;
import com.company.model.StudentBase;

import java.util.ArrayList;

/**
 * Created by alex o n 20.04.2017.
 */
public class DataBaseManipulation {
    StudentBase studentBase;
    View view;

    public DataBaseManipulation(StudentBase studentBase, View view){
        this.studentBase=studentBase;
        this.view= view;
    }
    public void AddNewStudentInBase(AddView addView){
        Student newStudent= new Student();
        newStudent.setFirstName(addView.getFistNameField().getText());
        newStudent.setMiddleName(addView.getSurNameField().getText());
        newStudent.setLastName(addView.getLastNameField().getText());
        newStudent.setGroup(addView.getGroupField().getText());
        ArrayList<String> publicWorks= new ArrayList<String>();
        for(int i=0; i<10;i++){
            publicWorks.add(addView.getPublicWorkFieldArray().get(i).getText());
        }
        newStudent.setPublicWork(publicWorks);
        studentBase.addStudent(newStudent);
        view.renderTable();
        System.out.println(studentBase.getStudents().get(0).getGroup()+" ------");
    }

    public ArrayList<Student> findStudentByNameAndGrop(String name, String group){
        ArrayList<Student> findStudentArrayList = new ArrayList<Student>();
        for(Student student: studentBase.getStudents()){
            if(student.getGroup().equalsIgnoreCase(group)&&student.getFirstName().equalsIgnoreCase(name))
            {
                findStudentArrayList.add(student);
            }
            else if(group.equalsIgnoreCase("")&&student.getFirstName().equalsIgnoreCase(name)){
                findStudentArrayList.add(student);
            }
            else if(student.getGroup().equalsIgnoreCase(group)&&name.equalsIgnoreCase("")){
                findStudentArrayList.add(student);
            }
        }
        return  findStudentArrayList;
    }

    public ArrayList<Student> findStudentByNameAndWork(String name, String studWork){
        ArrayList<Student> findStudentArrayList = new ArrayList<Student>();
        for(Student student: studentBase.getStudents()){
            if(student.getFirstName().equalsIgnoreCase(name)||name.equalsIgnoreCase(""))
            {
                for(String work:student.getPublicWork()){
                    if(work.equalsIgnoreCase(studWork)){
                    findStudentArrayList.add(student);
                    break;
                    }
                }
            } else if (studWork.equalsIgnoreCase("")&&student.getFirstName().equalsIgnoreCase(name)){
                findStudentArrayList.add(student);
            }
        }
        return  findStudentArrayList;
    }

    public ArrayList<Student> findStudentByNameAndNumberOfWork(String name, String lowerLimit, String upperLimit){
        ArrayList<Student> findStudentArrayList = new ArrayList<Student>();
        for(Student student: studentBase.getStudents()){
            if(student.getFirstName().equalsIgnoreCase(name)||name.equalsIgnoreCase(""))
            {   ArrayList<String> workMassiv=new ArrayList<>();
                for(String string:student.getPublicWork())
                {   boolean bool=false;
                    for(String string2:workMassiv){
                        if(string.equalsIgnoreCase(string2))
                            bool=true;
                    }
                    if(!bool)
                    workMassiv.add(new String(string));
                }
                ///System.out.println(workMassiv.size());
                if(workMassiv.size()-1>=Integer.parseInt(lowerLimit)&&workMassiv.size()-1<=Integer.parseInt(upperLimit))
                    findStudentArrayList.add(student);
            }else if (lowerLimit.equalsIgnoreCase("")&&upperLimit.equalsIgnoreCase("")&&student.getFirstName().equalsIgnoreCase(name)){
                findStudentArrayList.add(student);
            }
        }
        return  findStudentArrayList;
    }
    public int deleteStudentByNameAndGrop(String name, String group){
        int coll=studentBase.removeStudents(findStudentByNameAndGrop(name,group));
        view.renderTable();
        return coll;
    }
    public int deleteStudentByNameAndWork(String name, String group){
        int coll=studentBase.removeStudents(findStudentByNameAndWork(name,group));
        view.renderTable();
        return coll;
    }
    public int deleteStudentByNameAndNumberOfWork(String name, String lowerLimit,String upperLimit){
        int coll=studentBase.removeStudents(findStudentByNameAndNumberOfWork(name,lowerLimit,upperLimit));
        view.renderTable();
        return coll;
    }

}
