package electricity.system;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Newcustomer extends JFrame implements ActionListener{
    JLabel heading,customerName,meter_No,Address,City,State,Email,Phone,meterText;
    TextField nameText,AddressText,CityText,StateText,EmailText,PhoneText;
    JButton next,cancel;


    public Newcustomer() {
        super("New Customer");
        getContentPane().setBackground(Color.white);

        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(252,186,3));
        add(panel);

        heading =new JLabel("New Customer");
        heading.setBounds(180,10,200,20);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(heading);

        customerName =new JLabel("New Customer");
        customerName.setBounds(50,80,100,20);
        panel.add(customerName);

        nameText=new TextField();
        nameText.setBounds(180,80,150,20);
        panel.add(nameText);

        meter_No =new JLabel("Meter No.");
        meter_No.setBounds(50,120,100,20);
        panel.add(meter_No);

        meterText =new JLabel();
        meterText.setBounds(180,120,150,20);
        panel.add(meterText);

        Random ran=new Random();
        Long number=ran.nextLong()%1000000;
        meterText.setText(""+Math.abs(number));

        Address =new JLabel("Address");
        Address.setBounds(50,160,100,20);
        panel.add(Address);

        AddressText=new TextField();
        AddressText.setBounds(180,160,150,20);
        panel.add(AddressText);

        State =new JLabel("State");
        State.setBounds(50,200,100,20);
        panel.add(State);

        StateText=new TextField();
        StateText.setBounds(180,200,150,20);
        panel.add(StateText);

        City =new JLabel("City");
        City.setBounds(50,240,100,20);
        panel.add(City);

        CityText=new TextField();
        CityText.setBounds(180,240,150,20);
        panel.add(CityText);

        Email =new JLabel("Email");
        Email.setBounds(50,280,100,20);
        panel.add(Email);

        EmailText=new TextField();
        EmailText.setBounds(180,280,150,20);
        panel.add(EmailText);

        Phone =new JLabel("Phone No.");
        Phone.setBounds(50,320,100,20);
        panel.add(Phone);

        PhoneText=new TextField();
        PhoneText.setBounds(180,320,150,20);
        panel.add(PhoneText);

        //button

        next =new JButton("Next");
        next.setBounds(120,390,100,25);
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.addActionListener(this);
        panel.add(next);

        cancel =new JButton("Cancel");
        cancel.setBounds(230,390,100,25);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        panel.add(cancel);

        setLayout(new BorderLayout());
        add(panel,"Center");

        ImageIcon imageicon=new ImageIcon(ClassLoader.getSystemResource("icon/boycap.jpg"));
        Image image =imageicon.getImage().getScaledInstance(230, 200, Image.SCALE_DEFAULT);
        ImageIcon imageIcon=new ImageIcon(image);
        JLabel image1=new JLabel(imageIcon);
        add(image1,"West");

        setSize(700,500);
        setLocation(400, 200);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==next){
            String sname=nameText.getText();
            String smeter=meterText.getText();
            String saddress=AddressText.getText();
            String sstate=StateText.getText();
            String scity=CityText.getText();
            String semail=EmailText.getText();
            String sphone=PhoneText.getText();

            try {
                database c=new database();
                String query_customer=null;
                query_customer="INSERT INTO NewCustomer VALUE('"+sname+"','"+smeter+"','"+saddress+"','"+sstate+"','"+scity+"','"+semail+"','"+sphone+"')";
                String query_signup=null;
                query_signup="INSERT INTO Signup VALUE('"+smeter+"','','"+sname+"','','')"; 

                c.statement.executeUpdate(query_customer);
                c.statement.executeUpdate(query_signup);

                JOptionPane.showMessageDialog(null,"Customer Details added successfully");
                setVisible(false);
                new MeterInfo(smeter);

            } catch (Exception E) {
               E.printStackTrace();
            }
        }
        else if(e.getSource()==cancel){
            setVisible(false);
            new main_class("Admin");
        }
     
        
    }


    
    public static void main(String ards[]){
        new Newcustomer();
    }

}
