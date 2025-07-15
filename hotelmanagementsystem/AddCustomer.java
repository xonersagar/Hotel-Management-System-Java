package hotelmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.ResultSet;

public class AddCustomer extends JFrame implements ActionListener {

    JComboBox comboid;
    JTextField tfnumber,tfcountry,tfname,tfdeposit;
    JRadioButton rmale,rfemale;
    JButton add,back;
    JLabel checkintime;
    Choice croom;

    AddCustomer(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text =new JLabel("NEW COUSTOMER FORM");
        text.setBounds(100,20,300,30);
        text.setFont(new Font("Relway",Font.PLAIN,25));
        add(text);

        JLabel lblid =new JLabel("ID");
        lblid.setBounds(35,80,100,20);
        lblid.setFont(new Font("Relway",Font.PLAIN,20));
        add(lblid);

        String options[]={"Aadhar Card","Passport","Driving License","Voter id card","Ration card"};
        comboid=new JComboBox(options);
        comboid.setBounds(200,80,150,25);
        comboid.setBackground(Color.WHITE);
        add(comboid);

        JLabel lblnumber =new JLabel("NUMBER");
        lblnumber.setBounds(35,120,100,20);
        lblnumber.setFont(new Font("Relway",Font.PLAIN,20));
        add(lblnumber);
        tfnumber =new JTextField();
        tfnumber.setBounds(200,120,150,25);
        add(tfnumber);

        JLabel lblname =new JLabel("Name");
        lblname.setBounds(35,160,100,20);
        lblname.setFont(new Font("Relway",Font.PLAIN,20));
        add(lblname);
        tfname =new JTextField();
        tfname.setBounds(200,160,150,25);
        add(tfname);

        JLabel lblgender =new JLabel("Gender");
        lblgender.setBounds(35,200,100,20);
        lblgender.setFont(new Font("Relway",Font.PLAIN,20));
        add(lblgender);
        rmale=new JRadioButton("Male");
        rmale.setBackground(Color.WHITE);
        rmale.setBounds(200,200,70,25);
        add(rmale);

        rfemale=new JRadioButton("Female");
        rfemale.setBackground(Color.WHITE);
        rfemale.setBounds(270,200,100,25);
        add(rfemale);

        JLabel lblcountry =new JLabel("Country");
        lblcountry.setBounds(35,240,100,20);
        lblcountry.setFont(new Font("Relway",Font.PLAIN,20));
        add(lblcountry);
        tfcountry =new JTextField();
        tfcountry.setBounds(200,240,150,25);
        add(tfcountry);

        JLabel lblroom=new JLabel("Room Number");
        lblroom.setBounds(35,280,150,20);
        lblroom.setFont(new Font("Relway",Font.PLAIN,20));
        add(lblroom);

        croom =new Choice();
        try {
            Conn conn=new Conn();
            String query="select * from room where availablity ='Available'";
            ResultSet rs =conn.s.executeQuery(query);
            while (rs.next()){
                croom.add(rs.getString("roomnumber"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        croom.setBounds(200,280,150,25);
        add(croom);

        JLabel lbltime=new JLabel("Checkin time");
        lbltime.setBounds(35,320,150,20);
        lbltime.setFont(new Font("Relway",Font.PLAIN,20));
        add(lbltime);

        Date date =new Date();

        checkintime=new JLabel(""+date);
        checkintime.setBounds(200,320,170,25);
        checkintime.setFont(new Font("Relway",Font.PLAIN,13));
        add(checkintime);

        JLabel lbldeposit =new JLabel("Deposit");
        lbldeposit.setBounds(35,360,100,20);
        lbldeposit.setFont(new Font("Relway",Font.PLAIN,20));
        add(lbldeposit);
        tfdeposit=new JTextField();
        tfdeposit.setBounds(200,360,150,25);
        add(tfdeposit);

        add =new JButton("Add");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(50,410,120,30);
        add.setOpaque(true);
        add.setBorderPainted(false);
        add.addActionListener(this);
        add(add);
        back =new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(200,410,120,30);
        back.setOpaque(true);
        back.setBorderPainted(false);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2=i1.getImage().getScaledInstance(300,400,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,50,300,400);
        add(image);

        setBounds(350,200,800,550);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==add){
            String id=(String) comboid.getSelectedItem();
            String number=tfnumber.getText();
            String name=tfname.getText();
            String gender=null;
            if (rmale.isSelected()){
                gender="Male";
            } else if (rfemale.isSelected()) {
                gender="Female";

            }
            String country=tfcountry.getText();
            String room=croom.getSelectedItem();
            String time=checkintime.getText();
            String deposit=tfdeposit.getText();

            try {
                String query="insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"', '"+country+"','"+room+"', '"+time+"','"+deposit+"')";
                String query2="update room set availablity='Occupied' where roomnumber= '"+room+"' ";
                Conn conn=new Conn();
                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null,"New Customer Added Sucessfully");
                setVisible(false);
                new Reception();

            }catch (Exception e){
                e.printStackTrace();
            }

        } else if (ae.getSource()==back) {
            setVisible(false);
            new Reception();

        }

    }


    public static void main (String[]args){
        new AddCustomer();
    }
}
