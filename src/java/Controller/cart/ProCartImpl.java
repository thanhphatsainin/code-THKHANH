/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.cart;

import Controller.User.UserImpl;
import static Dao1.DAO.con;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.Bill;
import Model.Cart;
import Model.Order;
import Model.ProCart;
import Model.Product;
import Model.User;

/**
 *
 * @author ADMIN
 */
public class ProCartImpl extends Dao1.DAO {

    public ProCartImpl() {
        super();
    }

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
                cart.setId(rs.getInt("c.id"));
                User user = new User();
                UserImpl userImpl = new UserImpl();
                user = userImpl.getUserById(rs.getInt("c.userId"));
                cart.setUser(user);
                procart.setCart(cart);

                Product product = new Product();
                ProductImpl productImpl = new ProductImpl();
                product = productImpl.getProductById(rs.getInt("pc.productId"));
                procart.setProduct(product);

                procart.setAmount(rs.getInt("pc.amount"));
                result.add(procart);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<ProCart> getListProCartByUser(String key) {
        ArrayList<ProCart> result = new ArrayList<ProCart>();
        String sql = "SELECT * FROM \n"
                + "procart pro,cart c,user u \n"
                + "where pro.cartId=c.id and c.userId=u.id and u.name=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, key);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ProCart procart = new ProCart();
                procart.setId(rs.getInt("pro.id"));
                
                Cart cart=new Cart();
                cart.setId(rs.getInt("c.id"));
                
                User user = new User();
                UserImpl userImpl = new UserImpl();
                user = userImpl.getUserById(rs.getInt("c.userId"));
                cart.setUser(user);
                procart.setCart(cart);

                Product product = new Product();
                ProductImpl productImpl = new ProductImpl();
                product = productImpl.getProductById(rs.getInt("pro.productId"));
                procart.setProduct(product);

                procart.setAmount(rs.getInt("pro.amount"));
                result.add(procart);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public ProCart getProCartByProductId(int key1, String key2) {
        ProCart procart = new ProCart();
        String sql = "SELECT pro.id,pro.cartId,pro.productId,pro.amount FROM \n"
                + "procart pro,cart c,user u where pro.cartId=c.id \n"
                + "and c.userId=u.id and pro.productId=? and u.name=?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, key1);
            ps.setString(2, key2);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                procart.setId(rs.getInt("id"));

                Cart cart = new Cart();
                CartImpl cartImpl = new CartImpl();
                cart = cartImpl.getCartById(rs.getInt("cartId"));
                procart.setCart(cart);

                Product product = new Product();
                ProductImpl productImpl = new ProductImpl();
                product = productImpl.getProductById(rs.getInt("productId"));
                procart.setProduct(product);

                procart.setAmount(rs.getInt("amount"));
            }
        } catch (Exception e) {
        }
        return procart;
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
                CartImpl cartImpl = new CartImpl();
                cart = cartImpl.getCartById(rs.getInt("cartId"));
                procart.setCart(cart);

                Product product = new Product();
                ProductImpl productImpl = new ProductImpl();
                product = productImpl.getProductById(rs.getInt("productId"));
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

    public boolean checkProCart(int key) {
        ProCart procart = new ProCart();
        String sql = "SELECT * FROM mywebsite.procart and productId=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, key);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                procart.setId(rs.getInt("id"));

                User user = new User();
                UserImpl userImpl = new UserImpl();
                user = userImpl.getUserById(rs.getInt("userId"));

                Cart cart = new Cart();
                CartImpl cartImpl = new CartImpl();
                cart.setUser(user);
                cart = cartImpl.getCartById(rs.getInt("cartId"));
                procart.setCart(cart);

                Product product = new Product();
                ProductImpl productImpl = new ProductImpl();
                product = productImpl.getProductById(rs.getInt("productId"));
                procart.setProduct(product);

                procart.setAmount(rs.getInt("amount"));
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

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

    public void editProCartByProductId(Model.ProCart proCart) {
        String sql = "UPDATE procart SET id=?, cartId=?, amount=? WHERE productId=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, proCart.getId());
            ps.setInt(2, proCart.getCart().getId());
            ps.setInt(3, proCart.getAmount());
            ps.setInt(4, proCart.getProduct().getId());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
