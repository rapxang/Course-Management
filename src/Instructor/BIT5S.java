package Instructor;


        import ModuleStudents.Student_BIT_lv5;
        import ModuleTeachers.Level5_BIT_Teachers;

        import javax.swing.*;
        import javax.swing.table.DefaultTableModel;
        import java.awt.*;
        import java.awt.event.*;
        import java.sql.ResultSet;
        import java.sql.SQLException;



public class BIT5S extends JFrame {
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
    JButton btnEnroll,btnShow;
    Student_BIT_lv5 lv5_enr;

    /**
     * Constructor of the class
     */
    public BIT5S() {
        setTitle("Course Management System");
        setVisible(true);
        //setMinimumSize(new Dimension(700, 700));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lv5_enr=new Student_BIT_lv5();
        setJMenuBar(getMenu());
        setLayout(new GridLayout(1, 2));
        add(secondUI());




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
            ResultSet resultSet = lv5_enr.get();
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



    public static void main(String[] args) {
        new BIT5S();
    }
}


