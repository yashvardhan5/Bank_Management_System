package bank.management.system;

import com.sun.source.tree.WhileLoopTree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {

    String pin;
    //label2 is globaaly declared because the data we want to show will be stored in label2 and to retrive it we declared it globally
    JLabel label2;

    TextField textField;

    JButton b1,b2;

    BalanceEnquiry(String pin){

        this.pin = pin;

        // TO Add image background of atm machine
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1550,830);
        add(l3);



        //To add a heading about the page
        JLabel label1 = new JLabel("Your current balance is Rs");
        label1.setFont(new Font("System",Font.BOLD,16));
        label1.setForeground(Color.WHITE);
        label1.setBounds(430,180,700,35);
        l3.add(label1);




        //This os for another message
        label2 = new JLabel();
        label2.setFont(new Font("System",Font.BOLD,16));
        label2.setForeground(Color.WHITE);
        label2.setBounds(430,220,400,35);

        //here l3.add is done because we want this to be added on the image not on frame as frame is in background
        l3.add(label2);






        //To add a withdrawal button
        b1 = new JButton("BACK");
        b1.setBounds(700,406,150,35);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);


        int balance = 0;
        try {
            Con c =new Con();
            ResultSet resultSet = c.statement.executeQuery("Select * from bank where pin = '"+pin+"'");
            while (resultSet.next()){
                if (resultSet.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(resultSet.getString("amount"));
                }else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }


        label2.setText(""+balance);





        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Main_Class(pin);

    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}
