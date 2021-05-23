/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Bill;

import Dao1.BillDAO;
import Dao1.OrderDAO;
import Dao1.UserDAO;
import Model.Bill;
import Model.Order;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
public class editBillAction extends HttpServlet {

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
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String id = request.getParameter("id");
        String userId = request.getParameter("userId");
        String orderId = request.getParameter("orderId");
        String code = request.getParameter("code");
        String datePay = request.getParameter("datePay");
        String status = request.getParameter("status");
        
        try (PrintWriter out = response.getWriter()) {

            Bill bill = new Bill();
            bill.setId(Integer.parseInt(id));
            User user = new User();
            UserDAO daoUser = new UserDAO();
            user = daoUser.getUserById(Integer.parseInt(userId));
            bill.setUser(user);
            Order order = new Order();
            OrderDAO daoOrder = new OrderDAO();
            order = daoOrder.getOrderById(Integer.parseInt(orderId));
            bill.setOrder(order);
            bill.setCode(code);
            Date date;
            date = sdf.parse(datePay);
            bill.setDatePay(date);
            bill.setStatus(status);
            
            BillDAO daoBill = new BillDAO();
            daoBill.editBill(bill);                  
            //request.setAttribute("listToy", list);
            String url = request.getContextPath()+"/listBill";
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(editBillAction.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(editBillAction.class.getName()).log(Level.SEVERE, null, ex);
        }
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
