package ModuleTeachers;

import javax.swing.*;
        import javax.swing.table.DefaultTableModel;
        import java.awt.*;
        import java.awt.event.*;

public class Level5_BIT_Teachers extends JFrame {
    JPanel buttonPanel;
    // Reference variable for different fields, buttons, table and table model
    JButton btnStudent, btnAdministrator, btnInstructor, btnExit;
    JMenuBar menuBar;
    JPanel dataPanel;
    JPanel secondPanel;
    JPanel filePanel;
    // Reference variable for different fields, buttons, table and table model
    DefaultTableModel model;
    JTable table;
    JTextField txtName, txtSname, txtPhone, txtAddress;
    ButtonGroup bgGroup;
    JButton btnEnroll;


    /**
     * Constructor of the class
     */
    public Level5_BIT_Teachers() {
        setTitle("Course Management System");
        setVisible(true);
        //setSize(400,400);
        setMinimumSize(new Dimension(500, 500));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setJMenuBar(getMenu());
        add(dataUI());
        pack();
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
                JOptionPane.showMessageDialog(dataUI(), "It is Still in trial Version !!!", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // top level menu added inside menu bar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        return menuBar;
    }



    private JPanel dataUI() {
        dataPanel = new JPanel();
        dataPanel.setLayout(new GridBagLayout());
        dataPanel.setBorder(BorderFactory.createTitledBorder("Module Teacher Information:"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        dataPanel.add(new JLabel("Module ID"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        dataPanel.add(new JLabel("Module Name"), gbc);
        gbc.gridx = 2;
        gbc.gridy = 0;
        dataPanel.add(new JLabel("Module Teacher"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        dataPanel.add(new JLabel("5CS037:"),gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        dataPanel.add(new JLabel("Concepts and Technologies of AI"),gbc);
        gbc.gridx = 2;
        gbc.gridy = 1;
        dataPanel.add(new JLabel("Mr.Prakash Shrestha"),gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        dataPanel.add(new JLabel("5CS019:"),gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        dataPanel.add(new JLabel("Object-Oriented Design and Programming"),gbc);
        gbc.gridx = 2;
        gbc.gridy = 2;
        dataPanel.add(new JLabel("Mr.Sachin Tamang"),gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        dataPanel.add(new JLabel("5CS021:"),gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        dataPanel.add(new JLabel("Numerical Methods and Concurrency"),gbc);
        gbc.gridx = 2;
        gbc.gridy = 3;
        dataPanel.add(new JLabel("Mr.Subiran Shrestha"),gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        dataPanel.add(new JLabel("5CS022:"),gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        dataPanel.add(new JLabel("Distributed and Cloud System Programming"),gbc);
        gbc.gridx = 2;
        gbc.gridy = 4;
        dataPanel.add(new JLabel("Mr.Deepson Shrestha"),gbc);
        gbc.gridx = 0;
        gbc.gridy = 5;
        dataPanel.add(new JLabel("5CS024:"),gbc);
        gbc.gridx = 1;
        gbc.gridy = 5;
        dataPanel.add(new JLabel("Collaborative Development"),gbc);
        gbc.gridx = 2;
        gbc.gridy = 5;
        dataPanel.add(new JLabel("Mrs.Manju Lama"),gbc);
        gbc.gridx = 0;
        gbc.gridy = 6;
        dataPanel.add(new JLabel("5CS020:"),gbc);
        gbc.gridx = 1;
        gbc.gridy = 6;
        dataPanel.add(new JLabel("Human Computer Interaction"),gbc);
        gbc.gridx = 2;
        gbc.gridy = 6;
        dataPanel.add(new JLabel("Mr.Deepson Shrestha"),gbc);


        return dataPanel;
    }

    public JTextField getFirstName() {
        return txtName;
    }

    public JTextField getSecondName() {
        return txtSname;
    }

    public JTextField getPhone() {
        return txtPhone;
    }


    public JTextField getAddress() {
        return txtAddress;
    }

    public JTable getTable() {
        return table;
    }



    public static void main(String[] args) {
        new Level4_BIT_Teachers();
    }
}