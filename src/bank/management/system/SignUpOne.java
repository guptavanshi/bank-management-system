
package bank.management.system;
 

import javax.swing.*;     
import java.awt.*;       
import java.util.*;       //Random
import com.toedter.calendar.JDateChooser;  //JDatechosser
import java.awt.event.*;  

public class SignUpOne extends JFrame implements ActionListener{
    long random;
    JTextField nameTextField,fnameTextField,emailTextField,addressTextField,cityTextField,stateTextField,pincodeTextField;
    JRadioButton male,female,married,unmarried,other;
    JButton next;
    JDateChooser dateChooser;
    
    SignUpOne(){
     
      
        setLayout(null);
        
        Random ran = new Random();
        random = Math.abs((ran.nextLong() %9000L)+1000L);
        
        
        JLabel formno = new JLabel("APPLICATION FORM NO. " + random );
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140, 10, 600, 40);
        add(formno);
        
        JLabel personalDetails=new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personalDetails.setBounds(270,60,400,30);
        add(personalDetails);
        
        JLabel name=new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100,120,100,30);
        add(name);
        
        nameTextField=new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        nameTextField.setBounds(300,120,400,30);
        add(nameTextField);
        
        
        JLabel fname=new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,160,200,30);
        add( fname);
        
        fnameTextField=new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        fnameTextField.setBounds(300,160,400,30);
        add(fnameTextField);
        
        JLabel dob=new JLabel("DOB:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,200,200,30);
        add(  dob);
        
        dateChooser=new JDateChooser();
        dateChooser.setBounds(300,200,400,30);
        dateChooser.setForeground(Color.black);
        add(dateChooser);
            
        
        JLabel gender=new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,250,200,30);
        add(  gender);
        
        male=new JRadioButton("Male");
        male.setBounds(300,250,60,30);
        male.setBackground(Color.WHITE);
        add(male);
        
        female=new JRadioButton("Female");
        female.setBounds(450,250,80,30);
        female.setBackground(Color.WHITE);
        add(female);
        
        ButtonGroup gendergroup=new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        JLabel email=new JLabel("Email Address:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,300,200,30);
        add(  email);
        
        emailTextField=new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
        emailTextField.setBounds(300,300,400,30);
        add(emailTextField);
        
        JLabel marital=new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(100,350,200,30);
        add(marital);
        
        married=new JRadioButton("Married");
        married.setBounds(300,350,80,30);
        married.setBackground(Color.WHITE);
        add(married);
        
        unmarried=new JRadioButton("Unmarried");
        unmarried.setBounds(450,350,100,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        
        other=new JRadioButton("Other");
        other.setBounds(650,350,80,30);
        other.setBackground(Color.WHITE);
        add(other);
        
        ButtonGroup maritalgroup=new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(other);
         
        JLabel address=new JLabel("Address:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,400,200,30);
        add(address);
        
        addressTextField=new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD,14));
        addressTextField.setBounds(300,400,400,30);
        add(addressTextField);

        
        JLabel city=new JLabel("City:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,450,200,30);
        add(city);
        
        cityTextField=new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
        cityTextField.setBounds(300,450,400,30);
        add(cityTextField);

        
         JLabel state=new JLabel("State:");
       state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,500,200,30);
        add(state);
        
       stateTextField=new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
        stateTextField.setBounds(300,500,400,30);
        add(stateTextField);

        
         JLabel pincode=new JLabel("Pin Code:");
         pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,550,200,30);
        add(pincode);
        
         pincodeTextField=new JTextField();
        pincodeTextField.setFont(new Font("Raleway",Font.BOLD,14));
        pincodeTextField.setBounds(300,550,400,30);
        add(pincodeTextField);
        
         next=new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,600,100,30);
        next.addActionListener(this);
        add(next);
        

        getContentPane().setBackground(Color.WHITE);
        
        setSize(800,670);
        setLocation(350,10);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
       String formno= " " + random;
       String name=nameTextField.getText();
       String fname=fnameTextField.getText();
       String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
       String gender=null;
       if(male.isSelected()){
           gender="Male";
       }else if(female.isSelected()){
           gender="Female";
       }
       String email=emailTextField.getText();
       String marital=null;
       
       if(married.isSelected()){
           marital="Married";
       }else if(unmarried.isSelected()){
           marital="Umarried";
       }else if(other.isSelected()){
           marital="Other";
       }
       String address=addressTextField.getText();
       String city=cityTextField.getText();
       String state=stateTextField.getText();
       String pincode=pincodeTextField.getText();
       
       try{
           if(name.equals("")){
               JOptionPane.showMessageDialog(null, "Name is Required");
           }else{
               Conn c=new Conn();
//               if (c.s != null) {
                String query = "INSERT INTO signUp (Formno, name, Father_name, DOB, gender, email,marital, address, city, state, pincode) VALUES ('" 
                                + formno + "', '" + name + "', '" + fname+ "', '" + dob + "', '" + gender + "', '" + email + "', '" +marital+"','"
                                + address + "', '" + city + "', '" + state + "', '" + pincode + "')";
                c.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null, "Sign Up Successful");
               
               setVisible(false);
               new SignUpTwo(formno).setVisible(true);
//            }

           }
           
       }catch(Exception e){
           System.out.println(e);
       }
    }
    
    public static void main(String args[]){
        new SignUpOne();
    }
      
}
