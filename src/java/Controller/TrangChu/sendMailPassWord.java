/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.TrangChu;

import Dao1.UserDAO;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
public class sendMailPassWord extends HttpServlet {

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
        String mailCus = request.getParameter("mailCus");
        try (PrintWriter out = response.getWriter()) {
            UserDAO userDAO = new UserDAO();
            User user = new  User();
            user = userDAO.getUserByEmail(mailCus);
            String to = request.getParameter("mailCus");
            String subject = "ENOVAL";
            String message = "Tai khoan va mat khau cua ban la " + user.getUsername() + " - " + user.getPassword()+ "\nLink sua mk :  \n" + "http://localhost:39639/editPassword?userId="+user.getId();
            String username = "nampro101099@gmail.com";
            String pass = "01685025249bomay";
            SendMailKhuyenMai sendMailKhuyenMai = new SendMailKhuyenMai();
            sendMailKhuyenMai.send(to, subject, message, username, pass);
            out.println("Mail send successfully");

            //request.setAttribute("listToy", list);
            String url = request.getContextPath() + "/view/client/login.jsp";
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
