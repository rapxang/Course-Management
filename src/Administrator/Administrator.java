package Administrator;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.lang.Integer.parseInt;

public class Administrator extends JFrame {
    JMenuBar menuBar;
    JPanel dataPanel;
    JPanel buttonPanel;
    JPanel secondPanel;
    JPanel filePanel;
    // Reference variable for different fields, buttons, table and table model
    DefaultTableModel model;
    JTable table;
    JTextField txtName, txtSname, txtCourse, txtlevel;
    ButtonGroup bgGroup;

    JButton btnClear, btnUpdate, btnAdd, btnRemove, btnResult;
    UserRegistration reg;

    /**
     * Constructor of the class
     */
    public Administrator() {
        setTitle("Phone Book");
        setVisible(true);
        //setMinimumSize(new Dimension(700, 700));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        reg = new UserRegistration();
        setJMenuBar(getMenu());
        setLayout(new GridLayout(1, 2));
        add(secondUI());
        refreshTable();
        JScrollPane scrollPane = new JScrollPane(table);
        secondPanel.add(scrollPane);
        JPanel subPanel = new JPanel(new GridLayout(2, 1));
        subPanel.add(dataUI());

        subPanel.add(buttonUI());
        add(subPanel);
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, subPanel, secondPanel);
        add(splitPane);
        pack();
        setLocationRelativeTo(null);


    }

    /**
     * This method is used for creating menus in the GUI.
     * You must call this method in constructor inside setJMenuBar() to display in menu in the frame.
     *
     * @return list of menus
     */
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
        updateItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(buttonPanel, "You Must select row in table to update", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    String first_name = getFirstName().getText().trim();
                    String second_name = getSecondName().getText().trim();
                    String phone_number = getPhone().getText().trim();
                    String status = getlevel().getText().trim();
                    if (first_name.isEmpty() || second_name.isEmpty() || phone_number.isEmpty() || status.isEmpty()) {
                        JOptionPane.showMessageDialog(buttonPanel, "Some of the fields are empty", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        //model.setValueAt(first_name,selectedRow,1);
                        // model.setValueAt(second_name,selectedRow,2);
                        // model.setValueAt(phone_number,selectedRow,3);
                        // model.setValueAt(status,selectedRow,4);
                        int id = selectedRow + 1;
                        reg.update(id, first_name, second_name, phone_number, status);

                        refreshTable();
                        JOptionPane.showMessageDialog(buttonPanel, "Data of " + first_name + " at row " + (selectedRow + 1) + " updated successfully");
                        btnClear.doClick();
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        addItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = getFirstName().getText().trim();
                String sname = getSecondName().getText().trim();
                String phone = getPhone().getText().trim();
                String Private = getlevel().getText().trim();
                if (name.isEmpty() || sname.isEmpty() || phone.isEmpty()) {
                    JOptionPane.showMessageDialog(dataPanel, "Some of the fields are empty", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    // model.addRow(new String[]{name, sname, phone, Private});
                    reg.addValues(name, sname, phone, Private);

                    refreshTable();


                    JOptionPane.showMessageDialog(dataPanel, "New record is added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                    btnClear.doClick();
                }

            }
        });
        removeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String row = JOptionPane.showInputDialog(buttonPanel, "Please enter row number to remove?", "Queries", JOptionPane.QUESTION_MESSAGE);
                int confirm = JOptionPane.showConfirmDialog(buttonPanel, "Are you sure want to Remove the row?", "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (confirm == JOptionPane.YES_OPTION) {
                    try {
                        int rowDelete = parseInt(row);
                        reg.remove(rowDelete);
                        refreshTable();
                        btnClear.doClick();
                        //model.removeRow(rowDelete - 1);
                    } catch (NumberFormatException exception) {
                        JOptionPane.showMessageDialog(buttonPanel, "You must enter valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                    } catch (ArrayIndexOutOfBoundsException exception) {
                        JOptionPane.showMessageDialog(buttonPanel, "Provided row doesn't exist. Please enter valid row number.", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                }
            }
        });
        clearItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table.clearSelection();
                txtName.setText("");
                txtSname.setText("");
                txtCourse.setText("");
                txtlevel.setText("");
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
        dataPanel.setBorder(BorderFactory.createTitledBorder("Info:"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        dataPanel.add(new JLabel("Module ID"), gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        dataPanel.add(new JLabel("Module Name"), gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        dataPanel.add(new JLabel("Course"), gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        dataPanel.add(new JLabel("Level"), gbc);

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
        txtCourse = new JTextField(20);
        dataPanel.add(txtCourse, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        txtlevel = new JTextField(20);
        dataPanel.add(txtlevel, gbc);

        return dataPanel;
    }

    public JTextField getFirstName() {
        return txtName;
    }

    public JTextField getSecondName() {
        return txtSname;
    }

    public JTextField getPhone() {
        return txtCourse;
    }

    public JTextField getlevel() {
        return txtlevel;
    }

    public JButton getBtnClear() {
        return btnClear;
    }

    public JButton getBtnSearch() {
        return btnUpdate;
    }

    public JButton getBtnAdd() {
        return btnAdd;
    }

    public JButton getBtnRemove() {
        return btnRemove;
    }


    public DefaultTableModel getModel() {
        return (DefaultTableModel) getTable().getModel();
    }

    public JTable getTable() {
        return table;
    }


    private JPanel buttonUI() {


        buttonPanel = new JPanel(new GridLayout(2, 2));
        btnClear = new JButton("Clear");
        btnUpdate = new JButton("Update");
        btnAdd = new JButton("Add");
        btnRemove = new JButton("Remove");
        buttonPanel.add(btnClear);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnRemove);


        btnRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String row = JOptionPane.showInputDialog(buttonPanel, "Please enter row number to remove?", "Queries", JOptionPane.QUESTION_MESSAGE);
                int confirm = JOptionPane.showConfirmDialog(buttonPanel, "Are you sure want to Remove the row?", "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (confirm == JOptionPane.YES_OPTION) {
                    try {
                        int rowDelete = parseInt(row);
                        model.removeRow(rowDelete - 1);
                        reg.remove(rowDelete);
                        refreshTable();
                        btnClear.doClick();
                    } catch (NumberFormatException exception) {
                        JOptionPane.showMessageDialog(buttonPanel, "You must enter valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                    } catch (ArrayIndexOutOfBoundsException exception) {
                        JOptionPane.showMessageDialog(buttonPanel, "Provided row doesn't exist. Please enter valid ID number.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table.clearSelection();
                txtName.setText("");
                txtSname.setText("");
                txtCourse.setText("");
                txtlevel.setText("");

            }
        });

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = getFirstName().getText().trim();
                String secondName = getSecondName().getText().trim();
                String course = getPhone().getText().trim();
                String level = getlevel().getText().trim();
                if (firstName.isEmpty() || secondName.isEmpty() || course.isEmpty() || level.isEmpty()) {
                    JOptionPane.showMessageDialog(buttonPanel, "Some of the fields are empty", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    //model.addRow(new String[]{name, sname, phone, Private});
                    reg.addValues(firstName, secondName, course, level);
                    refreshTable();

                    JOptionPane.showMessageDialog(buttonPanel, "New record is added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                    btnClear.doClick();

                }

            }
        });
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(buttonPanel, "You Must select row in table to update", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    String first_name = getFirstName().getText().trim();
                    String second_name = getSecondName().getText().trim();
                    String phone_number = getPhone().getText().trim();
                    String status = getlevel().getText().trim();
                    if (first_name.isEmpty() || second_name.isEmpty() || phone_number.isEmpty()) {
                        JOptionPane.showMessageDialog(buttonPanel, "Some of the fields are empty", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        //model.setValueAt(first_name,selectedRow,1);
                        // model.setValueAt(second_name,selectedRow,2);
                        // model.setValueAt(phone_number,selectedRow,3);
                        // model.setValueAt(status,selectedRow,4);
                        int id;
                        id = Integer.parseInt(model.getValueAt(selectedRow, 0).toString());
                        reg.update(id, first_name, second_name, phone_number, status);
                        refreshTable();
                        JOptionPane.showMessageDialog(buttonPanel, "Data of " + first_name + " at row " + (selectedRow + 1) + " updated successfully");
                        btnClear.doClick();
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        return buttonPanel;
    }

    private void refreshTable() {
        //removes data from JTable
        model.setRowCount(0);
        try {
            ResultSet resultSet = reg.get();
            while (resultSet.next()) {
                model.addRow(new Object[]{
                        resultSet.getInt("id"),
                        resultSet.getString("module_id"),
                        resultSet.getString("module_name"),
                        resultSet.getString("course"),
                        resultSet.getString("level"),
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private JPanel secondUI() {
        secondPanel = new JPanel(new BorderLayout());
        secondPanel.setBorder(BorderFactory.createTitledBorder("Courses with their Modules:"));
        model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"(ID)", "MODULE ID", "MODULE NAME", "COURSE", "LEVEL"});
        table = new JTable(model);
        table.setSelectionBackground(Color.GRAY);
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
                txtName.setText(model.getValueAt(selectedRow, 1).toString());
                txtSname.setText(model.getValueAt(selectedRow, 2).toString());
                txtCourse.setText(model.getValueAt(selectedRow, 3).toString());
                txtlevel.setText(model.getValueAt(selectedRow, 4).toString());
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

        new Administrator();
    }
}
