package com.company.controllers;

import com.company.DeleteView;
import com.company.FindView;
import com.company.model.Table;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by alex o n 22.04.2017.
 */
public class DeleteByNameAndGroupListener implements ActionListener{
    DeleteView deleteView;
    DataBaseManipulation dataBaseManipulation;
    public DeleteByNameAndGroupListener(DeleteView deleteView, DataBaseManipulation dataBaseManipulation){
        this.deleteView=deleteView;
        this.dataBaseManipulation=dataBaseManipulation;
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int higthAligment=50;
        int heigth=20;
        int width=100;
        deleteView.removeBottons();
        final JLabel jLabel=new JLabel("Введите фамилию студента и группу");
        jLabel.setBounds(20,higthAligment-40,300,20);
        deleteView.getjDialog().add(jLabel);
        final TextField firstData = new TextField();
        firstData.setBounds(20,higthAligment,width,heigth);
        deleteView.getjDialog().add(firstData);
        final TextField secondData = new TextField();
        secondData.setBounds(140, higthAligment,width,heigth);
        deleteView.getjDialog().add(secondData);
        final JButton jButton = new JButton("Удаление");
        jButton.setBounds(70,higthAligment+40,50,20);
        deleteView.getjDialog().add(jButton);
        deleteView.getjDialog().update(deleteView.getjDialog().getGraphics());
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dataBaseManipulation.deleteStidentByNameAndGrop(firstData.getText(),secondData.getText());
                deleteView.getjDialog().setVisible(false);

            }
        });
    }
}
