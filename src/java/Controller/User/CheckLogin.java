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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DELL
 */
public class CheckLogin extends HttpServlet {

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
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession sesion = request.getSession();
        try (PrintWriter out = response.getWriter()) {
            User u = new User(username, password);
            UserDAO dao = new UserDAO();
            if (dao.checkLogin(u)) {
                User newUser = new User();
                newUser = dao.getUserByUserName(username);
                if (newUser.getPosition().equalsIgnoreCase("admin")) {
                    sesion.setAttribute("nameUser", newUser.getName());
                    request.setAttribute("newUser", newUser);
                    RequestDispatcher view = request.getRequestDispatcher("/listBill");
                    view.forward(request, response);
                } else {
                    sesion.setAttribute("nameUser", newUser.getUsername());
                    sesion.setAttribute("id", newUser.getId());
                    request.setAttribute("newUser", newUser);
                    RequestDispatcher view = request.getRequestDispatcher("/listAll");
                    view.forward(request, response);
                    request.getRequestDispatcher("/view/client/header.jsp").forward(request, response);
                }
            } else {
                sesion.setAttribute("wrong", "Username or Password wrong");
                RequestDispatcher dis = request.getRequestDispatcher("/view/client/login.jsp");
                dis.forward(request, response);
            }

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
