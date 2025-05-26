package bank.management.system;

import com.mysql.cj.protocol.Resultset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

// JFrame is used to create frame, and it will automatically import java swing
//ActionListener is used for using button on clicking
public class Login extends JFrame implements ActionListener {

    //Initialize a JLabel in global enviroment
    JLabel label1, label2, label3;
    JTextField textField2;
    JPasswordField passwordField3;

    JButton button1, button2, button3;


    /* Create a constructor with name login */
    Login(){


        //To show the name in the heading of dialog box
        super("Bank Management System");

        //we need to add image for that do the following thing
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 10, 100, 100);
        add(image);


        // for second image
        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icon/card.png"));
        Image ii2 = ii1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel iimage = new JLabel(ii3);
        iimage.setBounds(630, 350, 100, 100);
        add(iimage);


        // now we will use to show text on our frame with the help of JLabel
        //This should be made before background image
        label1 = new JLabel("WELCOME TO ATM");
        label1.setForeground(Color.white);
        label1.setFont(new Font("AvantGarde", Font.BOLD, 38));
        label1.setBounds(230, 125,450,40);
        add(label1);


        //Now for card number label
        label2 = new JLabel("Card No: ");
        label2.setFont(new Font("Ralway",Font.BOLD, 28));
        label2.setForeground(Color.white);
        label2.setBounds(150, 190, 375,30);
        add(label2);


        // Now to add textfield infront of card no
        textField2 = new JTextField(15);
        textField2.setBounds(325,190,230,30);
        textField2.setFont(new Font("Arial",Font.BOLD,14));
        add(textField2);





        // Now for pin
        label3 = new JLabel("PIN: ");
        label3.setFont(new Font("Ralway",Font.BOLD, 28));
        label3.setForeground(Color.white);
        label3.setBounds(150, 250, 375,30);
        add(label3);

        // Now for password field
        passwordField3 = new JPasswordField(15);
        passwordField3.setBounds(325,250,230,30);
        passwordField3.setFont(new Font("Arial",Font.BOLD,14));
        add(passwordField3);


        // To add button for sign in
        button1 = new JButton("SIGN IN");
        button1.setFont(new Font("Arial",Font.BOLD,14));
        button1.setForeground(Color.white);
        button1.setBackground(Color.BLACK);
        button1.setBounds(300,300,100,30);
        button1.addActionListener(this);
        add(button1);


        // To add button for clear
        button2 = new JButton("CLEAR");
        button2.setFont(new Font("Arial",Font.BOLD,14));
        button2.setForeground(Color.white);
        button2.setBackground(Color.BLACK);
        button2.setBounds(430,300,100,30);
        button2.addActionListener(this);
        add(button2);



        // for add button sign up
        button3 = new JButton("SIGN UP");
        button3.setFont(new Font("Arial",Font.BOLD,14));
        button3.setForeground(Color.white);
        button3.setBackground(Color.BLACK);
        button3.setBounds(300,350,230,30);
        button3.addActionListener(this);
        add(button3);



        //now to make background image
        ImageIcon iii1 = new ImageIcon(ClassLoader.getSystemResource("icon/backbg.png"));
        Image iii2 = iii1.getImage().getScaledInstance(850, 480, Image.SCALE_DEFAULT);
        ImageIcon iii3 = new ImageIcon(iii2);
        JLabel iiimage = new JLabel(iii3);
        iiimage.setBounds(0, 0, 850, 480);
        add(iiimage);




        setLayout(null);
        //Size of frame
        setSize(850,480);

        //shift 450 from left and 200 from top the frame
        setLocation(450, 200);

        //this is used to remove the minimize cross button from top of application
//        setUndecorated(true);

        //To show Frame
        setVisible(true);


    }

    //this override is used to stqart actionlisterner as bydefault it will not run
    @Override
    public void actionPerformed(ActionEvent e){
        try{
            if(e.getSource() == button1){
                Con c = new Con();
                String cardno = textField2.getText();
                String pin = passwordField3.getText();
                String q = "select * from login where card_number = '"+cardno+"' and pin ='"+pin+"'";
                ResultSet resultSet = c.statement.executeQuery(q);
                if (resultSet.next()){
                    setVisible(false);
                    new Main_Class(pin);
                }else {
                    JOptionPane.showMessageDialog(null,"Incoorect Card Number or PIN");
                }

            } else if (e.getSource() == button2) {
                textField2.setText("");
                passwordField3.setText("");

            } else if (e.getSource() == button3) {
                new Signup();
                setVisible(false);
            }
        }catch (Exception E){
            E.printStackTrace();

        }

    }
    public static void main(String[] args){
        // this is the object
        new Login();

    }

}
