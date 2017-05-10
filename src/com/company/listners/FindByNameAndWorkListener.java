package com.company.listners;
/**
 * Created by alex o n 22.04.2017.
 */

import com.company.FindView;
import com.company.controllers.DataBaseManipulation;
import com.company.controllers.PageManipulator;
import com.company.model.Table;
import com.company.ToolbarForTableControl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by alex o n 22.04.2017.
 */
public class FindByNameAndWorkListener implements ActionListener {
    FindView findView;
    DataBaseManipulation dataBaseManipulation;
    public FindByNameAndWorkListener(FindView findView, DataBaseManipulation dataBaseManipulation){
        this.findView=findView;
        this.dataBaseManipulation=dataBaseManipulation;
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int higthAligment=50;
        int heigth=20;
        int width=100;
        findView.removeBottons();
        final JLabel jLabel=new JLabel("Введите фамилию студента и вид работы");
        jLabel.setBounds(heigth,higthAligment-40,300,20);
        findView.getjDialog().add(jLabel);
        final TextField firstData = new TextField();
        firstData.setBounds(heigth,higthAligment,width,heigth);
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
                PageManipulator pageManipulator=new PageManipulator(dataBaseManipulation.findStudentByNameAndWork(firstData.getText(),secondData.getText()),table);
                ToolbarForTableControl toolbarForTableControl= new ToolbarForTableControl(700,500,pageManipulator,findView.getjDialog(),table);
                table.setToolbarForTableControl(toolbarForTableControl);
                table.renderTable(pageManipulator.returnPageOfStudents());
                findView.getjDialog().update(findView.getjDialog().getGraphics());
            }
        });
    }
}

