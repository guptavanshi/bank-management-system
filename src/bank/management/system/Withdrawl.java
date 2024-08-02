package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener{
      JTextField ammount;
      JButton withdrawl,back;
      String pinnumber;
      Withdrawl(String pinnumber){
        this.pinnumber=pinnumber;
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 750, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,800,780);
        add(image);
        
        JLabel text=new JLabel("Enter the ammount you want to withdrawl");
        text.setForeground(Color.WHITE);
        text.setBounds(150,260,400,20);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        ammount=new JTextField();
        ammount.setFont(new Font("Raleway",Font.BOLD,22));
        ammount.setBounds(150,300,280,25);
        image.add(ammount);
        
        withdrawl=new JButton("withdraw");
        withdrawl.setBounds(290,410,150,25);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
         back=new JButton("Back");
         back.setBounds(290,445,150,25);
         back.addActionListener(this);
         image.add( back);
        
        setSize(800,780);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==withdrawl){
            String number= ammount.getText();
            Date date=new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the ammount you want to withdrawl");
                
            }else{
                try{
                Conn conn=new Conn();
                String query="insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+number+"')";
                conn.s.execute(query);
                JOptionPane.showMessageDialog(null,"Rs "+ number+ "Withdrawl successfully");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }catch(Exception e){
                System.out.print(e);
            }
            }
            
            
        }else if(ae.getSource()==back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
            
        }
    }
    
    public static void main(String[] args){
        new Withdrawl("");
    }
}

