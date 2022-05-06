package Courses;
import Student.Level4_BIT;
import Student.Level5_BIT;
import Student.Level6_BIT;
import javax.swing.*;
        import javax.swing.table.DefaultTableModel;
        import java.awt.*;
        import java.awt.event.*;
        import java.sql.ResultSet;
        import java.sql.SQLException;



public class BIT_Courses extends JFrame {
    JMenuBar menuBar;
    JPanel dataPanel;
    JPanel filePanel;


    /**
     * Constructor of the class
     */
    public BIT_Courses() {
        setTitle("Course Management System");
        setVisible(true);
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setJMenuBar(getMenu());
        setLayout(new GridLayout(2, 2));
        add(CourseLv4BIT());
        add(CourseLv5BIT());
        add(CourseLv6BIT());
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
    private JPanel CourseLv4BIT(){
        dataPanel=new JPanel();
        dataPanel.setLayout(new GridBagLayout());
        dataPanel.setBorder(BorderFactory.createTitledBorder("Courses in Level 4/Year 1:BIT"));

        GridBagConstraints course = new GridBagConstraints();
        course.fill = GridBagConstraints.HORIZONTAL;
        course.weightx = 1;
        course.insets = new Insets(5, 5, 5, 5);

        course.gridx = 0;
        course.gridy = 0;
        dataPanel.add(new JLabel("4CI018: Academic Skills and Team Based Learning"), course);
        course.gridx = 0;
        course.gridy = 1;
        dataPanel.add(new JLabel("4CS001: Introductory Programming and Problem Solving"), course);
        course.gridx = 0;
        course.gridy = 2;
        dataPanel.add(new JLabel("4CS015: Fundamentals of Computing"), course);
        course.gridx = 0;
        course.gridy = 3;
        dataPanel.add(new JLabel("4CS016: Embedded System Programming"),course);
        course.gridx = 0;
        course.gridy = 4;
        dataPanel.add(new JLabel("4CS017: Internet Software Architecture"),course);
        course.gridx = 0;
        course.gridy = 5;
        dataPanel.add(new JLabel("4MM013: Computational Mathematics"),course);


        return dataPanel;
    }

    private JPanel CourseLv5BIT(){
        dataPanel=new JPanel();
        dataPanel.setLayout(new GridBagLayout());
        dataPanel.setBorder(BorderFactory.createTitledBorder("Courses in Level 5/Year 2:BIT"));

        GridBagConstraints course = new GridBagConstraints();
        course.fill = GridBagConstraints.HORIZONTAL;
        course.weightx = 1;
        course.insets = new Insets(5, 5, 5, 5);

        course.gridx = 0;
        course.gridy = 0;
        dataPanel.add(new JLabel("5CS037: Concepts and Technologies of AI"), course);
        course.gridx = 0;
        course.gridy = 1;
        dataPanel.add(new JLabel("5CS019: Object-Oriented Design and Programming"), course);
        course.gridx = 0;
        course.gridy = 2;
        dataPanel.add(new JLabel("5CS021: Numerical Methods and Concurrency"), course);
        course.gridx = 0;
        course.gridy = 3;
        dataPanel.add(new JLabel("5CS022: Distributed and Cloud System Programming"),course);
        course.gridx = 0;
        course.gridy = 4;
        dataPanel.add(new JLabel("5CS024: Collaborative Development"),course);
        course.gridx = 0;
        course.gridy = 5;
        dataPanel.add(new JLabel("5CS020: Human Computer Interaction"),course);


        return dataPanel;
    }


    private JPanel CourseLv6BIT(){
        dataPanel=new JPanel();
        dataPanel.setLayout(new GridBagLayout());
        dataPanel.setBorder(BorderFactory.createTitledBorder("Courses in Level 6/Year 3:BIT"));

        GridBagConstraints course = new GridBagConstraints();
        course.fill = GridBagConstraints.HORIZONTAL;
        course.weightx = 1;
        course.insets = new Insets(5, 5, 5, 5);

        course.gridx = 0;
        course.gridy = 0;
        dataPanel.add(new JLabel("6CS014: Complex System"), course);
        course.gridx = 0;
        course.gridy = 1;
        dataPanel.add(new JLabel("6CS005: High Performance Computing"), course);
        course.gridx = 0;
        course.gridy = 2;
        dataPanel.add(new JLabel("6CS007: Project and Professionalism"), course);
        course.gridx = 0;
        course.gridy = 3;
        dataPanel.add(new JLabel("6CS012: Artificial Intelligence and Machine Learning"),course);
        course.gridx = 0;
        course.gridy = 4;
        dataPanel.add(new JLabel("6CS030: Big Data"),course);

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
                Level4_BIT lv4=new Level4_BIT();
                lv4.setVisible(true);
            }
        });
        Level5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Level5_BIT lv5=new Level5_BIT();
                lv5.setVisible(true);
            }
        });
        Level6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Level6_BIT lv6=new Level6_BIT();
                lv6.setVisible(true);
            }
        });


        return filePanel;
    }


    public static void main(String[] args) {
        new BIT_Courses();
    }
}

