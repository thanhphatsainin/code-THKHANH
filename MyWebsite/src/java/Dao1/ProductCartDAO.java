/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao1;

import Model.Cart;
import Model.ProCart;
import Model.Category;
import Model.ProCart;
import Model.Product;
import Model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class ProductCartDAO extends DAO {

    public ProductCartDAO() {
        super();
    }

    public ProCart getProCartById(int key) {
        ProCart procart = new ProCart();
        String sql = "SELECT * from procart where id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, key);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                procart.setId(rs.getInt("id"));
                Cart cart = new Cart();
                CartDAO cartDAO = new CartDAO();
                cart = cartDAO.getCartById(rs.getInt("cartId"));
                procart.setCart(cart);

                Product product = new Product();
                ProductDAO productDAO = new ProductDAO();
                product = productDAO.getProductById(rs.getInt("productId"));
                procart.setProduct(product);

                procart.setAmount(rs.getInt("amount"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return procart;
    }

    public int getCountProCartInCart(int key) {
        int count = 0;
        String sql = "SELECT count(c.id) "
                + "FROM cart c, procart pc "
                + "WHERE pc.cartId = c.id and c.id =? "
                + "GROUP BY c.id";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, key);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                count = rs.getInt("count(c.id)");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

//    public ArrayList<ProCart> getListProCartByIdCart(int key) {
//
//        ArrayList<ProCart> listProCarts = new ArrayList<ProCart>();
////        ProCart procart = new ProCart();
//
//        int count = getCountProCartInCart(key);
//
//        //for (int i = 0; i < count; i++) {
////            String sql = "SELECT c.id, c.userId, pc.id, pc.productId, pc.amount "
////                    + "FROM cart c, procart pc "
////                    + "WHERE c.id = pc.cartId and c.id=?";
//        String sql = "SELECT c.id, c.userId, pc.id, pc.productId, pc.amount "
//                + "FROM cart c, procart pc "
//                + "WHERE c.id = pc.cartId and c.id=?";
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setInt(1, key);
//            ResultSet rs = ps.executeQuery();
//
//            while (rs.next()) {
//                ProCart procart = new ProCart();
//                procart.setId(rs.getInt("pc.id"));
//                Cart cart = new Cart();
//                CartDAO cartDAO = new CartDAO();
//                cart.setId(rs.getInt("c.id"));
//                User user = new User();
//                UserDAO userDAO = new UserDAO();
//                user = userDAO.getUserById(rs.getInt("c.userId"));
//                cart.setUser(user);
//                procart.setCart(cart);
//
//                Product product = new Product();
//                ProductDAO productDAO = new ProductDAO();
//                product = productDAO.getProductById(rs.getInt("pc.productId"));
//                procart.setProduct(product);
//
//                procart.setAmount(rs.getInt("pc.amount"));
//                listProCarts.add(procart);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        //}
//
////        ArrayList<ProCart> result = new ArrayList<ProCart>();
////        ProCart procart = new ProCart();
////        String sql = "SELECT c.id, c.userId, pc.id, pc.productId, pc.amount "
////                + "FROM cart c, procart pc "
////                + "WHERE c.id = pc.cartId and c.id=?";
////        try {
////            PreparedStatement ps = con.prepareStatement(sql);
////            ps.setInt(1, key);
////            ResultSet rs = ps.executeQuery();
////
////            if (rs.next()) {
////                procart.setId(rs.getInt("pc.id"));
////                Cart cart = new Cart();
////                CartDAO cartDAO = new CartDAO();
////                cart.setId(rs.getInt("c.id"));
////                User user = new User();
////                UserDAO userDAO = new UserDAO();
////                user = userDAO.getUserById(rs.getInt("c.userId"));
////                cart.setUser(user);
////                procart.setCart(cart);
////
////                Product product = new Product();
////                ProductDAO productDAO = new ProductDAO();
////                product = productDAO.getProductById(rs.getInt("pc.productId"));
////                procart.setProduct(product);
////
////                procart.setAmount(rs.getInt("pc.amount"));
////                result.add(procart);
////            }
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
//        return listProCarts;
//    }

    public ArrayList<ProCart> getListProCartByIdCart(int key) {
        ArrayList<ProCart> result = new ArrayList<ProCart>();
        String sql = "SELECT c.id, c.userId, pc.id, pc.productId, pc.amount "
                + "FROM cart c, procart pc "
                + "WHERE c.id = pc.cartId and c.id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, key);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ProCart procart = new ProCart();
                procart.setId(rs.getInt("pc.id"));
                Cart cart = new Cart();
                CartDAO cartDAO = new CartDAO();
                cart.setId(rs.getInt("c.id"));
                User user = new User();
                UserDAO userDAO = new UserDAO();
                user = userDAO.getUserById(rs.getInt("c.userId"));
                cart.setUser(user);
                procart.setCart(cart);

                Product product = new Product();
                ProductDAO productDAO = new ProductDAO();
                product = productDAO.getProductById(rs.getInt("pc.productId"));
                procart.setProduct(product);

                procart.setAmount(rs.getInt("pc.amount"));
                result.add(procart);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<ProCart> getAllProCart() {
        ArrayList<ProCart> result = new ArrayList<ProCart>();
        //String sql = "SELECT * FROM article";
        String sql = "SELECT * from procart";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ProCart procart = new ProCart();
                procart.setId(rs.getInt("id"));
                Cart cart = new Cart();
                CartDAO cartDAO = new CartDAO();
                cart = cartDAO.getCartById(rs.getInt("cartId"));
                procart.setCart(cart);

                Product product = new Product();
                ProductDAO productDAO = new ProductDAO();
                product = productDAO.getProductById(rs.getInt("productId"));
                procart.setProduct(product);

                procart.setAmount(rs.getInt("amount"));
                result.add(procart);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public void addProCart(ProCart ProCart) {
        String sql = "INSERT INTO procart(cartId, productId, amount) VALUES(?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, ProCart.getCart().getId());
            ps.setInt(2, ProCart.getProduct().getId());
            ps.setInt(3, ProCart.getAmount());

            ps.executeUpdate();

            //get id of the new inserted ProCart
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                ProCart.setId(generatedKeys.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * update the @ProCart
     *
     * @param ProCart
     */
    public void editProCart(ProCart ProCart) {
        String sql = "UPDATE procart SET cartId=?, productId=?, amount=? WHERE id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, ProCart.getCart().getId());
            ps.setInt(2, ProCart.getProduct().getId());
            ps.setInt(3, ProCart.getAmount());
            ps.setInt(4, ProCart.getId());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * delete the ProCart whose id is @id
     *
     * @param id
     */
    public void deleteProCart(int id) {
        //String sql = "DELETE procart, product FROM procart, product WHERE procart.id = product.procartId and procart.id=?"; //sai
        String sql1 = "Delete from procart where id =?;";
        try {
            // sql1
            PreparedStatement ps1 = con.prepareStatement(sql1);
            ps1.setInt(1, id);
            ps1.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
