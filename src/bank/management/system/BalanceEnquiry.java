
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener{
    JButton back;
    String pinnumber;
    BalanceEnquiry(String pinnumber){
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(800, 730, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,800,730);
        add(image);
        
        back=new JButton("Back");
        back.setBounds(310,420,130,25);
        back.addActionListener(this);
        image.add(back);
        
       Conn conn = new Conn();
        int balance = 0;
        try {
            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");

            while (rs.next()) {
                String transactionType = rs.getString("type");
                int transactionAmount = Integer.parseInt(rs.getString("amount").trim());
                System.out.println("Transaction Type: " + transactionType + ", Amount: " + transactionAmount);

                if (transactionType.equalsIgnoreCase("Deposit")) {
                    balance += transactionAmount;
                } else if (transactionType.equalsIgnoreCase("Withdrawl")) {
                    balance -= transactionAmount;
                }
            }

        }catch(Exception e){
            System.out.print(e);
        }
        JLabel text = new JLabel("Your current Account balance is Rs " + balance);
        text.setForeground(Color.WHITE);
        text.setBounds(150,250,400,30);
        image.add(text);
        
        setSize(800,730);
        setLocation(300,0);
        setUndecorated(false);
        setVisible(true);
        }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }
    
    public static void main(String[] args){
        new BalanceEnquiry("");
    }
}
