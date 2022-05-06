package Instructor;


        import Student.Level4_BIT;
        import Student.Level5_BIT;
        import Student.Level6_BIT;
        import javax.swing.*;
        import javax.swing.table.DefaultTableModel;
        import java.awt.*;
        import java.awt.event.*;
        import java.sql.ResultSet;
        import java.sql.SQLException;



public class BIT extends JFrame {
    JMenuBar menuBar;
    JPanel dataPanel;
    JPanel filePanel;


    /**
     * Constructor of the class
     */
    public BIT() {
        setTitle("Course Management System");
        setVisible(true);
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setJMenuBar(getMenu());
        setLayout(new GridLayout(1, 1));
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




    private JPanel FileUI() {
        filePanel = new JPanel(new GridLayout(3, 1));
        filePanel.setBorder(BorderFactory.createTitledBorder("Select Your Level:"));

        JRadioButton Level_4 = new JRadioButton("Level 4");
        JRadioButton Level_5 = new JRadioButton("Level 5");
        JRadioButton Level_6 = new JRadioButton("Level 6");

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(Level_4);
        buttonGroup.add(Level_5);
        buttonGroup.add(Level_6);
        filePanel.add(Level_4);
        filePanel.add(Level_5);
        filePanel.add(Level_6);


        Level_4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BIT4 role=new BIT4();
                role.setVisible(true);
            }
        });
        Level_5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BIT5 role=new BIT5();
                role.setVisible(true);
            }
        });
        Level_6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BIT6 role=new BIT6();
                role.setVisible(true);
            }
        });



        return filePanel;
    }


    public static void main(String[] args) {

        new BIT();
    }
}

