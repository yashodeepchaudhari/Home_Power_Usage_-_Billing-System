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
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener{
    JTextField usernametext,passwordtext;
    Choice choice;
    JButton Login,cancel,Signup;
       public Login(){
        super("Login");
        getContentPane().setBackground(Color.WHITE);
   
      
        JLabel username=new JLabel("UserName");
        username.setBounds(300, 64, 100, 20);
        add(username);

        usernametext =new JTextField();
        usernametext.setBounds(400,60,200,30);
        add(usernametext);
        
        JLabel password=new JLabel("Password");
        password.setBounds(300, 104, 100, 20);
        add(password);

        passwordtext =new JTextField();
        passwordtext.setBounds(400,100,200,30);
        add(passwordtext);

        JLabel loginAs=new JLabel("LoginIn As");
        loginAs.setBounds(300, 140, 100, 20);
        add(loginAs);

        choice=new Choice();
        choice.add("Admin");
        choice.add("Customer");
        choice.setBounds(400,140,200,40);
        add(choice);

        Login =new JButton("Login");
        Login.setBounds(330, 180, 100, 20);
        Login.addActionListener(this);
        add(Login);

        cancel =new JButton("Cancel");
        cancel.setBounds(460, 180, 100, 20);
        cancel.addActionListener(this);
        add(cancel);

        Signup =new JButton("SignUp");
        Signup.setBounds(400, 215, 100, 20);
        Signup.addActionListener(this);
        add(Signup);
        

       ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icon/personicon1.jpg"));
       Image image_1=imageIcon.getImage().getScaledInstance(250, 225, Image.SCALE_DEFAULT);
       ImageIcon imageIcon_2=new ImageIcon(image_1);
       JLabel imageLabel=new JLabel(imageIcon_2);
       imageLabel.setBounds(0,0,250,250);
       add(imageLabel);



        setSize(640,300);
        setLocation(400, 300);
        setLayout(null);
        setVisible(true);
    
}

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==cancel){
            setVisible(false);
            System.exit(0);
        }
        else if(e.getSource()==Login){
            String susername=usernametext.getText();
            String spassword=passwordtext.getText();
            String user=choice.getSelectedItem();

            try {
                database c=new database();
                String query="SELECT * FROM Signup WHERE username='"+susername+"' AND password='"+spassword+"' AND user_type='"+user+"'";
                ResultSet resultSet=c.statement.executeQuery(query);
                if(resultSet.next()){
                    setVisible(false);
                    new main_class(user);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Invalid details");
                }
            } catch (Exception E) {
               E.printStackTrace();
            }
            
        }
        else if(e.getSource()==Signup){
            setVisible(false);
            new signup();
        }
        
    }

    public static void main(String arg[]){
        new Login();
    }
}
