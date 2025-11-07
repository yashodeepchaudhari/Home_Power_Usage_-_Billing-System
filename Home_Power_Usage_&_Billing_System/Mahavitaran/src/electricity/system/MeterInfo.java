package electricity.system;
import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

public class MeterInfo extends JFrame implements ActionListener{

    Choice meter_LocAs,meter_TypeAs,Phase_codeAs,Bill_TypeAs;
    JButton Submit;
    String Meter_No;

    public MeterInfo(String Meter_No){
        this.Meter_No=Meter_No;
        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(252,186,3));
        add(panel);

        JLabel heading =new JLabel("Meter Information");
        heading.setBounds(180,10,200,20);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(heading);

        JLabel meter_No =new JLabel("Meter No.");
        meter_No.setBounds(50,80,100,20);
        panel.add(meter_No);

        JLabel meterText =new JLabel(Meter_No);
        meterText.setBounds(180,80,100,20);
        panel.add(meterText);

        JLabel Meter_Loc =new JLabel("Meter Loction");
        Meter_Loc.setBounds(50,120,100,20);
        panel.add(Meter_Loc);

        meter_LocAs=new Choice();
        meter_LocAs.add("Outside");
        meter_LocAs.add("Inside");
        meter_LocAs.setBounds(180,120,150,20);
        panel.add(meter_LocAs);

        JLabel Meter_TypeAs =new JLabel("Meter Type");
        Meter_TypeAs.setBounds(50,160,100,20);
        panel.add(Meter_TypeAs);

        meter_TypeAs=new Choice();
        meter_TypeAs.add("Electric meter");
        meter_TypeAs.add("Solar meter");
        meter_TypeAs.add("Smart meter");
        meter_TypeAs.setBounds(180,160,150,20);
        panel.add(meter_TypeAs);

        JLabel PhaseCode =new JLabel("Phase Code");
        PhaseCode.setBounds(50,200,100,20);
        panel.add(PhaseCode);

        Phase_codeAs=new Choice();
        Phase_codeAs.add("011");
        Phase_codeAs.add("012");
        Phase_codeAs.add("013");
        Phase_codeAs.add("014");
        Phase_codeAs.setBounds(180,200,150,20);
        panel.add(Phase_codeAs);

        JLabel BillType =new JLabel("Bill Type");
        BillType.setBounds(50,240,100,20);
        panel.add(BillType);

        Bill_TypeAs=new Choice();
        Bill_TypeAs.add("House");
        Bill_TypeAs.add("Industrial");
        Bill_TypeAs.add("other");
        Bill_TypeAs.setBounds(180,240,150,20);
        panel.add(Bill_TypeAs);

        JLabel day =new JLabel("30 days Billing timr...");
        day.setBounds(50,280,100,20);
        panel.add(day);

        JLabel note =new JLabel("Note...");
        note.setBounds(50,320,100,20);
        panel.add(note);

        JLabel note1 =new JLabel("By Default bill is calculated for 30 days only...");
        note1.setBounds(220,330,200,25);
        panel.add(note1);

        Submit =new JButton("Submit");
        Submit.setBounds(120,390,100,25);
        Submit.setBackground(Color.black);
        Submit.setForeground(Color.white);
        Submit.addActionListener(this);
        panel.add(Submit);

        setLayout(new BorderLayout());
        add(panel,"Center");

        ImageIcon imageicon=new ImageIcon(ClassLoader.getSystemResource("icon/boycap.jpg"));
        Image image =imageicon.getImage().getScaledInstance(230, 200, Image.SCALE_DEFAULT);
        ImageIcon imageIcon=new ImageIcon(image);
        JLabel image1=new JLabel(imageIcon);
        add(image1,"East");



        setSize(700,500);
        setLocation(400, 200);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Submit){
            String smeterno=Meter_No;
            String smeterloc=meter_LocAs.getSelectedItem();
            String smetertype=meter_TypeAs.getSelectedItem();
            String sphase=Phase_codeAs.getSelectedItem();
            String sbilltype=Bill_TypeAs.getSelectedItem();

            try {
                database c=new database();
                String query=null;
                query="INSERT INTO MeterInfo VALUE('"+smeterno+"','"+smeterloc+"','"+smetertype+"','"+sphase+"','"+sbilltype+"')";
                c.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Added");
                setVisible(false);
                new main_class("Admin");
            } catch (Exception E) {
                E.printStackTrace();
            }

        }
       
        
    }
    

    public static void main(String[] args) {
        new MeterInfo("");
    }
}
