package bank.management.system;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener {

    String pin;


    //Add buttons
    JButton b1,b2;

    //text field
    TextField textField;


    Withdrawl(String pin){


        this.pin = pin;

        //to add atm image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1550,830);
        add(l3);


        //heading of field as withdrawl
        JLabel label1 = new JLabel("MAXIMUM WITHDRAWAL IS RS.10,000");
        label1.setFont(new Font("System",Font.BOLD,16));
        label1.setForeground(Color.WHITE);
        label1.setBounds(460,180,700,35);

        //here l3.add is done because we want this to be added on the image not on frame as frame is in background
        l3.add(label1);



        //This is for another message
        JLabel label2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        label2.setFont(new Font("System",Font.BOLD,16));
        label2.setForeground(Color.WHITE);
        label2.setBounds(460,220,400,35);

        //here l3.add is done because we want this to be added on the image not on frame as frame is in background
        l3.add(label2);







        //Add textfield
        textField = new TextField();
        textField.setBackground(new Color(65,125,128));
        textField.setForeground(Color.WHITE);
        textField.setBounds(460,260,320,25);
        textField.setFont(new Font("Raleway",Font.BOLD,22));
        l3.add(textField);


        //To add a withdrawal button
        b1 = new JButton("WITHDRAW");
        b1.setBounds(700,362,150,35);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);

        //To add a Back button
        b2 = new JButton("BACK");
        b2.setBounds(700,406,150,35);
        b2.setBackground(new Color(65,125,128));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        l3.add(b2);







        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b1) {
            try {
                String amount = textField.getText();
                Date date = new Date();
                if (textField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter the Amount you want to withdraw");
                } else {
                    Con c = new Con();
                    ResultSet resultSet = c.statement.executeQuery("select * from bank where pin ='" + pin + "'");
                    int balance = 0;
                    while (resultSet.next()) {
                        if (resultSet.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(resultSet.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(resultSet.getString("amount"));
                        }
                    }

                    if (balance < Integer.parseInt(amount)) {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }

                    c.statement.executeUpdate("insert into bank values('" + pin + "', '" + date + "', 'Withdrawl', '" + amount + "')");
                    JOptionPane.showMessageDialog(null, "Rs. " + amount + "Debited Successfully");
                    setVisible(false);
                    new Main_Class(pin);

                }
            } catch (Exception E) {
                E.printStackTrace();
            }

        } else if (e.getSource()==b2) {
            setVisible(false);
            new Main_Class(pin);

        }
    }

    public static void main(String[] args) {
        new Withdrawl("");
    }
}
