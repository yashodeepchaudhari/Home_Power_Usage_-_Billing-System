package electricity.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class EstimatedBill extends JFrame{
    JButton Back;
    double bill,fc=128.0,ec=37.68,ed=28.58,fac=3.6;
     
    public EstimatedBill(double power){
        bill=fc+ec+ed+fac+power;
        DecimalFormat df = new DecimalFormat("#.##");
        String sum = df.format(bill);
        setLayout(null);

         JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(70, 130, 180));
       panel.setBounds(0,0,538, 50);

     
        JLabel jLabel1 = new JLabel("Bill Calculator");
        jLabel1.setBounds(170, 0, 150, 50); // Adjust bounds as needed
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
               new BillCalculator();
            }
            
        });
       panel.add(Back);
        add(panel);

        JLabel head =new JLabel("Estimated Bill");
       head.setBounds(0,50,450,50);
       head.setFont(new Font("Tahoma",Font.BOLD,15));
       head.setForeground(Color.GRAY);
       head.setHorizontalAlignment(SwingConstants.CENTER);
       add(head);

       JLabel Tariff =new JLabel("Tariff effective from");
       Tariff.setBounds(20,100,150,50);
       Tariff.setFont(new Font("Tahoma",Font.PLAIN,15));
       Tariff.setForeground(Color.GRAY);
       add(Tariff);

       JLabel date1 =new JLabel("01 April 2024");
       date1.setBounds(300,100,150,50);
       date1.setFont(new Font("Tahoma",Font.PLAIN,15));
       date1.setForeground(Color.black);
       add(date1);

       JLabel FAC =new JLabel("FAC for the month");
       FAC.setBounds(20,130,150,50);
       FAC.setFont(new Font("Tahoma",Font.PLAIN,15));
       FAC.setForeground(Color.GRAY);
       add(FAC);

       JLabel date2 =new JLabel("sep 2024");
       date2.setBounds(300,130,150,50);
       date2.setFont(new Font("Tahoma",Font.PLAIN,15));
       date2.setForeground(Color.black);
       add(date2);

       JLabel Calhead =new JLabel("    Particulars                                                                Amount(rs)");
       Calhead.setBounds(20,180,375,30);
       Calhead.setBackground(Color.PINK);
       Calhead.setOpaque(true);
       //Calhead.setHorizontalAlignment(SwingConstants.CENTER);
       add(Calhead);

       JLabel FC =new JLabel("Fixed Charges(FC)");
       FC.setBounds(20,220,150,50);
       FC.setFont(new Font("Tahoma",Font.PLAIN,15));
       FC.setForeground(Color.GRAY);
       add(FC);

       JLabel FCrs =new JLabel("128.0");
       FCrs.setBounds(300,220,150,50);
       FCrs.setFont(new Font("Tahoma",Font.PLAIN,15));
       FCrs.setForeground(Color.black);
       add(FCrs);

       JLabel EC =new JLabel("Energy Charges");
       EC.setBounds(20,260,150,50);
       EC.setFont(new Font("Tahoma",Font.PLAIN,15));
       EC.setForeground(Color.GRAY);
       add(EC);

       JLabel ECrs =new JLabel("37.68");
       ECrs.setBounds(300,260,150,50);
       ECrs.setFont(new Font("Tahoma",Font.PLAIN,15));
       ECrs.setForeground(Color.black);
       add(ECrs);

       JLabel ED =new JLabel("Electricity Duty(ED)");
       ED.setBounds(20,300,150,50);
       ED.setFont(new Font("Tahoma",Font.PLAIN,15));
       ED.setForeground(Color.GRAY);
       add(ED);

       JLabel EDrs =new JLabel("28.58");
       EDrs.setBounds(300,300,130,50);
       EDrs.setFont(new Font("Tahoma",Font.PLAIN,15));
       EDrs.setForeground(Color.black);
       add(EDrs);

       JLabel FAC1 =new JLabel("Fuel Ajustment Charges(FAC)");
       FAC1.setBounds(20,340,200,50);
       FAC1.setFont(new Font("Tahoma",Font.PLAIN,15));
       FAC1.setForeground(Color.GRAY);
       add(FAC1);

       JLabel FCFAC =new JLabel("3.6");
       FCFAC.setBounds(300,340,150,50);
       FCFAC.setFont(new Font("Tahoma",Font.PLAIN,15));
       FCFAC.setForeground(Color.black);
       add(FCFAC);



       JLabel total =new JLabel("    Total Estimated Bill                                                  "+sum);
       total.setBounds(20,380,375,30);
       total.setBackground(Color.PINK);
       total.setOpaque(true);
       //total.setHorizontalAlignment(SwingConstants.CENTER);
       add(total);



        setSize(450, 600);
        setLocation(500, 137);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


    public static void main(String arg[]){
        new EstimatedBill(0.0);
    }
}
