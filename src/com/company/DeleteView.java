package com.company;

import com.company.controllers.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by alex o n 11.04.2017.
 */
public class DeleteView {
    private DataBaseManipulation dataBaseManipulation;
    private FindView findView;

    public DeleteView(DataBaseManipulation dataBaseManipulation){
        findView=new FindView(dataBaseManipulation);
        this.dataBaseManipulation=dataBaseManipulation;
    }

    public void createDeleteWindow(){
           findView.createElementsOfWindow("Удаление");
           findView.getjDialog().setBounds(0, 0, 1600, 900);

           findView.getFindByNameAndGroupButton().addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent actionEvent) {
                   findView.removeElements();
                   findView.addFindByNameAndGroupElemens("Удаление",new ActionListener() {
                       @Override
                       public void actionPerformed(ActionEvent actionEvent) {
                           int count = dataBaseManipulation.deleteStudentByNameAndGrop(findView.getFirstData().getText(), findView.getSecondData().getText());
                           findView.getjDialog().setVisible(false);
                           if (count != 0) {
                               JOptionPane.showMessageDialog(new JFrame(), "Записей найдено и удалено " + count);
                           } else JOptionPane.showMessageDialog(new JFrame(), "Записей не найдено");
                       }
                   });
               }
           });

       findView.getFindByNameAndWorkButton().addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent actionEvent) {
                   findView.removeElements();
                   findView.addFindByNameAndWorkElemens("Удаление", new ActionListener() {
                       @Override
                       public void actionPerformed(ActionEvent actionEvent) {
                           findView.removeElements();
                           findView.addFindByNameAndWorkElemens("Удаление",new ActionListener() {
                               @Override
                               public void actionPerformed(ActionEvent actionEvent) {
                                   int count = dataBaseManipulation.deleteStudentByNameAndWork(findView.getFirstData().getText(), findView.getSecondData().getText());
                                   findView.getjDialog().setVisible(false);
                                   if (count != 0) {
                                       JOptionPane.showMessageDialog(new JFrame(), "Записей найдено и удалено " + count);
                                   } else JOptionPane.showMessageDialog(new JFrame(), "Записей не найдено");
                               }
                           });
                       }
                   });
               }
           });

       findView.getFindByNameNumberOfWorkButton().addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent actionEvent) {
                   findView.removeElements();
                   findView.addFindByNameAndNumberOfWorkElemens("Удаление", new ActionListener() {
                       @Override
                       public void actionPerformed(ActionEvent actionEvent) {
                           int count=dataBaseManipulation.deleteStudentByNameAndNumberOfWork(findView.getFirstData().getText(),findView.getSecondData().getText(),findView.getThirdData().getText());
                           findView.getjDialog().setVisible(false);
                           if (count!=0){
                               JOptionPane.showMessageDialog(new JFrame(), "Записей найдено и удалено "+count);
                           }
                           else JOptionPane.showMessageDialog(new JFrame(), "Записей не найдено");
                       }
                   });
               }
           });


    }

}
