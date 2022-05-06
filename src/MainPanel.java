import Administrator.Administrator;
import Instructor.Instructor;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Courses.Courses;

public class MainPanel extends JFrame {
    JPanel buttonPanel;
    // Reference variable for different fields, buttons, table and table model
    JButton btnStudent, btnAdministrator, btnInstructor, btnExit;

    /**
     * Constructor of the class
     */
    public MainPanel() {
        setTitle("Course Management System");
        setVisible(true);
        setSize(300,300);
        //setMinimumSize(new Dimension(700, 700));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 2));
        add(buttonUI());
        setLocationRelativeTo(null);


        btnStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(buttonUI(),"Welcome Student!!");
                Courses StudentPanel=new Courses();
                StudentPanel.setVisible(true);

            }
        });
        btnAdministrator.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(buttonUI(),"Welcome Administrator!!");
                Administrator AdministratorPanel=new Administrator();
                AdministratorPanel.setVisible(true);
            }
        });
        btnInstructor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(buttonUI(),"Welcome Instructor!!");
                Instructor InstructorPanel=new Instructor();
                InstructorPanel.setVisible(true);
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

        buttonPanel.setBorder(BorderFactory.createTitledBorder("Identify Yourself As:"));
        btnStudent = new JButton("Student");
        btnAdministrator = new JButton("Administrator");
        btnInstructor= new JButton("Instructor");
        btnExit=new JButton("Exit");
        buttonPanel.add(btnStudent);
        buttonPanel.add(btnAdministrator);
        buttonPanel.add(btnInstructor);
        buttonPanel.add(btnExit);

        return buttonPanel;
    }



    public static void main(String[] args) {
        new MainPanel();

    }}