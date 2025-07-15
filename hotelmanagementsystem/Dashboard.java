package hotelmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {
    Dashboard(){
        setBounds(0,0,1550,1000);
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 =i1.getImage().getScaledInstance(1550,1000,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1550,1000);
        add(image);
        JLabel text =new JLabel("THE TAJ GROUP WELCOMES YOU");
        text.setBounds(400,80,1000,50);
        text.setFont(new Font("Tahmos",Font.PLAIN,46));
        text.setForeground(Color.WHITE);
        image.add(text);

        JMenuBar ab=new JMenuBar();
        ab.setBounds(0,0,1550,30);
        image.add(ab);

        JMenu hotel=new JMenu("HOTEL MANAGEMENT");
        hotel.setForeground(Color.BLACK);
        ab.add(hotel);

        JMenuItem reception = new JMenuItem("RECEPTION");
        reception.setForeground(Color.RED);
        reception.addActionListener(this);
        hotel.add(reception);

        JMenu admin=new JMenu("ADMIN");
        admin.setForeground(Color.BLACK);
        ab.add(admin);

        JMenuItem addemployee = new JMenuItem("ADD EMPLOYEE");
        addemployee.setForeground(Color.RED);
        addemployee.addActionListener(this);
        admin.add(addemployee);


        JMenuItem addRooms = new JMenuItem("ADD ROOMS");
        addRooms.setForeground(Color.RED);
        addRooms.addActionListener(this);
        admin.add(addRooms);


        JMenuItem addDriver = new JMenuItem("ADD DRIVERS");
        addDriver.setForeground(Color.RED);
        addDriver.addActionListener(this);
        admin.add(addDriver);


        setVisible(true);



    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getActionCommand().equals("ADD EMPLOYEE")){
            new AddEmployee();
        } else if (ae.getActionCommand().equals("ADD ROOMS")){
            new AddRooms();
        } else if (ae.getActionCommand().equals("ADD DRIVERS")){
            new AddDriver();
        } else if (ae.getActionCommand().equals("RECEPTION")) {
            new Reception();

        }

    }
    public static void main(String[]args){
        new Dashboard();

    }
}
