package com.company;

import com.company.controllers.DataBaseManipulation;
import com.company.controllers.PageManipulator;
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
    JButton saveButton;
    JButton loadButton;

    Table table;
    StudentBase studentBase;
    DataBaseManipulation dataBaseManipulation;
    PageManipulator pageManipulator;
    ToolbarForTableControl toolbarForTableControl;
   public View(){
       jFrame= new JFrame();
       jFrame.getContentPane().setLayout(null);
       studentBase= new StudentBase();
       dataBaseManipulation= new DataBaseManipulation(studentBase,this);
       JLabel JLABLE = new JLabel();
       table= new Table(jFrame);
       pageManipulator=new PageManipulator(studentBase.getStudents(),table);
       toolbarForTableControl=new ToolbarForTableControl(700,700,pageManipulator,jFrame,table);
       table.setToolbarForTableControl(toolbarForTableControl);
       JLABLE.setBounds(0,0,1600,900);
        jFrame.add(JLABLE);
       jFrame.setSize(1000,800);
       jFrame.setVisible(true);
       findButton = new JButton();
       addButton = new JButton();
        deleteButton = new JButton();
        saveButton=new JButton();
        loadButton=new JButton();
       findButton.setIcon(new ImageIcon("src\\com\\company\\resourses\\findIcon.png"));
       addButton.setIcon(new ImageIcon("src\\com\\company\\resourses\\addIcon.png"));
       deleteButton.setIcon(new ImageIcon("src\\com\\company\\resourses\\delete.png"));
       saveButton.setIcon(new ImageIcon("src\\com\\company\\resourses\\save.png"));
       loadButton.setIcon(new ImageIcon("src\\com\\company\\resourses\\load.png"));
       creatingTolbar();
       creatingMenu();
       jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

    public Table getTable() {
        return table;
    }

    public JFrame getjFrame() {
        return jFrame;
    }

    private void creatingTolbar() {
        final JToolBar toolbar = new JToolBar("Toolbar", JToolBar.HORIZONTAL);
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
            renderTable();
            }
        });
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                studentBase.saveStudentBase();

            }
        });
        loadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                studentBase.readStudentBase();
                pageManipulator.setStudentArrayList(studentBase.getStudents());
                toolbarForTableControl.setPageManipulator(pageManipulator);
                renderTable();
            }
        });
        toolbar.add(addButton);
        toolbar.add(findButton);
        toolbar.add(deleteButton);
        toolbar.add(saveButton);
        toolbar.add(loadButton);

        toolbar.setBounds(0,0,1600,50);
        jFrame.add(toolbar);
        jFrame.update(jFrame.getGraphics());

        jFrame.getContentPane().setLayout(null);
        toolbar.setBounds(0,0,1600,50);
        jFrame.add(toolbar);
        jFrame.update(jFrame.getGraphics());
        //jFrame.getContentPane().setLayout(null);
    }
    private void creatingMenu(){
        JMenuBar menuBar = new JMenuBar();
        jFrame.setJMenuBar(menuBar);
        JMenu fileMenu = new JMenu("Файл");
        menuBar.add(fileMenu);
        fileMenu.add(new JMenuItem(new AbstractAction("Сохранить как...") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                saveButton.doClick();
            }
        }));
        fileMenu.add(new JMenuItem(new AbstractAction("Загрузить") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                loadButton.doClick();
            }
        }));

        JMenu dataBase = new JMenu("База студентов");
        menuBar.add(dataBase);
        dataBase.add(new JMenuItem(new AbstractAction("Добавить") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                addButton.doClick();
            }
        }));
        dataBase.add(new JMenuItem(new AbstractAction("Удалить") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
            deleteButton.doClick();
            }
        }));
        dataBase.add(new JMenuItem(new AbstractAction("Поиск") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                findButton.doClick();
            }
        }));

        JMenu table = new JMenu("Таблица");
        menuBar.add(table);
        dataBase.add(new JMenuItem(new AbstractAction("Следующая страница") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
            toolbarForTableControl.getRightButton().doClick();
            }
        }));
        table.add(new JMenuItem(new AbstractAction("Предыдущая страница") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                toolbarForTableControl.getLeftButton().doClick();
            }
        }));
        table.add(new JMenuItem(new AbstractAction("Первая страница") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                toolbarForTableControl.getLeftButtonToEnd().doClick();
            }
        }));
        table.add(new JMenuItem(new AbstractAction("Последняя страница") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                toolbarForTableControl.getRightButtonToEnd().doClick();
            }
        }));
        table.add(new JMenuItem(new AbstractAction("Изменить размер страницы") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                toolbarForTableControl.getResizeButton().doClick();
            }
        }));
    }
   public void renderTable(){
        table.renderTable(pageManipulator.returnPageOfStudents());
    }
}
