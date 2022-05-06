package Instructor;
import Courses.BIBM_Courses;
import Courses.BIT_Courses;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class Instructor extends JFrame {
    JMenuBar menuBar;

    JPanel filePanel;

    /**
     * Constructor of the class
     */
    public Instructor() {
        setTitle("Course Management System");
        setVisible(true);
        setSize(300,300);
        //setMinimumSize(new Dimension(500, 500));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setJMenuBar(getMenu());
        add(Course());
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
                JOptionPane.showMessageDialog(Course(), "It is Still in trial Version !!!", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // top level menu added inside menu bar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        return menuBar;
    }

    private JPanel Course() {
        filePanel = new JPanel(new GridLayout(2, 1));
        filePanel.setBorder(BorderFactory.createTitledBorder("Select  Course"));

        JRadioButton BIBM = new JRadioButton("BIBM");
        JRadioButton BIT = new JRadioButton("BIT");

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(BIBM);
        buttonGroup.add(BIT);
        filePanel.add(BIBM);
        filePanel.add(BIT);


        BIT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BIT bit = new BIT();
                bit.setVisible(true);

            }
        });
        BIBM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BIBM bibm = new BIBM();
                bibm.setVisible(true);
            }
        });

        return filePanel;


    }

    public static void main(String[] args) {
        new Instructor();
    }
}
