package com.company.controllers;

import com.company.model.Student;
import com.company.model.Table;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex o n 23.04.2017.
 */
public class PageManipulator {
    private List<Student> studentList;
    private int countOfStudentOnLists=5;
    private int noOfPage =0;
    private Table table;
    public PageManipulator(List<Student> studentList, Table table){
        this.studentList=studentList;
        this.table=table;
    }
    public void setCountOfStudentOnLists(int countOfStudentOnLists) {
        this.countOfStudentOnLists = countOfStudentOnLists;
        noOfPage=0;
    }
    public int getCountOfStudentOnLists(){
        return countOfStudentOnLists;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Student> returnPageOfStudents(){
        List<Student> pageOfStudents= new ArrayList<Student>();
            for(int i = noOfPage *countOfStudentOnLists; i<(noOfPage +1)*countOfStudentOnLists&&i<studentList.size(); i++)
                pageOfStudents.add(studentList.get(i));
        return pageOfStudents;
    }
    public void NextPage() {
        if (countOfStudentOnLists*(noOfPage +1)<studentList.size())
        {   noOfPage++;
            table.renderTable(returnPageOfStudents());
        }
    }
    public void PreviousPage(){
        if(noOfPage !=0){
            noOfPage--;
            table.renderTable(returnPageOfStudents());
        }
    }
    public void FirstPage(){
        noOfPage =0;
        table.renderTable(returnPageOfStudents());
    }
    public void LastPage(){
        int countOfPages=(int)studentList.size()/countOfStudentOnLists;
        if (countOfStudentOnLists*(countOfPages)<studentList.size())
        {   noOfPage =countOfPages;
       // System.out.println(countOfStudentOnLists*(countOfPages));
            table.renderTable(returnPageOfStudents());
        }
        else {noOfPage=countOfPages-1;
            table.renderTable(returnPageOfStudents());}
    }
    public int getNoOfPage() {
        int countOfPages=(int)studentList.size()/countOfStudentOnLists;
        if (countOfStudentOnLists*(countOfPages)==0)
            return 0;
        if (countOfStudentOnLists*(countOfPages)==studentList.size())
            return noOfPage+1;
        else return noOfPage+1;
    }
    public int getCountOfPages(){
        int countOfPages=(int)studentList.size()/countOfStudentOnLists;
        if (countOfStudentOnLists*(countOfPages)<studentList.size())
        return countOfPages+1;
        else
            if(countOfPages!=0)
                return countOfPages;
            else return 0;
    }
}
