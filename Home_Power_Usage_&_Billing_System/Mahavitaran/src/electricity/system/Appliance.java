package electricity.system;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;


public class Appliance extends JFrame implements ActionListener{
    JButton fan,ac,tv;
    
    public Appliance(){

        setLayout(null);

        fan =new JButton();
        fan.setBounds(30,30,80,80);
        ImageIcon customerimg=new ImageIcon(ClassLoader.getSystemResource("icon/fanimg.jpg"));
       Image cusImage =customerimg.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);
       fan.setIcon(new ImageIcon(cusImage));
       fan.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
          
            BillCalculator.pow(30,1,20);
            new BillCalculator(); 
          
          
        }
        
       });
       add(fan);

       ac =new JButton();
        ac.setBounds(180,30,80,80);
        ImageIcon customerac=new ImageIcon(ClassLoader.getSystemResource("icon/acimg.jpg"));
       Image cusImac =customerac.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);
       ac.setIcon(new ImageIcon(cusImac));
       ac.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            BillCalculator.pow(3000,1,4);
            new BillCalculator();  
        }
        
       });
       add(ac);

       tv =new JButton();
        tv.setBounds(330,30,80,80);
        ImageIcon customertv=new ImageIcon(ClassLoader.getSystemResource("icon/tvimg.jpg"));
       Image cusImtv =customertv.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);
       tv.setIcon(new ImageIcon(cusImtv));
       tv.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            BillCalculator.pow(120,1,6);
            new BillCalculator();    
        }
        
       });
       add(tv);

       setSize(450, 300);
       setLocation(500, 137);
       
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setVisible(true);
    }


public static void main(String args[]){
    new Appliance();
}


@Override
public void actionPerformed(ActionEvent e) {
   
    throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
}

}
