package hotelmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame implements ActionListener {
    JButton newCustomer;

    Reception(){


        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        newCustomer=new JButton("New Customer Form");
        newCustomer.setBounds(10,30,200,30);
        newCustomer.setBackground(Color.BLACK);
        newCustomer.setOpaque(true);
        newCustomer.setForeground(Color.WHITE);
        newCustomer.setBorderPainted(false);
        newCustomer.addActionListener(this);
        add(newCustomer);

        JButton rooms=new JButton("Rooms");
        rooms.setBounds(10,70,200,30);
        rooms.setBackground(Color.BLACK);
        rooms.setOpaque(true);
        rooms.setForeground(Color.WHITE);
        rooms.setBorderPainted(false);
        rooms.addActionListener(this);
        add(rooms);

        JButton department=new JButton("Department");
        department.setBounds(10,110,200,30);
        department.setBackground(Color.BLACK);
        department.setOpaque(true);
        department.setForeground(Color.WHITE);
        department.setBorderPainted(false);
        department.addActionListener(this);
        add(department);

        JButton allEmployee=new JButton("All Employee");
        allEmployee.setBounds(10,150,200,30);
        allEmployee.setBackground(Color.BLACK);
        allEmployee.setOpaque(true);
        allEmployee.setForeground(Color.WHITE);
        allEmployee.setBorderPainted(false);
        allEmployee.addActionListener(this);
        add(allEmployee);

        JButton customer=new JButton("Customer Info");
        customer.setBounds(10,190,200,30);
        customer.setBackground(Color.BLACK);
        customer.setOpaque(true);
        customer.setForeground(Color.WHITE);
        customer.setBorderPainted(false);
        customer.addActionListener(this);
        add(customer);

        JButton managerInfo=new JButton("Manager Info");
        managerInfo.setBounds(10,230,200,30);
        managerInfo.setBackground(Color.BLACK);
        managerInfo.setOpaque(true);
        managerInfo.setForeground(Color.WHITE);
        managerInfo.setBorderPainted(false);
        managerInfo.addActionListener(this);
        add(managerInfo);

        JButton checkout=new JButton("Checkout");
        checkout.setBounds(10,270,200,30);
        checkout.setBackground(Color.BLACK);
        checkout.setOpaque(true);
        checkout.setForeground(Color.WHITE);
        checkout.setBorderPainted(false);
        checkout.addActionListener(this);
        add(checkout);

        JButton update=new JButton("Update Status");
        update.setBounds(10,310,200,30);
        update.setBackground(Color.BLACK);
        update.setOpaque(true);
        update.setForeground(Color.WHITE);
        update.setBorderPainted(false);
        update.addActionListener(this);
        add(update);

        JButton roomStatus=new JButton("Update Room Status");
        roomStatus.setBounds(10,350,200,30);
        roomStatus.setBackground(Color.BLACK);
        roomStatus.setOpaque(true);
        roomStatus.setForeground(Color.WHITE);
        roomStatus.setBorderPainted(false);
        roomStatus.addActionListener(this);
        add(roomStatus);

        JButton pickup=new JButton("Pick-up Service");
        pickup.setBounds(10,390,200,30);
        pickup.setBackground(Color.BLACK);
        pickup.setOpaque(true);
        pickup.setForeground(Color.WHITE);
        pickup.setBorderPainted(false);
        pickup.addActionListener(this);
        add(pickup);

        JButton searchRoom=new JButton("Search Room");
        searchRoom.setBounds(10,430,200,30);
        searchRoom.setBackground(Color.BLACK);
        searchRoom.setOpaque(true);
        searchRoom.setForeground(Color.WHITE);
        searchRoom.setBorderPainted(false);
        searchRoom.addActionListener(this);
        add(searchRoom);

        JButton logout=new JButton("Logout");
        logout.setBounds(10,470,200,30);
        logout.setBackground(Color.BLACK);
        logout.setOpaque(true);
        logout.setForeground(Color.WHITE);
        logout.setBorderPainted(false);
        logout.addActionListener(this);
        add(logout);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        JLabel image =new JLabel(i1);
        image.setBounds(250,30,500,470);
        add(image);




        setBounds(350,200,800,570);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==newCustomer){
            setVisible(false);
            new AddCustomer();
        } else if (ae.getActionCommand().equals("Rooms")) { // Similarly, for other buttons
            setVisible(false);
             new Room();
        } else if (ae.getActionCommand().equals("Department")) { // And for logout
            setVisible(false);
            new Department();
        } else if (ae.getActionCommand().equals("All Employee")) { // And for logout
            setVisible(false);
            new EmployeeInfo();
        } else if (ae.getActionCommand().equals("Manager Info")) { // And for logout
            setVisible(false);
            new ManagerInfo();
        } else if (ae.getActionCommand().equals("Customer Info")) {
            setVisible(false);
            new CustomerInfo();

        } else if (ae.getActionCommand().equals("Search Room")) {
            setVisible(false);
            new SearchRoom();

        } else if (ae.getActionCommand().equals("Update Status")) {
            setVisible(false);
            new UpdateCheck();

        } else if (ae.getActionCommand().equals("Update Room Status")) {
            setVisible(false);
            new UpdateRoom();

        } else if (ae.getActionCommand().equals("Pick-up Service")) {
            setVisible(false);
            new Pickup();

        }else if (ae.getActionCommand().equals("Checkout")){
            setVisible(false);
            new Checkout();
        }


    }
    public static void main (String[]args){
        new Reception();
    }
}
