package com.company;

import com.company.controllers.DataBaseManipulation;
import com.company.listners.FindByNameAndGroupListener;
import com.company.listners.FindByNameAndWorkListener;
import com.company.listners.FindByNameAndNumberOfWorkListener;

import javax.swing.*;

/**
 * Created by alex o n 11.04.2017.
 */
public class FindView {
    private JDialog jDialog;
    private int higthAligment=50;
    private int heigth=20;
    private int width=100;
    private JButton findByNameAndGroupButton;
    private JButton findByNameAndWorkButton;
    private JButton findNameNumberOfWorkButton;
    private DataBaseManipulation dataBaseManipulation;
    public FindView(DataBaseManipulation dataBaseManipulation){
        this.dataBaseManipulation=dataBaseManipulation;
        jDialog=new JDialog();
        //createElementsOfWindow("");
    }
   public void createElementsOfWindow(String findButtonName) {
        jDialog.getContentPane().setLayout(null);
        jDialog.setVisible(true);
        jDialog.setBounds(500, 250, 500, 500);
        findByNameAndGroupButton = new JButton(findButtonName+" по группе и фамилии");
        findByNameAndGroupButton.setBounds(20, higthAligment + 30, 300, 20);
        jDialog.add(findByNameAndGroupButton);
        findByNameAndWorkButton = new JButton(findButtonName+" по фамилии и работе");
        findByNameAndWorkButton.setBounds(20, higthAligment + 70, 300, 20);
        jDialog.add(findByNameAndWorkButton);
        findNameNumberOfWorkButton = new JButton(findButtonName+" по фамилии и количеству работ");
        findNameNumberOfWorkButton.setBounds(20, higthAligment + 110, 300, 20);
        jDialog.add(findNameNumberOfWorkButton);

        findByNameAndGroupButton.addActionListener(new FindByNameAndGroupListener(this, dataBaseManipulation,findButtonName));
        findByNameAndWorkButton.addActionListener(new FindByNameAndWorkListener(this, dataBaseManipulation));
        findNameNumberOfWorkButton.addActionListener(new FindByNameAndNumberOfWorkListener(this, dataBaseManipulation));
    }

    public void removeBottons() {
        jDialog.remove(findByNameAndGroupButton);
        jDialog.remove(findByNameAndWorkButton);
        jDialog.remove(findNameNumberOfWorkButton);
    }

    public void createFindByNameAndGroupViev(){

    }

    public JDialog getjDialog() {
        return jDialog;
    }

    public JButton getFindByNameAndGroupButton() {
        return findByNameAndGroupButton;
    }

    public JButton getFindByNameAndWorkButton() {
        return findByNameAndWorkButton;
    }

    public JButton getFindByNameNumberOfWorkButton() {
        return findNameNumberOfWorkButton;
    }
}
