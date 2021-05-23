/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.cart;

import java.util.*;
import Dao1.CartDAO;
import Dao1.OrderDAO;
import Dao1.ProductCartDAO;
import Dao1.ProductDAO;
import Model.Cart;
import Model.Order;
import Model.ProCart;
import Model.Product;
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
public class cartServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("nameUser");
//         int id = Integer.parseInt((String) session.getAttribute("id"));
        String productId = request.getParameter("productId");
        if (name == null) {
            RequestDispatcher view = request.getRequestDispatcher("/view/client/login.jsp");
            view.forward(request, response);
        } else if (name != null) {
            ProCart procart = new ProCart();
            ProductCartDAO daoProCart = new ProductCartDAO();

            Cart cart = new Cart();
            CartDAO daoCart = new CartDAO();
            cart = daoCart.getCartByUser(name);
   //         User user = new User();
            //         UserImpl daoUser = new UserImpl();
            //          user = daoUser.getUserByName(name);
            //          cart.setUser(user);

            procart.setCart(cart);

//            Category category = new Category();
//            CategoryImpl daoCategory = new CategoryImpl();
//            category = daoCategory.getCategoryByProduct(Integer.parseInt(productId));
            Product product = new Product();
            ProductDAO daoProduct = new ProductDAO();

//            product.setCategory(category);
            product = daoProduct.getProductById(Integer.parseInt(productId));
            procart.setProduct(product);

            ProCart pro = new ProCart();
            pro = daoProCart.getProCartByProductId(Integer.parseInt(productId), name);

//            if (cart != null) {
//                List<ProCart> list = new ArrayList<ProCart>();
//                list = cart.getListProCarts();
//                for (ProCart s : list) {
//                    if (s.getProduct().getId() == product.getId()) {
//                        procart.setAmount(procart.getAmount() + 1);
//                    }
//                }
//                daoProCart.editProCartByProductId(procart);
//            }
//            else{
//                procart.setAmount(1);
//                daoProCart.addProCart(procart);
//            }

            if (pro.getAmount() >= 1) {
                procart.setId(pro.getId());
//                System.out.println(pro.getAmount());
                procart.setAmount(pro.getAmount() + 1);
                daoProCart.editProCartByProductId(procart);
            } else {
                procart.setAmount(1);
                daoProCart.addProCart(procart);
            }
            RequestDispatcher view = request.getRequestDispatcher("/view/client/trangchu.jsp");
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


// protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        HttpSession session = request.getSession();
//        String name = (String) session.getAttribute("nameUser");
////         int id = Integer.parseInt((String) session.getAttribute("id"));
//        String productId = request.getParameter("productId");
//        int amount = 1;
//        if (name == null) {
//            RequestDispatcher view = request.getRequestDispatcher("/view/client/login.jsp");
//            view.forward(request, response);
//        } else if (name != null) {
//            ProductCartDAO daoProCart = new ProductCartDAO();
//            CartDAO cartDao = new CartDAO();
//            OrderDAO orderDAO = new OrderDAO();
//            if (session.getAttribute("order") == null) {
//                Order order = new Order();
//                Cart cart = new Cart();
//                List<ProCart> list = new ArrayList<ProCart>();
//                ProCart procart = new ProCart();
//                Product product = new Product();
//                ProductDAO proDAO = new ProductDAO();
//                product = proDAO.getProductById(Integer.parseInt(productId));
//                procart.setProduct(product);
//                list.add(procart);
//                cart.setListProCarts(list);
//                order.setCart(cart);
//                session.setAttribute("order", order);
//
//                daoProCart.addProCart(procart);
//                cartDao.addCart(cart);
//                orderDAO.addOrder(order);
//            } else {
//                Order order = (Order) session.getAttribute("order");
//                Cart cart = order.getCart();
//                List<ProCart> list = cart.getListProCarts();
//                boolean check = false;
//                for (ProCart procart : list) {
//                    if (procart.getProduct().getId() == Integer.parseInt(productId)) {
//                        procart.setAmount(procart.getAmount() + amount);
//                        check = true;
//                        daoProCart.editProCartByProductId(procart);
//                    }
//                    
////                    daoProCart.addProCart(procart);
////                    cartDao.addCart(cart);
//
//                }
//                if (check == false) {
//                    Product product = new Product();
//                    ProCart procart = new ProCart();
//                    ProductDAO proDAO = new ProductDAO();
//                    product = proDAO.getProductById(Integer.parseInt(productId));
//                    procart.setProduct(product);
//                    list.add(procart);
//                    daoProCart.editProCartByProductId(procart);
//                }
//                session.setAttribute("order", order);
//
//            }
//            RequestDispatcher view = request.getRequestDispatcher("/view/client/footer.jsp");
//            view.forward(request, response);
//        }
//    }
//}