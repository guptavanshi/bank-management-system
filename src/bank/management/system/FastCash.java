package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
       JButton Rs100,cashwithdrawal,fastcash,ministatement,pinchange,balanceenquiry,back;
       String pinnumber;
     FastCash(String pinnumber){
         this.pinnumber=pinnumber;
         setLayout(null);
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
         Image i2= i1.getImage().getScaledInstance(900,800,Image.SCALE_DEFAULT);
         ImageIcon i3=new ImageIcon(i2);
         JLabel image=new JLabel(i3);
         image.setBounds(0,0,800,680);
         add(image);
         
         JLabel text= new JLabel("SELECT WITHDRAWL AMMOUNT");
         text.setBounds(170,200,600,25);
         text.setForeground(Color.WHITE);
         text.setFont(new Font("System", Font.BOLD, 16));
         image.add(text);
         
         Rs100=new JButton("Rs 100");
         Rs100.setBounds(120,310,150,25);
         Rs100.addActionListener(this);
         image.add(Rs100);
         
         cashwithdrawal=new JButton("Rs 500");
         cashwithdrawal.setBounds(300,310,150,25);
         cashwithdrawal.addActionListener(this);
         image.add(cashwithdrawal);
         
         fastcash=new JButton("Rs 1000");
         fastcash.setBounds(120,340,150,20);
         fastcash.addActionListener(this);
         image.add(fastcash);
         
          ministatement=new JButton(" Rs 2000");
          ministatement.setBounds(300,340,150,20);
          ministatement.addActionListener(this);
          image.add( ministatement);
         
          pinchange=new JButton(" Rs 5000");
          pinchange.setBounds(120,370,150,20);
          pinchange.addActionListener(this);
          image.add( pinchange);
         
          balanceenquiry=new JButton(" Rs 10000");
          balanceenquiry.setBounds(300,370,150,20);
          balanceenquiry.addActionListener(this);
          image.add( balanceenquiry);
         
          back=new JButton(" BACK");
         back.setBounds(300,400,150,20);
          back.addActionListener(this);
          image.add( back);
         
         setSize(800,680);
         setLocation(300,0);
         setUndecorated(true);
         setVisible(true);
         
     }
     public void actionPerformed(ActionEvent ae){
         if(ae.getSource()==back ){
             setVisible(false);
             new Transactions(pinnumber).setVisible(true);
         }else{
            String amount= ((JButton)ae.getSource()).getText().substring(3).trim();
            Conn c = new Conn();
            try{
                 ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");
                int balance=0;
                while(rs.next()){
                    String transactionType = rs.getString("type");
                    int transactionAmount = Integer.parseInt(rs.getString("amount").trim());
                    System.out.println("Transaction Type: " + transactionType + ", Amount: " + transactionAmount);

                    if (transactionType.equalsIgnoreCase("Deposit")) {
                        balance += transactionAmount;
                    } else if (transactionType.equalsIgnoreCase("Withdrawal")) {
                        balance -= transactionAmount;
                    }
                }
                System.out.println("Current Balance: " + balance);
                if(ae.getSource()!=back && balance< Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                Date date=new Date();
                String query = "insert into bank values('" + pinnumber + "','" + date + "','Withdrawal','" + amount + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+ amount + " Debited Sucessfull");
                
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
                
            }catch(Exception e){
                System.out.println(e);
            }
         }
     }

public static void main(String[] args){
      new FastCash("");
}
}