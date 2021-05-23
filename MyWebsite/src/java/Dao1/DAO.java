/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import entities.toy;
import entities.user;

/**
 *
 * @author QuangPro99
 */
public class DAO {
	public static Connection con;
	
	public DAO(){
		if(con == null){
			String dbUrl = "jdbc:mysql://localhost:3306/btlweb?autoReconnect=true&useSSL=false";
			String dbClass = "com.mysql.jdbc.Driver";

			try {
				Class.forName(dbClass);
				con = DriverManager.getConnection (dbUrl, "root", "b17dccn104");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
