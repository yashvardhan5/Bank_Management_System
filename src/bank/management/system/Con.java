package bank.management.system;

import java.sql.*;


// this is for connection of our system with the database
public class Con {
    Connection connection;

    Statement statement;
    public Con(){
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BankSystem","root","ZbTi123@987");
            statement = connection.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
