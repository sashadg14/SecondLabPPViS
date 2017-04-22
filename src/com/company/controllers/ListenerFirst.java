package com.company.controllers;

import com.company.FindView;
import com.company.model.Table;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by alex o n 22.04.2017.
 */
public class ListenerFirst implements ActionListener {
    FindView findView;
    DataBaseManipulation dataBaseManipulation;
    public ListenerFirst(FindView findView, DataBaseManipulation dataBaseManipulation){
        this.findView=findView;
        this.dataBaseManipulation=dataBaseManipulation;
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int higthAligment=50;
        int heigth=20;
        int width=100;
            findView.removeBottons();
            final JLabel jLabel=new JLabel("Введите фамилию студента и группу");
            jLabel.setBounds(20,higthAligment-40,300,20);
            findView.getjDialog().add(jLabel);
            final TextField firstData = new TextField();
            firstData.setBounds(20,higthAligment,width,heigth);
            findView.getjDialog().add(firstData);
            final TextField secondData = new TextField();
            secondData.setBounds(140, higthAligment,width,heigth);
            findView.getjDialog().add(secondData);
            final JButton jButton = new JButton("Поиск");
            jButton.setBounds(70,higthAligment+40,50,20);
            findView.getjDialog().add(jButton);
            findView.getjDialog().update(findView.getjDialog().getGraphics());
            jButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    findView.getjDialog().setBounds(0,200,1600,500);
                    findView.getjDialog().remove(jLabel);
                    findView.getjDialog().remove(firstData);
                    findView.getjDialog().remove(secondData);
                    findView.getjDialog().remove(jButton);
                    Table table = new Table(findView.getjDialog());
                    table.renderTable(dataBaseManipulation.findStudentByNameAndGrop(firstData.getText(),secondData.getText()));
                    findView.getjDialog().update(findView.getjDialog().getGraphics());
                }
            });
    }
}
