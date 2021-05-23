/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.order;

import Dao1.ProductCartDAO;
import Model.ProCart;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Model.*;
import Dao1.*;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author LENOVO
 */
public class checkout extends HttpServlet {

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
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("nameUser");
        ProductCartDAO procartDAO = new ProductCartDAO();
        ProCart proCart = new ProCart();
        List<ProCart> list = new ArrayList<ProCart>();
        list = procartDAO.getListProCartByUser(name);
        User u = new User();
        UserDAO userDao= new UserDAO();
        u = userDao.getUserByUserName(name);
        
        Cart cart= new Cart();
        CartDAO cartDAO =  new CartDAO();
        cart= cartDAO.getCartByUser(name);
        Order order = new Order();
        order.setCart(cart);
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        order.setDateOder(date);
        OrderDAO orderDAO= new OrderDAO();
        orderDAO.addOrder(order);
        request.setAttribute("user", u);
        request.setAttribute("listCart", list);
        
        RequestDispatcher view = request.getRequestDispatcher("/view/client/order.jsp");
        view.forward(request, response);
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
