/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao1;

import entities.LoginBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author QuangPro99
 */
public class LoginDAO {
    public boolean validate(LoginBean loginBean) throws ClassNotFoundException{
        boolean status = false;
        Class.forName("com.mysql.jdbc.Driver");
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/database1"
            +"?useUnicode=true&characterEncoding=utf8","root","10101999");
            
            PreparedStatement preparedStatement = connection.prepareStatement("select*from login where username=? and password=?");
            preparedStatement.setString(1, loginBean.getUsername());
            preparedStatement.setString(2, loginBean.getPassword());
            
            System.out.println(preparedStatement);
            
            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();
        } 
        catch (Exception e) {
            System.out.println("Sai ham LoginDAO");
            e.printStackTrace();
        }
        
        return status;
    }
    
    private void prinSQLException(SQLException ex){
        for(Throwable e:ex){
            if(e instanceof SQLException){
                e.printStackTrace(System.err);
                System.err.println("SQLState: "+((SQLException) e).getSQLState());
                System.err.println("Error Code: "+((SQLException) e).getSQLState());
                System.err.print("Messeage: "+ e.getMessage());
                
                Throwable t = ex.getCause();
                while (t != null) {                    
                    System.out.println("Cause: "+t);
                    t = t.getCause();
                }
            }
        }
    }
}
