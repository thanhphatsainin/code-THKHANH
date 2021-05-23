/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.User;

import Dao1.CartDAO;
import Dao1.UserDAO;
import Model.Cart;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
public class signUpFaceBook extends HttpServlet {

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
        String address = "";
        String position = "employ";
        String username = request.getParameter("name");
        String password = "1";

        if (!name.equals("")) {
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
                    if (u.getName().equalsIgnoreCase(list.get(i).getName())) {
                        User newUser = new User();
                        newUser = dao.getUserByName(name);
                        session.setAttribute("nameUser", newUser.getUsername());
                        session.setAttribute("id", newUser.getId());
                        request.setAttribute("newUser", newUser);
                        RequestDispatcher view = request.getRequestDispatcher("/listAll");
                        view.forward(request, response);
                        request.getRequestDispatcher("/view/client/header.jsp").forward(request, response);
                    } else {
                        check = true;
                    }
                }

                if (check) {
                    dao.addUser(u);
                    Cart cart = new Cart();
                    CartDAO dAO = new CartDAO();
                    cart.setUser(u);
                    dAO.addCart(cart);

                    User newUser = new User();
                    newUser = dao.getUserByUserName(username);
                    session.setAttribute("nameUser", newUser.getUsername());
                    session.setAttribute("id", newUser.getId());
                    request.setAttribute("newUser", newUser);
                    RequestDispatcher view = request.getRequestDispatcher("/listAll");
                    view.forward(request, response);
                    request.getRequestDispatcher("/view/client/header.jsp").forward(request, response);
                }
            }

//            dao.addUser(u);
            //request.setAttribute("listToy", list);
//            String url = request.getContextPath() + "/view/client/login.jsp";
//            RequestDispatcher view = request.getRequestDispatcher(url);
//            view.forward(request, response);
        } else {
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
