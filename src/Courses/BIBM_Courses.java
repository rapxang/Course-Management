package Courses;
import Student.Level5_BIBM;
import Student.Level4_BIBM;
import ModuleStudents.Student_BIBM_lv6;
import ModuleTeachers.Level6_BIBM_Teachers;
import Student.Level6_BIBM;

import javax.swing.*;
        import javax.swing.table.DefaultTableModel;
        import java.awt.*;
        import java.awt.event.*;
        import java.sql.ResultSet;
        import java.sql.SQLException;



public class BIBM_Courses extends JFrame {
    JMenuBar menuBar;
    JPanel dataPanel;
    JPanel filePanel;


    /**
     * Constructor of the class
     */
    public BIBM_Courses() {
        setTitle("Course Management System");
        setVisible(true);
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setJMenuBar(getMenu());
        setLayout(new GridLayout(2, 2));
        add(CourseLv4BIBM());
        add(CourseLv5BIBM());
        add(CourseLv6BIBM());
        add(FileUI());
        setLocationRelativeTo(null);
    }

    private JMenuBar getMenu() {
        menuBar = new JMenuBar();

        // define top level menu
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu helpMenu = new JMenu("Help");

        // creating sub menu
        JMenuItem clearItem = new JMenuItem("Clear");
        JMenuItem updateItem = new JMenuItem("Search");
        JMenuItem addItem = new JMenuItem("Add");
        JMenuItem removeItem = new JMenuItem("Remove");
        JMenuItem exitItem = new JMenuItem("Exit");
        JMenuItem aboutItem = new JMenuItem("About");

        // sub menu added inside file menu
        editMenu.add(clearItem);
        editMenu.add(updateItem);
        editMenu.addSeparator();
        editMenu.add(addItem);
        editMenu.add(removeItem);
        fileMenu.add(exitItem);
        helpMenu.add(aboutItem);

        //adding Mnemonics to the items in the  menubar
        fileMenu.setMnemonic(KeyEvent.VK_E);

        clearItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_DOWN_MASK));
        updateItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
        addItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK));
        removeItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.CTRL_DOWN_MASK));
        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK));
        aboutItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, KeyEvent.CTRL_DOWN_MASK));

        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        aboutItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(FileUI(), "It is Still in trial Version !!!", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // top level menu added inside menu bar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        return menuBar;
    }

    private JPanel CourseLv4BIBM(){
        dataPanel=new JPanel();
        dataPanel.setLayout(new GridBagLayout());
        dataPanel.setBorder(BorderFactory.createTitledBorder("Courses in Level 4/Year 1:BIBM"));

        GridBagConstraints course = new GridBagConstraints();
        course.fill = GridBagConstraints.HORIZONTAL;
        course.weightx = 1;
        course.insets = new Insets(5, 5, 5, 5);

        course.gridx = 0;
        course.gridy = 0;
        dataPanel.add(new JLabel("4IB004: Business in a Global Context"), course);
        course.gridx = 0;
        course.gridy = 1;
        dataPanel.add(new JLabel("4MK007: Principles of Marketing"), course);
        course.gridx = 0;
        course.gridy = 2;
        dataPanel.add(new JLabel("4MK006: Introduction to Brand Communication"), course);
        course.gridx = 0;
        course.gridy = 3;
        dataPanel.add(new JLabel("4HR002: Introduction to People at work"),course);
        course.gridx = 0;
        course.gridy = 4;
        dataPanel.add(new JLabel("4AC013: Financial Management"),course);
        course.gridx = 0;
        course.gridy = 5;
        dataPanel.add(new JLabel("4HR017: Diversity Management in a Global Context"),course);


        return dataPanel;
    }


    private JPanel CourseLv5BIBM(){
        dataPanel=new JPanel();
        dataPanel.setLayout(new GridBagLayout());
        dataPanel.setBorder(BorderFactory.createTitledBorder("Courses in Level 5/Year 2:BIBM"));

        GridBagConstraints course = new GridBagConstraints();
        course.fill = GridBagConstraints.HORIZONTAL;
        course.weightx = 1;
        course.insets = new Insets(5, 5, 5, 5);

        course.gridx = 0;
        course.gridy = 0;
        dataPanel.add(new JLabel("5FC003: International Financial Institutions and Market"), course);
        course.gridx = 0;
        course.gridy = 1;
        dataPanel.add(new JLabel("5IB004: Economics of Managerial Decision-Making"), course);
        course.gridx = 0;
        course.gridy = 2;
        dataPanel.add(new JLabel("5IB005: Contemporary Issues in IBM"), course);
        course.gridx = 0;
        course.gridy = 3;
        dataPanel.add(new JLabel("5BU010: Digital Business and Innovation"),course);
        course.gridx = 0;
        course.gridy = 4;
        dataPanel.add(new JLabel("5BU012: Operations and Supply Management"),course);
        course.gridx = 0;
        course.gridy = 5;
        dataPanel.add(new JLabel("5HR006: International Human Resources – The Key Issues"),course);


        return dataPanel;
    }


    private JPanel CourseLv6BIBM(){
        dataPanel=new JPanel();
        dataPanel.setLayout(new GridBagLayout());
        dataPanel.setBorder(BorderFactory.createTitledBorder("Courses in Level 6/Year 3:BIBM"));

        GridBagConstraints course = new GridBagConstraints();
        course.fill = GridBagConstraints.HORIZONTAL;
        course.weightx = 1;
        course.insets = new Insets(5, 5, 5, 5);

        course.gridx = 0;
        course.gridy = 0;
        dataPanel.add(new JLabel("6IB003: Dynamics of Multinational Companies"), course);
        course.gridx = 0;
        course.gridy = 1;
        dataPanel.add(new JLabel("6IB006: Debating Globalisation"), course);
        course.gridx = 0;
        course.gridy = 2;
        dataPanel.add(new JLabel("6IB011: Business Research Methods"), course);
        course.gridx = 0;
        course.gridy = 3;
        dataPanel.add(new JLabel("6MK001: International Marketing"),course);
        course.gridx = 0;
        course.gridy = 4;
        dataPanel.add(new JLabel("6BE003: Strategic Management"),course);
        course.gridx = 0;
        course.gridy = 5;
        dataPanel.add(new JLabel("6BU013: Independent Project"),course);

        return dataPanel;
    }






    private JPanel FileUI() {
        filePanel = new JPanel(new GridLayout(3, 1));
        filePanel.setBorder(BorderFactory.createTitledBorder("Select Your Level:"));

        JRadioButton Level4 = new JRadioButton("Level 4");
        JRadioButton Level5 = new JRadioButton("Level 5");
        JRadioButton Level6 = new JRadioButton("Level 6");

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(Level4);
        buttonGroup.add(Level5);
        buttonGroup.add(Level6);
        filePanel.add(Level4);
        filePanel.add(Level5);
        filePanel.add(Level6);


        Level4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Level4_BIBM lv4=new Level4_BIBM();
                lv4.setVisible(true);
            }
        });
        Level5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Level5_BIBM lv5=new Level5_BIBM();
                lv5.setVisible(true);
            }
        });
        Level6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Level6_BIBM lv6=new Level6_BIBM();
                lv6.setVisible(true);
            }
        });


        return filePanel;
    }


    public static void main(String[] args) {
        new BIBM_Courses();
    }
}

