/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Bill;

import Dao1.BillDAO;
import Dao1.CategoryDAO;
import Dao1.ProductDAO;
import Dao1.UserDAO;
import Model.Bill;
import Model.Category;
import Model.Product;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
public class listBill extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            List<Bill> list = new ArrayList<Bill>();
            BillDAO dao = new BillDAO();
            list = dao.getAllBill();
//            Collections.sort(list, Product.ProRollno);
            request.setAttribute("listBill", list);
            
            List<Product> listPro = new ArrayList<Product>();
            ProductDAO dao1 = new ProductDAO();
            listPro = dao1.getAllProduct();
            request.setAttribute("listProduct", listPro);
            
            List<User> listU = new ArrayList<User>();
            UserDAO dao2 = new UserDAO();
            listU = dao2.getAllUser();
            request.setAttribute("listUser", listU);
            
            List<Category> listCategorys = new ArrayList<Category>();
            CategoryDAO dao3 = new CategoryDAO();
            listCategorys = dao3.getAllCategoryNoCategorys();
            request.setAttribute("listCategory", listCategorys);
            
            RequestDispatcher view = request.getRequestDispatcher("Bill/listBill.jsp");
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
