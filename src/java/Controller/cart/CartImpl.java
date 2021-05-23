/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.cart;

import Controller.User.MD5Hashing;
import Controller.User.UserImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.Cart;
import Model.Category;
import Model.ProCart;
import Model.User;

/**
 *
 * @author ADMIN
 */
public class CartImpl extends Dao1.DAO {

    public CartImpl() {
        super();
    }

    public Cart getCartById(int key) {
        Cart cart = new Cart();
        String sql = "SELECT c.id, c.userId "
                + "FROM cart c, user u "
                + "WHERE c.userId = u.id and c.id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, key);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                cart.setId(rs.getInt("c.id"));
                User user = new User();
                UserImpl userImpl = new UserImpl();
                user = userImpl.getUserById(rs.getInt("c.userId"));
                cart.setUser(user);

                ArrayList<ProCart> listProCarts = new ArrayList<ProCart>();
                ProCartImpl proCartImpl = new ProCartImpl();
                listProCarts = proCartImpl.getListProCartByIdCart(rs.getInt("c.id"));
                cart.setListProCarts(listProCarts);
                float sum = 0;
                for (int i = 0; i < listProCarts.size(); i++) {
                    ProCart proCart = listProCarts.get(i);
                    sum += proCart.getAmount() * proCart.getProduct().getPrice();
                }
                cart.setTotal(sum);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cart;
    }
        public Cart getCartByUser(String key) {
        Cart cart = new Cart();
        String sql = "SELECT c.id, c.userId "
                + "FROM cart c, user u "
                + "WHERE c.userId = u.id and u.name=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, key);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                cart.setId(rs.getInt("c.id"));
                User user = new User();
                UserImpl userImpl = new UserImpl();
                user = userImpl.getUserById(rs.getInt("c.userId"));
                cart.setUser(user);
            
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cart;
    }

    public void addCart(Cart cart) {
        String sql = "INSERT INTO cart(userId) VALUES(?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, cart.getUser().getId());
            ps.executeUpdate();

            //get id of the new inserted Category
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                cart.setId(generatedKeys.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     public void editCart(Model.Cart cart) {
        String sql = "UPDATE cart SET userId=? WHERE id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cart.getUser().getId());
            ps.setInt(2, cart.getId());
           
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
