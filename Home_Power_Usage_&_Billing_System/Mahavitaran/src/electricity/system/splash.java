package electricity.system;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class splash extends JFrame{
     public splash(){
        super("Mahavitaran");
       ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icon/images.jpg"));
       Image image_1=imageIcon.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
       ImageIcon imageIcon_2=new ImageIcon(image_1);
       JLabel imageLabel=new JLabel(imageIcon_2);
        add(imageLabel);



        setSize(600,400);
        setLocation(400, 300);
        setVisible(true);

        try {
            Thread.sleep(2000);
            setVisible(false);
            new Login();

        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e);
        }
    }


    public static void main(String arg []){
        new splash();
        

    }
    
}
