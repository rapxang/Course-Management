package Student;
import ModuleStudents.Student_BIBM_lv5;
import ModuleTeachers.Level5_BIBM_Teachers;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Level5_BIBM extends JFrame {
    JMenuBar menuBar;
    JPanel dataPanel;
    JPanel buttonPanel;
    JPanel secondPanel;
    JPanel filePanel;
    // Reference variable for different fields, buttons, table and table model
    DefaultTableModel model;
    JTable table;
    JTextField txtName, txtSname, txtPhone, txtAddress;
    ButtonGroup bgGroup;
    JButton btnEnroll, btnShow;
    Student_BIBM_lv5 st_enr;

    /**
     * Constructor of the class
     */
    public Level5_BIBM() {
        setTitle("Course Management System");
        setVisible(true);
        setSize(500, 500);
        //setMinimumSize(new Dimension(700, 700));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        st_enr = new Student_BIBM_lv5();
        setJMenuBar(getMenu());
        setLayout(new GridLayout(1, 2));


        JScrollPane scrollPane = new JScrollPane(table);
        JPanel subpanel2 = new JPanel(new GridLayout(3, 1));
        subpanel2.add(secondUI());
        subpanel2.add(CourseLv5BIBM_Sem1());
        subpanel2.add(CourseLv5BIBM_Sem2());


        add(subpanel2);

        JPanel subPanel = new JPanel(new GridLayout(3, 1));
        subPanel.add(dataUI());
        subPanel.add(Enroll());
        subPanel.add(Show());
        add(subPanel);
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, subPanel, subpanel2);
        add(splitPane);
        refreshTable();
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
                JOptionPane.showMessageDialog(secondUI(), "It is Still in trial Version !!!", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // top level menu added inside menu bar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        return menuBar;
    }

    private void refreshTable() {
        //removes data from JTable
        model.setRowCount(0);
        try {
            ResultSet resultSet = st_enr.get();
            while (resultSet.next()) {
                model.addRow(new Object[]{
                        resultSet.getString("first_name"),
                        resultSet.getString("second_name"),
                        resultSet.getString("phone_number"),
                        resultSet.getString("address"),
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private JPanel secondUI() {
        secondPanel = new JPanel(new BorderLayout());
        secondPanel.setBorder(BorderFactory.createTitledBorder("Student Information"));
        model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"First Name", "Second Name", "Phone Number", "Address"});
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        secondPanel.add(scrollPane);

        // added event listener for row selection inside JTable
        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // returns row number of selected row in JTable
                int selectedRow = table.getSelectedRow();
                // model.getValueAt(selectedRow, 0) returns a value for the cell at the given row and column
                // .toString() returns string representation of the object
                txtName.setText(model.getValueAt(selectedRow, 0).toString());
                txtSname.setText(model.getValueAt(selectedRow, 1).toString());
                txtPhone.setText(model.getValueAt(selectedRow, 2).toString());
                txtAddress.setText(model.getValueAt(selectedRow, 3).toString());
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        return secondPanel;
    }

    private JPanel CourseLv5BIBM_Sem1() {
        dataPanel = new JPanel();
        dataPanel.setLayout(new GridBagLayout());
        dataPanel.setBorder(BorderFactory.createTitledBorder("Courses in Level 5/Year 2:BIBM:SEM-1"));

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


        return dataPanel;
    }


    private JPanel CourseLv5BIBM_Sem2() {
        dataPanel = new JPanel();
        dataPanel.setLayout(new GridBagLayout());
        dataPanel.setBorder(BorderFactory.createTitledBorder("Courses in Level 5/Year 2:BIBM:SEM-2"));

        GridBagConstraints course = new GridBagConstraints();
        course.fill = GridBagConstraints.HORIZONTAL;
        course.weightx = 1;
        course.insets = new Insets(5, 5, 5, 5);


        course.gridx = 0;
        course.gridy = 0;
        dataPanel.add(new JLabel("5BU010: Digital Business and Innovation"), course);
        course.gridx = 0;
        course.gridy = 1;
        dataPanel.add(new JLabel("5BU012: Operations and Supply Management"), course);
        course.gridx = 0;
        course.gridy = 2;
        dataPanel.add(new JLabel("5HR006: International Human Resources – The Key Issues"), course);


        return dataPanel;
    }


    private JPanel dataUI() {
        dataPanel = new JPanel();
        dataPanel.setLayout(new GridBagLayout());
        dataPanel.setBorder(BorderFactory.createTitledBorder("Info:"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        dataPanel.add(new JLabel("First Name"), gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        dataPanel.add(new JLabel("Second Name"), gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        dataPanel.add(new JLabel("Phone"), gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        dataPanel.add(new JLabel("Address"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        txtName = new JTextField(20);
        dataPanel.add(txtName, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        txtSname = new JTextField(20);
        dataPanel.add(txtSname, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        txtPhone = new JTextField(20);
        dataPanel.add(txtPhone, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        txtAddress = new JTextField(20);
        dataPanel.add(txtAddress, gbc);

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

    public JButton getBtnEnroll() {
        return btnEnroll;
    }

    public JTextField getAddress() {
        return txtAddress;
    }

    public JTable getTable() {
        return table;
    }

    private JPanel Show() {
        buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Module Teacher Information:"));
        btnShow = new JButton("Show Modules Teacher");

        buttonPanel.add(btnShow);


        btnShow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Level5_BIBM_Teachers teacher = new Level5_BIBM_Teachers();
                teacher.setVisible(true);
            }
        });

        return buttonPanel;
    }

    private JPanel Enroll() {
        buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Are you Ready for Enrollment?"));
        btnEnroll = new JButton("Enroll");

        buttonPanel.add(btnEnroll);

        btnEnroll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String first_name = getFirstName().getText().trim();
                String second_name = getSecondName().getText().trim();
                String phone_number = getPhone().getText().trim();
                String address = getAddress().getText().trim();
                if (first_name.isEmpty() || second_name.isEmpty() || phone_number.isEmpty() || address.isEmpty()) {
                    JOptionPane.showMessageDialog(buttonPanel, "Some of the fields are empty", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    //model.addRow(new String[]{first_name,second_name,phone_number,address});
                    st_enr.enroll(first_name, second_name, phone_number, address);
                    refreshTable();
                    JOptionPane.showMessageDialog(buttonPanel, "Congratulation on your enrollment!", "Success", JOptionPane.INFORMATION_MESSAGE);

                }
            }
        });
        return buttonPanel;
    }

    public static void main(String[] args) {
        new Level5_BIBM();
    }
}





/*
 */
