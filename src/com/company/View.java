package com.company;

import com.company.controllers.DataBaseManipulation;
import com.company.model.StudentBase;
import com.company.model.Table;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        renderTable();
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
        renderTable();
        jFrame.update(jFrame.getGraphics());
        //jFrame.getContentPane().setLayout(null);
    }


   public void renderTable(){
       table.renderTable(studentBase.getStudents());
    }
}
