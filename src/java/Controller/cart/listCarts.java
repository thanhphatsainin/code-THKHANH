/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.cart;

import Dao1.CartDAO;
import Dao1.ProductCartDAO;
import Dao1.ProductDAO;
import Model.Cart;
import Model.ProCart;
import Model.Product;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;
/**
 *
 * @author ADMIN
 */
public class listCarts extends HttpServlet {

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
        
        
        String prid = request.getParameter("productId");
        
        ProductCartDAO procartDAO = new ProductCartDAO();
        ProCart proCart = new ProCart();
        List<ProCart> list = new ArrayList<ProCart>();
        list = procartDAO.getListProCartByUser(name);
        request.setAttribute("listCart", list);
        long sum = 0;
            for (int i = 0; i < list.size(); i++) {
                ProCart proCart1 = list.get(i);
                sum += proCart1.getAmount() * proCart1.getProduct().getPrice();
            }
            request.setAttribute("total", sum);
        RequestDispatcher view = request.getRequestDispatcher("/view/client/giohang.jsp");
        view.forward(request, response);
//        if (name == null) {
//            RequestDispatcher view = request.getRequestDispatcher("/view/client/login.jsp");
//            view.forward(request, response);
//        } else if (name != null) {
//            
//            ProCart procart = new ProCart();
//            ProductCartDAO daoProCart = new ProductCartDAO();
//            
//            Cart cart = new Cart();
//            CartDAO daoCart = new CartDAO();
//            cart=daoCart.getCartByUser(name);
//            procart.setCart(cart);
//
//            Product product = new Product();
//            ProductDAO daoProduct = new ProductDAO();
//
//            product = daoProduct.getProductById(Integer.parseInt(prid));
//            procart.setProduct(product);
//            
//            ProCart pro=new ProCart();
//            pro = daoProCart.getProCartByProductId(Integer.parseInt(prid), name);
//            if (pro.getAmount() >= 1) {
//                procart.setId(pro.getId());
//                procart.setAmount(pro.getAmount() + 1);
//                daoProCart.editProCartByProductId(procart);
//            } else {
//                procart.setAmount(1);
//                daoProCart.addProCart(procart);
//            }
//
//            
//            List<ProCart> listProCart = new ArrayList<ProCart>();
////            ProductCartDAO daoProCart1 = new ProductCartDAO();
//
//            listProCart = daoProCart.getListProCartByUser(name);
//            request.setAttribute("listCart", listProCart);
//            
//            Cart cart1=new Cart();
//
//            cart1.setListProCarts(listProCart);
//            long sum = 0;
//            for (int i = 0; i < listProCart.size(); i++) {
//                ProCart proCart = listProCart.get(i);
//                sum += proCart.getAmount() * proCart.getProduct().getPrice();
//            }
//            request.setAttribute("total", sum);
//            RequestDispatcher view = request.getRequestDispatcher("/view/client/giohang.jsp");
//            view.forward(request, response);
//        }
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
