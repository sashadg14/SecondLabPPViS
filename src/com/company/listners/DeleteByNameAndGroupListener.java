package com.company.listners;

import com.company.DeleteView;
import com.company.controllers.DataBaseManipulation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by alex o n 22.04.2017.
 */
public class DeleteByNameAndGroupListener implements ActionListener {
    DeleteView deleteView;
    DataBaseManipulation dataBaseManipulation;

    public DeleteByNameAndGroupListener(DeleteView deleteView, DataBaseManipulation dataBaseManipulation) {
        this.deleteView = deleteView;
        this.dataBaseManipulation = dataBaseManipulation;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int higthAligment = 50;
        int heigth = 20;
        int width = 100;
        deleteView.removeBottons();
        final JLabel jLabel = new JLabel("Введите фамилию студента и группу");
        jLabel.setBounds(20, higthAligment - 40, 300, 20);
        deleteView.getjDialog().add(jLabel);
        final TextField name = new TextField();
        name.setBounds(20, higthAligment, width, heigth);
        deleteView.getjDialog().add(name);
        final TextField group = new TextField();
        group.setBounds(140, higthAligment, width, heigth);
        deleteView.getjDialog().add(group);
        final JButton jButton = new JButton("Удаление");
        jButton.setBounds(70, higthAligment + 40, 80, 20);
        deleteView.getjDialog().add(jButton);
        deleteView.getjDialog().update(deleteView.getjDialog().getGraphics());
        jButton.addActionListener(new ActionListener() {
                                      @Override
                                      public void actionPerformed(ActionEvent actionEvent) {
                                          int count = dataBaseManipulation.findStudentByNameAndGrop(name.getText(), group.getText()).size();
                                          deleteView.getjDialog().setVisible(false);
                                          if (count != 0) {
                                              JOptionPane.showMessageDialog(new JFrame(), "Записей найдено и удалено " + count);
                                              dataBaseManipulation.deleteStudentByNameAndGrop(name.getText(), group.getText());
                                          } else JOptionPane.showMessageDialog(new JFrame(), "Записей не найдено");
                                      }

                                  }
        );
    }
}
