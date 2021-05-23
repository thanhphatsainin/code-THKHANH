/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Product;

import Dao1.CategoryDAO;
import Dao1.ProductDAO;
import Model.Category;
import Model.Product;
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
public class editProductAction extends HttpServlet {

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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String id = request.getParameter("id");
        String categoryId = request.getParameter("categoryId");
        String image = request.getParameter("image");
        String name = request.getParameter("name");
        String amount = request.getParameter("amount");
        String priceInit = request.getParameter("priceInit");
        String price = request.getParameter("price");
        String desShort = request.getParameter("desShort");
        String desLong = request.getParameter("desLong");
        String dateAdd = request.getParameter("dateAdd");

        
        try (PrintWriter out = response.getWriter()) {

            Product product = new Product();
            product.setId(Integer.parseInt(id));
            Category category = new Category();
            CategoryDAO dao = new CategoryDAO();
            category = dao.getCategoryById(Integer.parseInt(categoryId));
            product.setImage(image);
            product.setName(name);
            product.setAmount(Integer.parseInt(amount));
            product.setPriceInit(Double.parseDouble(priceInit));
            product.setPrice(Double.parseDouble(price));
            product.setDesShort(desShort);
            product.setDesLong(desLong);
            Date date=sdf.parse(dateAdd);
            product.setDateAdd(date);
            product.setCategory(category);
            
            ProductDAO dao1 = new ProductDAO();
            dao1.editProduct(product);
                    
            //request.setAttribute("listToy", list);
            String url = request.getContextPath()+"/listProduct";
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
            Logger.getLogger(editProductAction.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(editProductAction.class.getName()).log(Level.SEVERE, null, ex);
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
