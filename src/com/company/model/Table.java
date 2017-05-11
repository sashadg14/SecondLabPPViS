package com.company.model;

import com.company.ToolbarForTableControl;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by alex o n 11.04.2017.
 */
public class Table {
    private int widh=130;
    private int heigth=20;
    private int heigthAligment=50;
    //JFrame jFrame;
    private Window window;
    private JLabel fio;
    private JLabel group;
    private JLabel publicWorsk;
    private JLabel[] jLable;
    private ArrayList<Component> componentArrayList;
    private ToolbarForTableControl toolbarForTableControl;
    public Table(Window window){
        componentArrayList=new ArrayList<Component>();
        this.window=window;
        jLable= new JLabel[10];
    }
    public Table(int heigthAligment, Window window){
        componentArrayList=new ArrayList<Component>();
        this.window=window;
        jLable= new JLabel[10];
        this.heigthAligment=heigthAligment;
    }
    public void setToolbarForTableControl(ToolbarForTableControl toolbarForTableControl) {
        this.toolbarForTableControl = toolbarForTableControl;
    }

    public void renderTable(List<Student> studentArrayList) {
        for(Component component:componentArrayList){
            window.remove(component);
        }

        componentArrayList.clear();
        fio= new JLabel("ФИО");
        fio.setBounds(0,heigthAligment,widh,heigth*2);
        fio.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        fio.setHorizontalAlignment(JLabel.CENTER);
        fio.setVerticalAlignment(JLabel.CENTER);
        window.add(fio);
        componentArrayList.add(fio);
        group= new JLabel("Группа");
        group.setBounds(widh,heigthAligment,widh,heigth*2);
        group.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        group.setHorizontalAlignment(JLabel.CENTER);
        group.setVerticalAlignment(JLabel.CENTER);
        window.add(group);
        componentArrayList.add(group);
        publicWorsk= new JLabel("Общественные работы");
        publicWorsk.setBounds(widh*2,heigthAligment,widh*10,heigth);
        publicWorsk.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        publicWorsk.setHorizontalAlignment(JLabel.CENTER);
        publicWorsk.setVerticalAlignment(JLabel.CENTER);
        window.add(publicWorsk);
        componentArrayList.add(publicWorsk);
        for(int i=0;i<10;i++){
            jLable[i] = new JLabel(Integer.toString(1+i)+" семестр");
            window.remove(jLable[i]);
            jLable[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            jLable[i].setHorizontalAlignment(JLabel.CENTER);
            jLable[i].setVerticalAlignment(JLabel.CENTER);
            jLable[i].setBounds(widh*(2+i),heigthAligment+heigth,widh,heigth);
            window.add(jLable[i]);
        }
        for(Student student: studentArrayList){
            createRow(student,studentArrayList);
        }
        toolbarForTableControl.createJLable();
        window.update(window.getGraphics());
        // System.out.println(studentArrayList.get(0).getGroup()+" ------");

    }

   void createRow(Student student, List<Student> studentArrayList){
       JLabel name = new JLabel(" "+student.getFirstName()+" "+student.getMiddleName()+" "+student.getLastName());
       name.setBounds(0,heigthAligment+heigth*2+(heigth*studentArrayList.indexOf(student)),widh,heigth);
       //System.out.println(name.getY()+"----");
       name.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
       //name.setHorizontalAlignment(JLabel.CENTER);
       name.setVerticalAlignment(JLabel.CENTER);
       window.add(name);
       componentArrayList.add(name);
       JLabel group = new JLabel(student.getGroup());
       group.setBounds(widh,heigthAligment+heigth*2+(heigth*studentArrayList.indexOf(student)),widh,heigth);
       group.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
       group.setHorizontalAlignment(JLabel.CENTER);
       group.setVerticalAlignment(JLabel.CENTER);
       window.add(group);
       componentArrayList.add(group);
       JLabel[] jLable = new JLabel[10];
       for(int i=0;i<10;i++){
           jLable[i] = new JLabel(student.getPublicWork().get(i));
           jLable[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
           jLable[i].setHorizontalAlignment(JLabel.CENTER);
           jLable[i].setVerticalAlignment(JLabel.CENTER);
           jLable[i].setBounds(widh*(2+i),heigthAligment+heigth*2+(heigth*studentArrayList.indexOf(student)),widh,heigth);
           window.add(jLable[i]);
           componentArrayList.add(jLable[i]);
       }
   }
}
