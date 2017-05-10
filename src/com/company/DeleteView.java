package com.company;

import com.company.controllers.*;
import com.company.listners.DeleteByNameAndGroupListener;

import javax.swing.*;

/**
 * Created by alex o n 11.04.2017.
 */
public class DeleteView {
    DataBaseManipulation dataBaseManipulation;
    FindView findView;
    public DeleteView(DataBaseManipulation dataBaseManipulation){
        findView=new FindView(dataBaseManipulation);
        this.dataBaseManipulation=dataBaseManipulation;
    }
    public JDialog getjDialog(){
        return findView.getjDialog();
    }
    public void removeBottons(){}
    void createElementsOfWindow(String string){
        findView.createElementsOfWindow(string);
        findView.getFindByNameAndGroupButton().removeActionListener(findView.getFindByNameAndGroupButton().getActionListeners()[0]);
        findView.getFindByNameAndWorkButton().removeActionListener(findView.getFindByNameAndWorkButton().getActionListeners()[0]);
        findView.getFindByNameNumberOfWorkButton().removeActionListener(findView.getFindByNameNumberOfWorkButton().getActionListeners()[0]);
        findView.getFindByNameAndGroupButton().addActionListener(new DeleteByNameAndGroupListener(findView, dataBaseManipulation));
        findView.getjDialog().update(findView.getjDialog().getGraphics());
    }
}
