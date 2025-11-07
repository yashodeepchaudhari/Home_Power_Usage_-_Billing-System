package electricity.system;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.ChoiceFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Choice;

public class BillCalculator extends JFrame {

    JButton Back,Plus,calculate;
    Choice tariff,phase;
    JTextField unit;
    static int num,many,hoursPerDay;
    double power,power2;
    static void pow(int n,int m,int h){
        num=n;
        many=m;
        hoursPerDay=h;
    }
   

    public BillCalculator() {
        

        setLayout(null);
        // Set the layout of the JFrame to BorderLayout
        //setLayout(new BorderLayout());

        // Create a panel with specified height and a background color
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(70, 130, 180));
       // panel.setPreferredSize(new Dimension(0, 50)); // Width can be 0 to fill the width of the frame
       panel.setBounds(0,0,538, 50);

        // Create and position the label within the panel
        JLabel jLabel1 = new JLabel("Bill Calculator");
        jLabel1.setBounds(200, 0, 150, 50); // Adjust bounds as needed
        jLabel1.setForeground(Color.white);
        jLabel1.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(jLabel1);

        Back =new JButton();
        Back.setBounds(5,5,39,39);
        ImageIcon customerimg=new ImageIcon(ClassLoader.getSystemResource("icon/backimg.jpg"));
       Image cusImage =customerimg.getImage().getScaledInstance(39, 39, Image.SCALE_DEFAULT);
       Back.setIcon(new ImageIcon(cusImage));
       Back.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            new main_class("");
        }
        
       });
       panel.add(Back);

       
        // Add the panel to the top of the frame
        //add(panel, BorderLayout.NORTH);
        add(panel);
        JLabel jLabel2=new JLabel("<html>This Utility will help ypu in calculating required consumption and estimated bill amount for the connection</html>");
       jLabel2.setBounds(35,0, 480,180);
       add(jLabel2);

       JLabel Tariff =new JLabel("Tariff");
       Tariff.setBounds(20,130,50,50);
       Tariff.setFont(new Font("Tahoma",Font.BOLD,15));
       Tariff.setForeground(Color.GRAY);
       add(Tariff);

        tariff=new Choice();
        tariff.add("LT-l(B):Residential");
        tariff.add("LT-ll:Non Residential(Commercial)");
        tariff.add("LT-V(B:LT-Industry-General)");
        tariff.add("LT-X(B):Public Service-Other");
        tariff.setBounds(40,180,430,0);
        add(tariff);

        JLabel Phase =new JLabel("Phase");
       Phase.setBounds(20,200,50,50);
       Phase.setFont(new Font("Tahoma",Font.BOLD,15));
       Phase.setForeground(Color.GRAY);
       add(Phase);

       phase=new Choice();
        phase.add("1-Phase");
        phase.add("2-Phase");
        phase.add("3-Phase");
        phase.setBounds(40,250,430,20);
        add(phase);

        JLabel line =new JLabel("_______________________________________________________________________");
        line.setBounds(30,280,450,15);
        add(line);

        // JLabel Appliance=new JLabel("Appliance");
        // Appliance.setBounds(60,300,150,50);
        // Appliance.setBackground(Color.PINK);
        // Appliance.setOpaque(true);
        // Appliance.setHorizontalAlignment(SwingConstants.CENTER);
        // add(Appliance);

        // JLabel HowMany=new JLabel("How Many?");
        // HowMany.setBounds(200,300,180,50);
        // HowMany.setBackground(Color.PINK);
        // HowMany.setOpaque(true);
        // //HowMany.setHorizontalAlignment(SwingConstants.CENTER);
        // add(HowMany);

        // JLabel Hours=new JLabel("Hours");
        // Hours.setBounds(380,300,80,50);
        // Hours.setBackground(Color.PINK);
        // Hours.setOpaque(true);
        // Hours.setHorizontalAlignment(SwingConstants.CENTER);
        // add(Hours);


        JLabel Calhead =new JLabel("Appliance                    How many?                    Hours/day");
        Calhead.setBounds(50,310,410,50);
        Calhead.setBackground(Color.PINK);
        Calhead.setOpaque(true);
        Calhead.setHorizontalAlignment(SwingConstants.CENTER);
        add(Calhead);


        Plus=new JButton("+");
        Plus.setBounds(50,370,410,30);
        Plus.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Appliance();
            }
            
        });
        add(Plus);

        JLabel Consumption=new JLabel("Consumption");
        Consumption.setBounds(20,420,120,50);
        Consumption.setFont(new Font("Tahoma",Font.BOLD,15));
        Consumption.setForeground(Color.GRAY);
        add(Consumption);

        unit=new JTextField("unit");
        unit.setBounds(250,430,200,30);
        // unit.addActionListener(new ActionListener() {

        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //        double power=num*(hoursPerDay/1000);

        //        unit.setText(String.valueOf(power));
        //     }
            
        // });
        unit.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                 power=num*(hoursPerDay/1000.0);
                power2=power;
                unit.setText(String.valueOf(power2));
            }

            @Override
            public void focusLost(FocusEvent e) {
                // power=num*(hoursPerDay/1000.0);
                // power2=power;
                // unit.setText(String.valueOf(power2));
            }
            
        });
         add(unit);

        calculate=new JButton("Get Estimation");
        calculate.setBounds(50,500,410,40);
        calculate.setBackground(Color.BLUE);
        calculate.setForeground(Color.WHITE);
        calculate.setOpaque(true);
        calculate.setHorizontalAlignment(SwingConstants.CENTER);
        calculate.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               setVisible(false);
               new EstimatedBill(power2);
            }
            
        });
        add(calculate);


        

        

        // Frame settings
        setSize(538, 657);
        setLocation(500, 137);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        //new BillCalculator(0,0,0);
        new BillCalculator();
    }
}
