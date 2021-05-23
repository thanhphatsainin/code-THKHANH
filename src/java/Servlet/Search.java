/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import entities.toy;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Web desgin by Quang
 */
public class Search extends HttpServlet {
    //private Connection conn;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/database1?autoReconnect=true&useSSL=false";
        String userName = "root";
        String password = "10101999";
        Statement st;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, userName, password);
            System.out.println("Connected!");
            String pid = request.getParameter("pid");
            
            ArrayList al = null;
            ArrayList pid_list = new ArrayList();
            String query = "select * from tbltoy where name='" + pid + "' ";
            //String query = "select * from tbltoy where name LIKE ?";
            System.out.println("query " + query);
            st = conn.createStatement();
            //ResultSet rs = st.executeQuery(query);
 
            ArrayList<toy> list = new ArrayList<>();
            PreparedStatement ps = conn.prepareStatement(query);
            //ps.setString(1, "%" + pid + "%");
            ResultSet rs = ps.executeQuery();//doc toan bo du lieu khi con thoa man
//            while (rs.next()) { 
//                toy t = new toy();
//                t.setId(rs.getString("id"));
//                t.setName(rs.getString("name"));
//                t.setPrice(rs.getString("price"));
//                t.setDescription(rs.getString("description"));
//                t.setDos(rs.getString("dos"));
//                t.setAvg(rs.getFloat("avg"));
//                t.setImage(rs.getString("image"));
//                
//                System.out.println(t.getName());
//                list.add(t);
//            }
            
            while (rs.next()) {
                al = new ArrayList();
 
//                out.println(rs.getString(1));
//                out.println(rs.getString(2));
//                out.println(rs.getString(3));
//                out.println(rs.getString(4));
                al.add(rs.getString(1));
                al.add(rs.getString(2));
                al.add(rs.getString(3));
                al.add(rs.getString(4));
                al.add(rs.getString(5));
                al.add(rs.getString(6));
                al.add(rs.getString(7));
                
 
                System.out.println("al :: " + al);
                pid_list.add(al);
            }
 
            request.setAttribute("piList", pid_list);
            //request.setAttribute("piList", list);
            RequestDispatcher view = request.getRequestDispatcher("seaView1.jsp");
            view.forward(request, response);
            conn.close();
            System.out.println("Disconnected!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
