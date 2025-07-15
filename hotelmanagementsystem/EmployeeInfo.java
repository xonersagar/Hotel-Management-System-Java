package hotelmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;

public class EmployeeInfo extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    EmployeeInfo(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel l1=new JLabel("Name");
        l1.setBounds(0,10,100,20);
        add(l1);
        JLabel l2=new JLabel("Age");
        l2.setBounds(120,10,100,20);
        add(l2);
        JLabel l3=new JLabel("Gender");
        l3.setBounds(250,10,100,20);
        add(l3);
        JLabel l4=new JLabel("Department");
        l4.setBounds(370,10,100,20);
        add(l4);
        JLabel l7=new JLabel("Salary");
        l7.setBounds(500,10,100,20);
        add(l7);
        JLabel l5=new JLabel("Mobile Number");
        l5.setBounds(620,10,100,20);
        add(l5);
        JLabel l6=new JLabel("Email");
        l6.setBounds(750,10,100,20);
        add(l6);
        JLabel l8=new JLabel("Aadhar Number");
        l8.setBounds(870,10,100,20);
        add(l8);


        table=new JTable();
        table.setBounds(0,40,1000,400);
        add(table);
        try {
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from Employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }

        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setOpaque(true);
        back.setBorderPainted(false);
        back.setBounds(420,500,120,30);
        add(back);

        setBounds(300,200,1000,600);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();

    }
    public static void main(String[]args){
        new EmployeeInfo();

    }
}
