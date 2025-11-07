package electricity.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class signup extends JFrame implements ActionListener{
    JTextField meter_no,employeeId,usernameSignup,NameSignup,
    passwordSignup;
    Choice choiceAccountAs;
    JButton create,backSignup;
    public signup(){
        super("Signup Page");
        getContentPane().setBackground(new Color(168,203,255));

        JLabel CreateAccount=new JLabel("Create-Account");
        CreateAccount.setBounds(0,0,100,30);
        add(CreateAccount);

        JLabel AccountAs=new JLabel("Create Account As");
        AccountAs.setBounds(30,45,130,30);
        add(AccountAs);

        choiceAccountAs=new Choice();
        choiceAccountAs.add("Admin");
        choiceAccountAs.add("Customer");
        choiceAccountAs.setBounds(170,50,150,40);
        add(choiceAccountAs);

        JLabel EmployeeId=new JLabel("Employer Id");
        EmployeeId.setBounds(30,85,150,40);
        EmployeeId.setVisible(true);
        add(EmployeeId);

        employeeId=new JTextField();
        employeeId.setBounds(170,95,150,20);
        employeeId.setVisible(true);
        add(employeeId);

        JLabel Meter_no=new JLabel("Meter number");
        Meter_no.setBounds(30,85,150,40);
        Meter_no.setVisible(false);
        add(Meter_no);

        meter_no=new JTextField();
        meter_no.setBounds(170,95,150,20);
        meter_no.setVisible(false);
        add(meter_no);

        JLabel username=new JLabel("Username");
        username.setBounds(30,125,150,40);
        add(username);

        usernameSignup=new JTextField();
        usernameSignup.setBounds(170,135,150,20);
        add(usernameSignup);

        JLabel Name=new JLabel("Name");
        Name.setBounds(30,165,150,40);
        add(Name);

        NameSignup=new JTextField("");
        NameSignup.setBounds(170,175,150,20);
        add(NameSignup);

        meter_no.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                
            }

            @Override
            public void focusLost(FocusEvent e) {
                
                try {
                    database c=new database();
                    ResultSet resultset=c.statement.executeQuery("SELECT * FROM Signup WHERE meter_no='"+meter_no.getText()+"'");
                    if(resultset.next()){
                        NameSignup.setText(resultset.getString("name"));
                    }

                    
                } catch (Exception E) {
                    E.printStackTrace();
                    
                }
            }
        });

        JLabel password=new JLabel("Password");
        password.setBounds(30,205,150,40);
        add(password);

        passwordSignup=new JTextField();
        passwordSignup.setBounds(170,215,150,20);
        add(passwordSignup);

        create=new JButton("Create");
        create.setBounds(50,265,100,30);
        create.addActionListener(this);
        add(create);

        backSignup=new JButton("Back");
        backSignup.setBounds(200,265,100,30);
        backSignup.addActionListener(this);
        add(backSignup);

        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icon/signup.jpg"));
        Image image1=imageIcon.getImage().getScaledInstance(220,220,Image.SCALE_DEFAULT);
        ImageIcon image2=new ImageIcon(image1);
        JLabel image3=new JLabel(image2);
        image3.setBounds(340,40,250,240);
        add(image3);

        choiceAccountAs.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e){
                String user=choiceAccountAs.getSelectedItem();
                if(user.equals("Customer")){
                    EmployeeId.setVisible(false);
                    NameSignup.setEditable(false);
                    employeeId.setVisible(false);
                    Meter_no.setVisible(true);
                    meter_no.setVisible(true);
                }
                else{
                    EmployeeId.setVisible(true);
                    employeeId.setVisible(true);
                    Meter_no.setVisible(false);
                    meter_no.setVisible(false);
                }

            }
        });



        setSize(600,380);
        setLocation(400, 300);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==create){
          //meter_no,employeeId,usernameSignup,NameSignup,passwordSignup;
            String sAccountAs=choiceAccountAs.getSelectedItem();
            String sMeter_no=meter_no.getText();
            //String sEmplyeeId=employeeId.getText();
            String sUsername=usernameSignup.getText();
            String sName=NameSignup.getText();
            String sPassword=passwordSignup.getText();
            try {
               database c=new database();
               String query=null;
               if(sAccountAs.equals("Admin")){
               query="INSERT INTO Signup VALUE('"+sMeter_no+"','"+sUsername+"','"+sName+"','"+sPassword+"','"+sAccountAs+"')"; 
               }else{
                query="UPDATE Signup SET username ='"+sUsername+"', password = '"+sPassword+"',user_type='"+sAccountAs+"' WHERE meter_no='"+sMeter_no+"'";
               } 
               c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"account created");
                setVisible(false);
                new Login();
            } catch (Exception E) {
                E.printStackTrace();
            }
        }
       else if(e.getSource()==backSignup){
        setVisible(false);
        new Login();
       }
    }



    public static void main(String arg[]){
        new signup();
    }
}
