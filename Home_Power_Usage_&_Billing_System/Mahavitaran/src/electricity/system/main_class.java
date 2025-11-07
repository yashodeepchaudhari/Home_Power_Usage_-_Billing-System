package electricity.system;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_class extends JFrame implements ActionListener{
    String Acctype;
    JMenuItem newcustomer;
    public main_class(String Acctype){
        this.Acctype=Acctype;
       setExtendedState(JFrame.MAXIMIZED_BOTH);
       ImageIcon imageicon=new ImageIcon(ClassLoader.getSystemResource("icon/mainimg.jpg"));
       Image image =imageicon.getImage().getScaledInstance(1530, 830, Image.SCALE_DEFAULT);
       ImageIcon imageIcon=new ImageIcon(image);
       JLabel image1=new JLabel(imageIcon);
       add(image1);
        //menuBar
       JMenuBar menuBar=new JMenuBar();
       setJMenuBar(menuBar);

       JMenu menu=new JMenu("Menu");
       menu.setFont(new Font("serif",Font.PLAIN,15));
       

       JMenu information=new JMenu("Information");
       information.setFont(new Font("serif",Font.PLAIN,15));
       

       JMenu User=new JMenu("User");
       User.setFont(new Font("serif",Font.PLAIN,15));


       JMenu Bill=new JMenu("Bill");
       Bill.setFont(new Font("serif",Font.PLAIN,15));


       JMenu Utility=new JMenu("Utility");
       Utility.setFont(new Font("serif",Font.PLAIN,15));
   

       JMenu exit=new JMenu("Exit");
       exit.setFont(new Font("serif",Font.PLAIN,15));


       newcustomer=new JMenuItem("New Customer");
       newcustomer.setFont(new Font("monospaced",Font.PLAIN,14));

       ImageIcon customerimg=new ImageIcon(ClassLoader.getSystemResource("icon/customerimg.jpg"));
       Image cusImage =customerimg.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
       newcustomer.setIcon(new ImageIcon(cusImage));

        newcustomer.addActionListener(this);
       menu.add(newcustomer);

       
       JMenuItem customerDetail=new JMenuItem("Customer Details");
       customerDetail.setFont(new Font("monospaced",Font.PLAIN,14));

       ImageIcon customerDetailimg=new ImageIcon(ClassLoader.getSystemResource("icon/cusdetail.jpg"));
       Image cusDetailImage =customerDetailimg.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
       customerDetail.setIcon(new ImageIcon(cusDetailImage));

       menu.add(customerDetail);

       
       JMenuItem DepositDetail=new JMenuItem("Deposit Details");
       DepositDetail.setFont(new Font("monospaced",Font.PLAIN,14));

       ImageIcon Depositimg=new ImageIcon(ClassLoader.getSystemResource("icon/depositdetail.jpg"));
       Image DepositImage =Depositimg.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
       DepositDetail.setIcon(new ImageIcon(DepositImage));

       menu.add(DepositDetail);

       
       JMenuItem AdCalculate=new JMenuItem("Calculate Bill");
       AdCalculate.setFont(new Font("monospaced",Font.PLAIN,14));

       ImageIcon AdCalculateimg=new ImageIcon(ClassLoader.getSystemResource("icon/calculatorimg.jpg"));
       Image AdCalculateImage =AdCalculateimg.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
       AdCalculate.setIcon(new ImageIcon(AdCalculateImage));
        AdCalculate.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new BillCalculator();
            }
            
        });
       menu.add(AdCalculate);

       //information
       JMenuItem UpdateInfo=new JMenuItem("Update Information");
       UpdateInfo.setFont(new Font("monospaced",Font.PLAIN,14));

       ImageIcon updateInfoimg=new ImageIcon(ClassLoader.getSystemResource("icon/updateinfo.jpg"));
       Image updateInfoImage =updateInfoimg.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
       UpdateInfo.setIcon(new ImageIcon(updateInfoImage));

       information.add(UpdateInfo);

       JMenuItem VeiwInfo=new JMenuItem("Veiw Information");
       VeiwInfo.setFont(new Font("monospaced",Font.PLAIN,14));

       ImageIcon VeiwInfoimg=new ImageIcon(ClassLoader.getSystemResource("icon/veiwinfo.jpg"));
       Image VeiwInfoImage =VeiwInfoimg.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
       VeiwInfo.setIcon(new ImageIcon(VeiwInfoImage));

       information.add(VeiwInfo);

       //User

       JMenuItem PayBill=new JMenuItem("Pay Bill");
       PayBill.setFont(new Font("monospaced",Font.PLAIN,14));

       ImageIcon PayBillimg=new ImageIcon(ClassLoader.getSystemResource("icon/paybill.jpg"));
       Image PayBillImage =PayBillimg.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
       PayBill.setIcon(new ImageIcon(PayBillImage));

       User.add(PayBill);

       JMenuItem BillDetails=new JMenuItem("Bill Details");
       BillDetails.setFont(new Font("monospaced",Font.PLAIN,14));

       ImageIcon BillDetailsimg=new ImageIcon(ClassLoader.getSystemResource("icon/billdetail.jpg"));
       Image BillDetailsImage =BillDetailsimg.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
       BillDetails.setIcon(new ImageIcon(BillDetailsImage));

       User.add(BillDetails);

       //Bill

       JMenuItem GenerateBill=new JMenuItem("Generate Bill");
       GenerateBill.setFont(new Font("monospaced",Font.PLAIN,14));

       ImageIcon GenBillimg=new ImageIcon(ClassLoader.getSystemResource("icon/genbillimg.jpg"));
       Image GenBillImage =GenBillimg.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
       GenerateBill.setIcon(new ImageIcon(GenBillImage));

       Bill.add(GenerateBill);

       //Utility

       JMenuItem Notepad=new JMenuItem("Notpad");
       Notepad.setFont(new Font("monospaced",Font.PLAIN,14));

       ImageIcon Notpadimg=new ImageIcon(ClassLoader.getSystemResource("icon/notpadimg.jpg"));
       Image NotpadImage =Notpadimg.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
       Notepad.setIcon(new ImageIcon(NotpadImage));

       Utility.add(Notepad);

       JMenuItem Calculator=new JMenuItem("Calculator");
       Calculator.setFont(new Font("monospaced",Font.PLAIN,14));

       ImageIcon calculatorimg=new ImageIcon(ClassLoader.getSystemResource("icon/calculatorimg.jpg"));
       Image calculatorImage =calculatorimg.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
       Calculator.setIcon(new ImageIcon(calculatorImage));
        Calculator.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new BillCalculator();
            }
            
        });
       Utility.add(Calculator);

       //Exit

       JMenuItem eXit=new JMenuItem("Exit");
       eXit.setFont(new Font("monospaced",Font.PLAIN,14));

       ImageIcon Exitimg=new ImageIcon(ClassLoader.getSystemResource("icon/exitimg.jpg"));
       Image ExitImage =Exitimg.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
       eXit.setIcon(new ImageIcon(ExitImage));
        eXit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Login();
            }
            
        });
       exit.add(eXit);

       if(Acctype.equals("Admin")){
        menuBar.add(menu);
       }else{
        menuBar.add(information);
        menuBar.add(User);
        menuBar.add(Bill);
       }
       menuBar.add(Utility);
       menuBar.add(exit);

        setLayout(new FlowLayout());
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==newcustomer){
            setVisible(false);
            new Newcustomer();
        }
        
    }



    public static void main(String[] args) {
        new main_class("");
    }
}
