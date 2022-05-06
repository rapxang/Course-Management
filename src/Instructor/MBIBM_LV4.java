
package Instructor;



import com.google.protobuf.NullValue;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLOutput;

import static java.lang.Integer.parseInt;

public class MBIBM_LV4 extends JFrame {
    JMenuBar menuBar;
    JPanel dataPanel;
    JPanel buttonPanel;
    JPanel secondPanel;
    JPanel filePanel;
    // Reference variable for different fields, buttons, table and table model
    DefaultTableModel model;
    JTable table;
    MBIBM4 m;
    JTextField txtSID,txt1,txt2,txt3,txt4,txt5,txt6,JTextField1;
    ButtonGroup bgGroup;
    JCheckBox chkPrivate;
    JButton btnMark,btnResult,btnClear;



    /**
     * Constructor of the class+
     */
    public MBIBM_LV4() {
        setTitle("Course Management Sysyem");
        setVisible(true);
        setMinimumSize(new Dimension(500, 500));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setJMenuBar(getMenu());
        m=new MBIBM4();
        btnMark=new JButton("Mark ");
        btnResult=new JButton("Generate Result");

        setLayout(new GridLayout(1, 2));
        JPanel subPanel1 = new JPanel(new GridLayout(1, 1));
        subPanel1.add(secondUI());
        refreshTable();

        add(subPanel1);
        JScrollPane scrollPane = new JScrollPane(table);
        secondPanel.add(scrollPane);
        JPanel subPanel = new JPanel(new GridLayout(1, 2));
        subPanel.add(dataUI());


        add(subPanel);
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,  subPanel,subPanel1);
        add(splitPane);
        pack();
        setLocationRelativeTo(null);









        btnMark.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String StudentID=getStudentID().getText().trim();
                    int m1= Integer.parseInt(get1().getText().trim());
                    int m2= Integer.parseInt(get2().getText().trim());
                    int m3= Integer.parseInt(get3().getText().trim());
                    int m4= Integer.parseInt(get4().getText().trim());
                    int m5= Integer.parseInt(get5().getText().trim());
                    int m6= Integer.parseInt(get6().getText().trim());

