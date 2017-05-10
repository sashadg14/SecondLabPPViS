package com.company.fileWorking;
import com.company.model.Student;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex o n 23.04.2017.
 */public class Parser {
    public void writeFile(List<Student> studentArrayList){
        try
        {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

            Document document = documentBuilder.newDocument();
            Element students = document.createElement("students");
            document.appendChild(students);
             for(Student stud:studentArrayList) {
                 Element student = document.createElement("student");
                 students.appendChild(student);

                 Element firstName = document.createElement("firstName");
                 firstName.appendChild(document.createTextNode(stud.getFirstName()));//тута фамилию делать
                 student.appendChild(firstName);

                 Element middleName = document.createElement("middleName");
                 middleName.appendChild(document.createTextNode(stud.getMiddleName()));//тута имя делать
                 student.appendChild(middleName);

                 Element lastName = document.createElement("lastName");
                 lastName.appendChild(document.createTextNode(stud.getLastName()));//тута отчество делать
                 student.appendChild(lastName);

                 Element group = document.createElement("group");
                 group.appendChild(document.createTextNode(stud.getGroup()));
                 student.appendChild(group);

                 Element publicWork = document.createElement("publicWork");
                 student.appendChild(publicWork);
                 for (int i = 1; i <= 10; i++) {
                     Element semester = document.createElement("semester" + i);
                     semester.appendChild(document.createTextNode(stud.getPublicWork().get(i-1)));
                     publicWork.appendChild(semester);
                 }
             }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            JFileChooser jf = new JFileChooser();
            String fileName = null;
            int result = jf.showSaveDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                fileName = jf.getSelectedFile().getAbsolutePath();
            }
            StreamResult streamResult = new StreamResult(new File(fileName));
            transformer.transform(domSource, streamResult);
        }
        catch (ParserConfigurationException pce)
        {
            System.out.println(pce.getLocalizedMessage());
            pce.printStackTrace();
        }
        catch (TransformerException te)
        {
            System.out.println(te.getLocalizedMessage());
            te.printStackTrace();
        }
    }
    public List<Student> readFromFile(){
        List<Student> studentArrayList= new ArrayList<Student>();
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            MyHandler handler = new MyHandler(studentArrayList);
            JFileChooser jf = new JFileChooser();
            String fileName = null;
            int result = jf.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                fileName = jf.getSelectedFile().getAbsolutePath();
            }
            if(fileName!=null)
            saxParser.parse(new File(fileName), handler);
            //Get Employees list
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return studentArrayList;
    }
}
