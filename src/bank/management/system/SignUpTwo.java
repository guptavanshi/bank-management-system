
package bank.management.system;

import javax.swing.*;
import java.awt.*;

import java.awt.event.*;

public class SignUpTwo extends JFrame implements ActionListener{
    long random;
    JTextField pan,aadhar;
    JRadioButton male,female,married,unmarried,other;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    JComboBox religion,category,income,occupation,education;
    String formno;
    
    SignUpTwo(String formno){
     
      this.formno=formno;
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        
        JLabel additionalDetails=new JLabel("Page 2: Additional Details");
       additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
       additionalDetails.setBounds(270,60,400,30);
        add(additionalDetails);
        
        JLabel rel=new JLabel("Religion:");
        rel.setFont(new Font("Raleway", Font.BOLD, 20));
        rel.setBounds(100,120,100,30);
        add(rel);
        
        String valReligion[]={"Hindu","Muslim","Sikh","Christian","Other"};
        religion=new JComboBox(valReligion);
        religion.setBounds(300,120,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        
        JLabel fname=new JLabel("Category:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,160,200,30);
        add( fname);
        
        String valcategory[]={"General","OBC","Sc","ST","Other"};
        category=new JComboBox(valcategory);
        category.setBounds(300,160,400,30);
        category.setBackground(Color.WHITE);
        add(category);
        
        JLabel dob=new JLabel("Income:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,200,200,30);
        add(  dob);
        
        String incomecategory[]={"Null","<1,50,000","<2,50000","<5,00,000","upto 10,00,000"};
        income=new JComboBox(incomecategory);
        income.setBounds(300,200,400,30);
        income.setBackground(Color.WHITE);
        add(income);
        
        JLabel gender=new JLabel("Educational");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,250,200,30);
        add(  gender);
        
        JLabel email=new JLabel("Qualification:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,275,200,30);
        add(  email);
        
        String educationvalues[]={"Non Graduate","Graduate","Post Graduatation","Doctrate","Others"};
        education=new JComboBox(educationvalues);
        education.setBounds(300,270,400,30);
        education.setBackground(Color.WHITE);
        add(education);
        
        
        JLabel marital=new JLabel("Occupation:");
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(100,350,200,30);
        add(marital);
        
        String occupationvalues[]={"Salaried","Self Employed","Bussiness","Student","Retired","Other"};
        occupation=new JComboBox(occupationvalues);
        occupation.setBounds(300,350,400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
        
        
       
        JLabel address=new JLabel("PAN Number:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,400,200,30);
        add(address);
        
        pan=new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,14));
        pan.setBounds(300,400,400,30);
        add(pan);

        
        JLabel city=new JLabel("Aadhar Number:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,450,200,30);
        add(city);
        
        aadhar=new JTextField();
        aadhar.setFont(new Font("Raleway",Font.BOLD,14));
        aadhar.setBounds(300,450,400,30);
        add(aadhar);

        
        JLabel state=new JLabel("Senior Citizen:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,500,200,30);
        add(state);
        
        syes=new JRadioButton("Yes");
        syes.setBounds(300,500,80,30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno=new JRadioButton("No");
        sno.setBounds(380,500,80,30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        
       ButtonGroup seniorgroup=new ButtonGroup();
       seniorgroup.add(syes);
       seniorgroup.add(sno);
        
        JLabel pincode=new JLabel("Existing Account:");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,550,200,30);
        add(pincode);
        
        eyes=new JRadioButton("Yes");
        eyes.setBounds(300,550,80,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno=new JRadioButton("No");
        eno.setBounds(380,550,80,30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        
        ButtonGroup existinggroup=new ButtonGroup();
        existinggroup.add(eyes);
        existinggroup.add(eno);
        
        
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
        
       String rel=(String) religion.getSelectedItem();
       String scategory=(String) category.getSelectedItem();
       String sincome=(String) income.getSelectedItem();
       String seducation=(String) education.getSelectedItem();
       String soccupation=(String) occupation.getSelectedItem();
       
       String seniorcitizen=null;
       if(syes.isSelected()){
           seniorcitizen="Yes";
       }else if(sno.isSelected()){
           seniorcitizen="No";
       }
       
       String existingaccount=null;
       
       if(eyes.isSelected()){
           existingaccount="Yes";
       }else if(eno.isSelected()){
           existingaccount="No";
       }
       String span=pan.getText();
       String saadhar=aadhar.getText();
       
       
       try{
          
               Conn c=new Conn();
//               if (c.s != null) {
                String query = "INSERT INTO signuptwo VALUES ('"+formno+ "', '" + rel+ "', '" + scategory + "', '" + sincome + "', '" + seducation + "', '" +soccupation+"','"
                                + span + "', '" + saadhar+ "', '" + seniorcitizen + "', '" + existingaccount + "')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignUpThree(formno).setVisible(true);
       }catch(Exception e){
           System.out.println(e);
       }
    }
    public static void main(String[] args){
        new SignUpTwo("");
    }
}
    

