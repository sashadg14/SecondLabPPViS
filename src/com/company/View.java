package com.company;

import com.company.controllers.DataBaseManipulation;
import com.company.model.Student;
import com.company.model.StudentBase;
import com.company.model.Table;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by alex o n 11.04.2017.
 */
public class View {

    JFrame jFrame;
    JButton findButton;
    JButton addButton;
    JButton deleteButton;
    JButton leftButton;
    JButton rightButton;
   JButton leftButtonToEnd;
    JButton rightButtonToEnd;
    Table table;
    StudentBase studentBase;
    DataBaseManipulation dataBaseManipulation;
   public View(){
       jFrame= new JFrame();

       studentBase= new StudentBase();
        dataBaseManipulation= new DataBaseManipulation(studentBase,this);
        JLabel JLABLE = new JLabel();
        table= new Table(jFrame);
       JLABLE.setBounds(0,0,1600,900);
        jFrame.add(JLABLE);
       jFrame.setSize(1000,800);
       jFrame.setVisible(true);
       findButton = new JButton();
       addButton = new JButton();
        deleteButton = new JButton();
       findButton.setIcon(new ImageIcon("src\\com\\company\\resourses\\findIcon.png"));
       addButton.setIcon(new ImageIcon("src\\com\\company\\resourses\\addIcon.png"));
       deleteButton.setIcon(new ImageIcon("src\\com\\company\\resourses\\delete.png"));

       leftButton = new JButton();
       rightButton = new JButton();
       leftButtonToEnd = new JButton();
       rightButtonToEnd = new JButton();
       leftButton.setIcon(new ImageIcon("src\\com\\company\\resourses\\left.png"));
       rightButton.setIcon(new ImageIcon("src\\com\\company\\resourses\\right.png"));
       leftButtonToEnd.setIcon(new ImageIcon("src\\com\\company\\resourses\\left_1.png"));
       rightButtonToEnd.setIcon(new ImageIcon("src\\com\\company\\resourses\\right_1.png"));

       creatingTolbar();
       jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

    public Table getTable() {
        return table;
    }

    public JFrame getjFrame() {
        return jFrame;
    }

    private void creatingTolbar() {
        JToolBar toolbar = new JToolBar("Toolbar", JToolBar.HORIZONTAL);

        findButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                new FindView(dataBaseManipulation);
            }
        });
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                new AddView(dataBaseManipulation);
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) { new DeleteView(dataBaseManipulation);
            table.renderTable(studentBase.getStudents());
            }
        });
        toolbar.add(addButton);
        toolbar.add(findButton);
        toolbar.add(deleteButton);
        jFrame.getContentPane().setLayout(null);
        toolbar.setBounds(0,0,1600,50);
        jFrame.add(toolbar);
        createTable();
        jFrame.update(jFrame.getGraphics());
        JToolBar jToolBarSecond = new JToolBar("Toolbar", JToolBar.HORIZONTAL);
        leftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        rightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        rightButtonToEnd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        leftButtonToEnd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });

        jToolBarSecond.add(leftButtonToEnd);
        jToolBarSecond.add(leftButton);
        jToolBarSecond.add(rightButton);
        jToolBarSecond.add(rightButtonToEnd);
        jFrame.getContentPane().setLayout(null);
        toolbar.setBounds(0,0,1600,50);
        jToolBarSecond.setBounds(800,800,1600,30);
        jFrame.add(toolbar);
        jFrame.add(jToolBarSecond);
        createTable();
        jFrame.update(jFrame.getGraphics());
        //jFrame.getContentPane().setLayout(null);
    }



   public void createTable(){
       table.renderTable(studentBase.getStudents());
     //   table.renderTable(studentBase.getStudents());
      /*  JLabel ekz2 = new JLabel("2");
        ekz2.setBounds(380,30,160,20);
        jFrame.add(ekz2);
        JLabel ekz3 = new JLabel("3");
        ekz3.setBounds(540,30,160,20);
        jFrame.add(ekz3);
        JLabel nameekz1 = new JLabel("наименование");
        nameekz1.setBounds(220,50,100,20);
        jFrame.add(nameekz1);
        JLabel markekz1 = new JLabel("отметка");
        markekz1.setBounds(320,50,60,20);
        jFrame.add(markekz1);
        JLabel nameekz2 = new JLabel("наименование");
        nameekz2.setBounds(380,50,100,20);
        jFrame.add(nameekz2);
        JLabel markekz2 = new JLabel("отметка");
        markekz2.setBounds(480,50,60,20);
        jFrame.add(markekz2);
        JLabel nameekz3 = new JLabel("наименование");
        nameekz3.setBounds(540,50,100,20);
        jFrame.add(nameekz3);
        JLabel markekz3 = new JLabel("отметка");
        markekz3.setBounds(640,50,60,20);
        jFrame.add(markekz3);*/
    }
}
