/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.User;

import Dao1.UserDAO;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.ArrayList;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.iharder.Base64;
import org.apache.commons.codec.binary.Hex;

/**
 *
 * @author DELL
 */
public class addUser extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String position = request.getParameter("position");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        
        String hash_pws = MD5Hashing.getMD5(password);

        HttpSession session = request.getSession();
        try (PrintWriter out = response.getWriter()) {
            User u = new User();
            u.setName(name);
            u.setEmail(email);
            u.setAddress(address);
            u.setPosition(position);
            u.setUsername(username);
//            u.setPassword(password);
            u.setPassword(hash_pws);
            UserDAO dao = new UserDAO();
            
            ArrayList<User> list = new ArrayList<>();
            list = dao.getAllUser();

            
            boolean check = false;
            
            for (int i = 0; i < list.size(); i++) {
                if (u.getUsername().equalsIgnoreCase(list.get(i).getUsername()) || u.getEmail().equalsIgnoreCase(list.get(i).getEmail())) {
                    session.setAttribute("wrong", "Username da ton tai!");
                    RequestDispatcher dis = request.getRequestDispatcher("/listUser");
                    dis.forward(request, response);
                }
                else{
                    check = true;
                }
            }
            
            if (check) {
                dao.addUser(u);
            }
            

            //request.setAttribute("listToy", list);
            String url = request.getContextPath() + "/listUser";
            RequestDispatcher view = request.getRequestDispatcher(url);
            view.forward(request, response);
        }
    }


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
