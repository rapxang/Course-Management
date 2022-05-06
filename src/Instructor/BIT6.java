
package Instructor;

import ModuleTeachers.*;
import Administrator.Administrator;
import Instructor.Instructor;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Courses.Courses;
import ModuleTeachers.Level6_BIBM_Teachers;

public class  BIT6 extends JFrame {
    JPanel buttonPanel;
    // Reference variable for different fields, buttons, table and table model
    JButton btnStudent, btnModule, btnMarking, btnExit;

    /**
     * Constructor of the class
     */
    public BIT6() {
        setTitle("Course Management System");
        setVisible(true);
        setSize(300,300);
        //setMinimumSize(new Dimension(700, 700));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 2));
        add(buttonUI());
        setLocationRelativeTo(null);


        btnModule.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(buttonUI(),"Module Assined & Teachers!!");


            }
        });
        btnStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(buttonUI(),"Students in the Module!!");

            }
        });
        btnMarking.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(buttonUI(),"Assign marks for students!!");

            }
        });
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
    private JPanel buttonUI() {


        buttonPanel = new JPanel(new GridLayout(2, 2));
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Features:"));
        btnModule = new JButton("Module Assigned");
        btnStudent = new JButton("View Students");
        btnMarking= new JButton("Marking");
        btnExit=new JButton("Exit");
        buttonPanel.add(btnModule);
        buttonPanel.add(btnStudent);
        buttonPanel.add(btnMarking);
        buttonPanel.add(btnExit);


        btnModule.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Level6_BIT_Teachers teachers=new Level6_BIT_Teachers();
                teachers.setVisible(true);
            }
        });
        btnStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BIT6S s =new BIT6S();
                s.setVisible(true);
            }
        });
        btnMarking.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MBIT_LV6 s=new MBIT_LV6();
                s.setVisible(true);
            }
        });

        return buttonPanel;
    }



    public static void main(String[] args) {
        new BIT6();

    }}