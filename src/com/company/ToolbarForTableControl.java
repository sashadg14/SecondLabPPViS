package com.company;

import com.company.controllers.PageManipulator;
import com.company.model.Table;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by alex o n 23.04.2017.
 */
public class ToolbarForTableControl {
    PageManipulator pageManipulator;
    Window window;
    JButton leftButton;
    JButton rightButton;
    JButton leftButtonToEnd;
    JButton rightButtonToEnd;
    JButton resizeButton;
    Table table;
    JLabel jLabel;
    int posX,posY;
    public ToolbarForTableControl(int posX,int posY,PageManipulator pageManipulator, Window window,Table table){
        this.pageManipulator=pageManipulator;
        this.window=window;
        this.table=table;
        this.posX=posX;
        this.posY=posY;
        jLabel=new JLabel();
       // window.add(jLabel);
        leftButton = new JButton();
        rightButton = new JButton();
        leftButtonToEnd = new JButton();
        rightButtonToEnd = new JButton();
        resizeButton = new JButton();
        leftButton.setIcon(new ImageIcon("src\\com\\company\\resourses\\left.png"));
        rightButton.setIcon(new ImageIcon("src\\com\\company\\resourses\\right.png"));
        leftButtonToEnd.setIcon(new ImageIcon("src\\com\\company\\resourses\\left_1.png"));
        rightButtonToEnd.setIcon(new ImageIcon("src\\com\\company\\resourses\\right_1.png"));
        resizeButton.setIcon(new ImageIcon("src\\com\\company\\resourses\\resize.png"));
        JToolBar jToolBarSecond = new JToolBar("Toolbar", JToolBar.HORIZONTAL);
        jToolBarSecond.add(leftButtonToEnd);
        jToolBarSecond.add(leftButton);
        jToolBarSecond.add(rightButton);
        jToolBarSecond.add(rightButtonToEnd);
        jToolBarSecond.add(resizeButton);
        createJLable();
        jToolBarSecond.add(jLabel);
        jToolBarSecond.setBounds(posX,posY,1600,30);
        setListeners();
        window.add(jToolBarSecond);
    }
    public void createJLable(){
        jLabel.setText("Страница "+pageManipulator.getNoOfPage()+" из " +
                pageManipulator.getCountOfPages()+", макс. на странице "+pageManipulator.getCountOfStudentOnLists());
    }

    public void setPageManipulator(PageManipulator pageManipulator) {
        this.pageManipulator = pageManipulator;
    }

    private void setListeners()
    {
        rightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                pageManipulator.NextPage();
                createJLable();
            }
        });
        leftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                pageManipulator.PreviousPage();
                createJLable();
            }
        });
        rightButtonToEnd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                pageManipulator.LastPage();
                createJLable();
            }
        });
        leftButtonToEnd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                pageManipulator.FirstPage();
                createJLable();
            }
        });

        resizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String number=JOptionPane.showInputDialog("Введите число студентов на странице");
                if(number!=""||number!=null) {
                    pageManipulator.setCountOfStudentOnLists(Integer.parseInt(number));
                    createJLable();
                table.renderTable(pageManipulator.returnPageOfStudents());
                }
            }
        });
    }

    public JButton getLeftButton() {
        return leftButton;
    }

    public JButton getRightButton() {
        return rightButton;
    }

    public JButton getLeftButtonToEnd() {
        return leftButtonToEnd;
    }

    public JButton getRightButtonToEnd() {
        return rightButtonToEnd;
    }

    public JButton getResizeButton() {
        return resizeButton;
    }
}
