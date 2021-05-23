/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Bill;

import Dao1.ProductCartDAO;
import Dao1.UserDAO;
import Model.ProCart;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Model.*;
import Dao1.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.servlet.RequestDispatcher;
/**
 *
 * @author LENOVO
 */
public class payBill extends HttpServlet {

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
        
        User u = new User();
        UserDAO userDao= new UserDAO();
        u = userDao.getUserByUserName(name);
        Cart cart= new Cart();
        CartDAO cartDAO= new CartDAO();
        cart= cartDAO.getCartByUser(name);
        OrderDAO orderDao= new OrderDAO();
        Order order =new Order();
        order= orderDao.getOrderByCartID(cart.getId());
        Bill bill= new Bill();
        BillDAO billDAO= new BillDAO();
        bill.setOrder(order);
        bill.setUser(u);
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        bill.setDatePay(date);
        bill.setStatus("dang cho");
        int n = 1 + new Random().nextInt(99999);
        String s= String.valueOf(n);
        
        bill.setCode("MK"+n);
        billDAO.addBill(bill);
        RequestDispatcher view = request.getRequestDispatcher("/view/client/comp.jsp");
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