                    if (StudentID.isEmpty()){
                        JOptionPane.showMessageDialog(buttonPanel,"Some of the fields are empty","Warning",JOptionPane.WARNING_MESSAGE);
                    }else {

                        m.mark(StudentID, m1, m2, m3, m4, m5, m6);
                        refreshTable();
                        // Object[] data = {StudentID, m1, m2, m3, m4, m5, m6};
                        //model.addRow(data);
                        JOptionPane.showMessageDialog(buttonPanel, "Marks successfully Added!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    }
                }catch( NumberFormatException ex ){
                    JOptionPane.showMessageDialog(buttonPanel,"Please enter your Student ID and Marks in each module or select row from tabl!","Error",JOptionPane.ERROR_MESSAGE);

                }

            }



        });
        btnResult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String StudentID = getStudentID().getText().trim();
                int m1= Integer.parseInt(get1().getText().trim());
                int m2= Integer.parseInt(get2().getText().trim());
                int m3= Integer.parseInt(get3().getText().trim());
                int m4= Integer.parseInt(get4().getText().trim());
                int m5= Integer.parseInt(get5().getText().trim());
                int m6= Integer.parseInt(get6().getText().trim());



                JOptionPane.showMessageDialog(buttonPanel, "result Generated on the Terminal", "Success", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("----------------------------------------------------------------------------\n");
                System.out.println("HERALD COLLEGE KATHMANDU");
                System.out.println("STUDENT ID:" + getStudentID().getText().trim());
                System.out.println("COURSE: BIBM");
                System.out.println("Level: Level-4/Year-I");
                System.out.println("----------------------------------------------------------------------------\n");
                System.out.println("MODULE ID        FULL MARKS       PASS MARKS         OBTAINED MARKS   \n");
                System.out.println("4IB004           100              50\t\t\t\t\t\t" + get1().getText().trim());
                System.out.println("4MK007           100              50\t\t\t\t\t\t" + get2().getText().trim());
                System.out.println("4MK006           100              50\t\t\t\t\t\t" + get3().getText().trim());
                System.out.println("4HR002           100              50\t\t\t\t\t\t" + get4().getText().trim());
                System.out.println("4AC013           100              50\t\t\t\t\t\t" + get5().getText().trim());
                System.out.println("4HR017           100              50\t\t\t\t\t\t" + get6().getText().trim());
                System.out.println("----------------------------------------------------------------------------\n");
                int i=40;
                if (m1< i ){
                    System.out.println(getStudentID().getText().trim()+": You have failed in 4IB004: Business in a Global Context\n");
                    System.out.println("We Are Sorry to Announce that Your promotion to next level is Denied!");
                }else if(m2<i){
                    System.out.println(getStudentID().getText().trim()+": You have failed in 4MK007: Principles of Marketing\n");
                    System.out.println("We Are Sorry to Announce that Your promotion to next level is Denied!");
                }else if(m3<i){
                    System.out.println(getStudentID().getText().trim()+": You have failed in 4MK006: Introduction to Brand Communication\n");
                    System.out.println("We Are Sorry to Announce that Your promotion to next level is Denied!");
                }
                else if(m4<i){
                    System.out.println(getStudentID().getText().trim()+": You have failed in  4HR002: Introduction to People at work\n");
                    System.out.println("We Are Sorry to Announce that Your promotion to next level is Denied!");
                }
                else if(m5<i){
                    System.out.println(getStudentID().getText().trim()+": You have failed in  4AC013: Financial Management\n");
                    System.out.println("We Are Sorry to Announce that Your promotion to next level is Denied!");
                }
                else if(m6<i){
                    System.out.println(getStudentID().getText().trim()+": You have failed in  4HR017: Diversity Management in a Global Context\n");
                    System.out.println("We Are Sorry to Announce that Your promotion to next level is Denied!");

                }
                else{
                    System.out.println(getStudentID().getText().trim()+" : You have passed all the modules!");
                    System.out.println("Congratulation on passing Level-4/Year-I BIBM! and best of Luck for the next Level");
                }
                System.out.println("----------------------------------------------------------------------------------");


            }

        });


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


        // top level menu added inside menu bar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        return menuBar;
    }
    public void clear(){

        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table.clearSelection();
                txtSID.setText("");
                txt1.setText("");
                txt2.setText("");
                txt3.setText("");
                txt4.setText("");
                txt5.setText("");
                txt6.setText("");

            }
        });

    }

    private JPanel dataUI() {
        dataPanel = new JPanel();
        dataPanel.setLayout(new GridBagLayout());
        dataPanel.setBorder(BorderFactory.createTitledBorder("Marking Information"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        dataPanel.add(new JLabel("Student ID"), gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        dataPanel.add(new JLabel("4IB004: Business in a Global Context"), gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        dataPanel.add(new JLabel("4MK007: Principles of Marketing"), gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        dataPanel.add(new JLabel("4MK006: Introduction to Brand Communication"), gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        dataPanel.add(new JLabel("4HR002: Introduction to People at work"), gbc);
        gbc.gridx = 0;
        gbc.gridy = 5;
        dataPanel.add(new JLabel("4AC013: Financial Management"), gbc);
        gbc.gridx = 0;
        gbc.gridy = 6;
        dataPanel.add(new JLabel("4HR017: Diversity Management in a Global Context"), gbc);
        gbc.gridx = 0;
        gbc.gridy = 7;
        dataPanel.add(btnMark,gbc);




        gbc.gridx = 1;
        gbc.gridy = 0;
        txtSID= new JTextField(20);
        dataPanel.add(txtSID, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        txt1 = new JTextField(20);
        dataPanel.add(txt1, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        txt2 = new JTextField(20);
        dataPanel.add(txt2, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        txt3 = new JTextField(20);
        dataPanel.add(txt3, gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        txt4 = new JTextField(20);
        dataPanel.add(txt4, gbc);
        gbc.gridx = 1;
        gbc.gridy = 5;
        txt5 = new JTextField(20);
        dataPanel.add(txt5, gbc);
        gbc.gridx = 1;
        gbc.gridy = 6;
        txt6 = new JTextField(20);
        dataPanel.add(txt6, gbc);
        gbc.gridx=1;
        gbc.gridy=7;
        btnResult=new JButton("Generate result");
        dataPanel.add(btnResult,gbc);


        return dataPanel;
    }





    public JTextField getStudentID() {
        return txtSID;
    }
    public JTextField get1() {
        return txt1;
    }
    public JTextField get2() {
        return txt2;
    }
    public JTextField get3() {
        return txt3;
    }
    public JTextField get4() {
        return txt4;
    }
    public JTextField get5() {
        return txt5;
    }
    public JTextField get6() {
        return txt6;
    }
    public JButton getBtnMark(){
        return btnMark;
    }




    public JCheckBox getChkPrivate() {
        return chkPrivate;
    }

    public DefaultTableModel getModel() {
        return (DefaultTableModel) getTable().getModel();
    }

    public JTable getTable() {
        return table;
    }
    private void refreshTable() {
        //removes data from JTable
        model.setRowCount(0);
        try {
            ResultSet resultSet = m.get();
            while (resultSet.next()) {
                model.addRow(new Object[]{

                        resultSet.getString("student_id"),
                        resultSet.getInt("4IB004"),
                        resultSet.getInt("4MK007"),
                        resultSet.getInt("4MK006"),
                        resultSet.getInt("4HR002"),
                        resultSet.getInt("4AC013"),
                        resultSet.getInt("4HR017"),

                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private JPanel secondUI() {
        secondPanel = new JPanel(new BorderLayout());
        secondPanel.setBorder(BorderFactory.createTitledBorder("Students Marks"));
        model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Student ID", "4IB004", "4MK007", "4MK006","4HR002","4AC013","4HR017"});
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
                txtSID.setText(model.getValueAt(selectedRow, 0).toString());
                txt1.setText(model.getValueAt(selectedRow, 1).toString());
                txt2.setText(model.getValueAt(selectedRow, 2).toString());
                txt3.setText(model.getValueAt(selectedRow, 3).toString());
                txt4.setText(model.getValueAt(selectedRow, 4).toString());
                txt5.setText(model.getValueAt(selectedRow, 5).toString());
                txt6.setText(model.getValueAt(selectedRow, 6).toString());

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

        new MBIBM_LV4();
    }
}
