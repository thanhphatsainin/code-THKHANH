/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.cart;

import Dao1.CartDAO;
import Dao1.OrderDAO;
import Dao1.ProductCartDAO;
import Dao1.ProductDAO;
import Model.Cart;
import Model.ProCart;
import Model.Product;
import Model.*;
import java.util.*;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ADMIN
 */
public class newServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("nameUser");
//         int id = Integer.parseInt((String) session.getAttribute("id"));
        String productId = request.getParameter("productId");
        int amount = 1;
        if (name == null) {
            RequestDispatcher view = request.getRequestDispatcher("/view/client/login.jsp");
            view.forward(request, response);
        } else if (name != null) {
            ProductCartDAO daoProCart = new ProductCartDAO();
            CartDAO cartDao = new CartDAO();
            OrderDAO orderDAO = new OrderDAO();
            if (session.getAttribute("order") == null) {
                Order order = new Order();
                Cart cart = new Cart();
                List<ProCart> list = new ArrayList<ProCart>();
                ProCart procart = new ProCart();
                Product product = new Product();
                ProductDAO proDAO = new ProductDAO();
                product = proDAO.getProductById(Integer.parseInt(productId));
                procart.setProduct(product);
                list.add(procart);
                cart.setListProCarts(list);
                order.setCart(cart);
                session.setAttribute("order", order);

                daoProCart.addProCart(procart);
                cartDao.addCart(cart);
                orderDAO.addOrder(order);
            } else {
                Order order = (Order) session.getAttribute("order");
                Cart cart = order.getCart();
                List<ProCart> list = cart.getListProCarts();
                boolean check = false;
                for (ProCart procart : list) {
                    if (procart.getProduct().getId() == Integer.parseInt(productId)) {
                        procart.setAmount(procart.getAmount() + amount);
                        check = true;
                        daoProCart.editProCartByProductId(procart);
                    }
                    
//                    daoProCart.addProCart(procart);
//                    cartDao.addCart(cart);

                }
                if (check == false) {
                    Product product = new Product();
                    ProCart procart = new ProCart();
                    ProductDAO proDAO = new ProductDAO();
                    product = proDAO.getProductById(Integer.parseInt(productId));
                    procart.setProduct(product);
                    list.add(procart);
                    daoProCart.editProCartByProductId(procart);
                }
                session.setAttribute("order", order);

            }
            RequestDispatcher view = request.getRequestDispatcher("/view/client/footer.jsp");
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
