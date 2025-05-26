package bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signup extends JFrame implements ActionListener {


    JRadioButton r1,r2,r3,r4,r5;


    JButton next;


    //Textfield se data nikalna hai isliye globally declare karenge
    JTextField textname, textFname, textEmail, textAdd, textcity,
            textPin, textState;

    //To add date field, to run this we have to import a jar file
    JDateChooser dataChosser;


    //This random is used to generate random app.no. in the form.
    //long first will geneterate a number whose first 4 digits will be saved in string first.
    Random ran = new Random();
    long first4 = (ran.nextLong() % 9000L) + 1000L;
    String first = " " + Math.abs(first4);

    Signup(){

        super("APPLICATION FORM");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(25,10,100,100);
        add(image);

        JLabel label1 = new JLabel("APPLICATION FORM NO: " + first);
        label1.setBounds(160,20,600,40);
        label1.setFont(new Font("Raleway",Font.BOLD,38));
        add(label1);

        JLabel label2 = new JLabel(("Page 1"));
        label2.setFont(new Font("Ralway",Font.BOLD,22));
        label2.setBounds(330,70,600,30);
        add(label2);

        JLabel label3 = new JLabel("Personal Details");
        label3.setFont(new Font("Raleway",Font.BOLD,22));
        label3.setBounds(290,90,600,30);
        add(label3);




        //This is to add Name field and infront of it textfield to put entry.

        JLabel labelName = new JLabel("Name:");
        labelName.setFont(new Font("Raleway",Font.BOLD,20));
        labelName.setBounds(100,190,100,30);
        add(labelName);


        textname = new JTextField();
        textname.setFont(new Font("Raleway",Font.BOLD,14));
        textname.setBounds(300,190,400,30);
        add(textname);



        //This is to add father Name field and infront of it textfield to put entry.

        JLabel labelfName = new JLabel("Father's Name: ");
        labelfName.setFont(new Font("Raleway",Font.BOLD,20));
        labelfName.setBounds(100,240,200,30);
        add(labelfName);


        textFname = new JTextField();
        textFname.setFont(new Font("Raleway",Font.BOLD,14));
        textFname.setBounds(300,240,400,30);
        add(textFname);






        //This is to add father Name field and infront of it textfield to put entry.

        JLabel DOB = new JLabel("Date of Birth: ");
        DOB.setFont(new Font("Raleway",Font.BOLD,20));
        DOB.setBounds(100,340,200,30);
        add(DOB);


        dataChosser = new JDateChooser();
        dataChosser.setForeground(new Color(105,105,105));
        dataChosser.setBounds(300,340,400,30);
        add(dataChosser);


        JLabel labelG = new JLabel("Gender");
        labelG.setFont(new Font("Raleway",Font.BOLD,20));
        labelG.setBounds(100,290,200,30);
        add(labelG);

        //Adding of radio button in gender field
        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Raleway",Font.BOLD,14));
        r1.setBackground(new Color(222,255,228));
        r1.setBounds(300,290,60,30);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Raleway",Font.BOLD,14));
        r2.setBackground(new Color(222,255,228));
        r2.setBounds(450,290,90,30);
        add(r2);

        //grouping of 2 radio buttons
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);



        // For email adress and its text field

        JLabel labelEmail = new JLabel("Email Address: ");
        labelEmail.setFont(new Font("Raleway",Font.BOLD,20));
        labelEmail.setBounds(100,390,200,30);
        add(labelEmail);

        textEmail = new JTextField();
        textEmail.setFont(new Font("Raleway",Font.BOLD,14));
        textEmail.setBounds(300,390,400,30);
        add(textEmail);



        //For married status and its field

        JLabel labelMs = new JLabel("Married Status: ");
        labelMs.setFont(new Font("Raleway",Font.BOLD,20));
        labelMs.setBounds(100,440,200,30);
        add(labelMs);

        r3 = new JRadioButton("Married");
        r3.setFont(new Font("Raleway",Font.BOLD,14));
        r3.setBackground(new Color(222,255,228));
        r3.setBounds(300,440,100,30);
        add(r3);

        r4 = new JRadioButton("Unmarried");
        r4.setFont(new Font("Raleway",Font.BOLD,14));
        r4.setBackground(new Color(222,255,228));
        r4.setBounds(450,440,100,30);
        add(r4);

        r5 = new JRadioButton("Other");
        r5.setFont(new Font("Raleway",Font.BOLD,14));
        r5.setBackground(new Color(222,255,228));
        r5.setBounds(635,440,100,30);
        add(r5);

        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(r3);
        buttonGroup1.add(r4);
        buttonGroup1.add(r5);


        //For address and its field

        JLabel labelAdd = new JLabel("Address: ");
        labelAdd.setFont(new Font("Raleway",Font.BOLD,20));
        labelAdd.setBounds(100,490,200,30);
        add(labelAdd);

        textAdd= new JTextField();
        textAdd.setFont(new Font("Raleway",Font.BOLD,14));
        textAdd.setBounds(300,490,400,30);
        add(textAdd);


        //For city and its field

        JLabel labelcity = new JLabel("City: ");
        labelcity.setFont(new Font("Raleway",Font.BOLD,20));
        labelcity.setBounds(100,540,200,30);
        add(labelcity);

        textcity = new JTextField();
        textcity.setFont(new Font("Raleway",Font.BOLD,14));
        textcity.setBounds(300,540,400,30);
        add(textcity);

        //For pin code and its field

        JLabel labelPin = new JLabel("PIN: ");
        labelPin.setFont(new Font("Raleway",Font.BOLD,20));
        labelPin.setBounds(100,590,200,30);
        add(labelPin);

        textPin = new JTextField();
        textPin.setFont(new Font("Raleway",Font.BOLD,14));
        textPin.setBounds(300,590,400,30);
        add(textPin);



        //For state and its field

        JLabel labelState = new JLabel("State: ");
        labelState.setFont(new Font("Raleway",Font.BOLD,20));
        labelState.setBounds(100,640,200,30);
        add(labelState);

        textState = new JTextField();
        textState.setFont(new Font("Raleway",Font.BOLD,14));
        textState.setBounds(300,640,400,30);
        add(textState);



        // next is to move to next page we will use ction listener for use of buttons

        next = new JButton("Next");
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.white);
        next.setBounds(620,710,80,30);
        next.addActionListener(this);
        add(next);




        getContentPane().setBackground(new Color(222,255,228));
        setLayout(null);
        setSize(850,800);
        setLocation(360,40);
        setVisible(true);
    }


    //override is done outside constructor and becore public class


    //all the things inside actionperformed is used to put data in database
    @Override
    public void actionPerformed(ActionEvent e) {

        String formno = first;
        String name = textname.getText();
        String fname = textFname.getText();
        String DOB = ((JTextField) dataChosser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(r1.isSelected()){
            gender = "Male";
        }else if (r2.isSelected()){
            gender = "Female";
        }
        String email = textEmail.getText();
        String martial = null;
        if(r3.isSelected()){
            martial = "Married";
        } else if (r4.isSelected()) {
            martial = "Unmarried";
        } else if (r5.isSelected()) {
            martial = "Other";
        }

        String address = textAdd.getText();
        String city = textcity.getText();
        String pincode = textPin.getText();
        String state = textState.getText();

        //This given below is used to tell which data should go in which column

        try{
            if (textname.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Fill all the fields");
            } else {
                Con con1 = new Con();
                String q =" insert into signup values('"+formno+"', '"+name+"', '"+fname+"' , '"+DOB+"' , '"+gender+"' , '"+email+"' , '"+martial+"' , '"+address+"' , '"+city+"' , '"+pincode+"' , '"+state+"')";
                con1.statement.executeUpdate(q);
                new Signup2(formno);
                setVisible(false);
            }

        }catch (Exception E){
            E.printStackTrace();
        }





    }

    public static void main(String[] args){
        new Signup();

    }
}
