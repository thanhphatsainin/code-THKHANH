/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao1;



import Model.Article;
import Model.Cart;
import Model.Order;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */



public class OrderDAO extends DAO {
    
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public OrderDAO() {
        super();
    }


    public Order getOrderById(int key) {
    	Order order = new Order();
        String sql = "SELECT * from `order` where id = ?"; 
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, key);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                order.setId(rs.getInt("id"));
                Cart cart = new Cart();
                CartDAO cartDAO = new CartDAO();
                cart = cartDAO.getCartById(rs.getInt("cartId"));
                order.setCart(cart);
                order.setDateOder(rs.getDate("dateOrder"));
                order.setTotal(cart.getTotal());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return order;
    }
 
    public ArrayList<Order> getAllOrder() {
        ArrayList<Order> result = new ArrayList<Order>();
        //String sql = "SELECT * FROM article";
        String sql = "SELECT * from `order`"; 
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getInt("id"));
                Cart cart = new Cart();
                CartDAO cartDAO = new CartDAO();
                cart = cartDAO.getCartById(rs.getInt("cartId"));
                order.setCart(cart);
                order.setDateOder(rs.getDate("dateOrder"));
                order.setTotal(cart.getTotal());
                result.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    


    public void addOrder(Order Order) {
        String sql = "INSERT INTO `order`(cartId, dateOrder) VALUES(?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, Order.getCart().getId());
            ps.setString(2, sdf.format(Order.getDateOder()));
            
            ps.executeUpdate();

            //get id of the new inserted Order
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                Order.setId(generatedKeys.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * update the @Order
     *
     * @param Order
     */
    public void editOrder(Order Order) {
        String sql = "UPDATE `order` SET cartId=?, dateOrder=? WHERE id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, Order.getCart().getId());
            ps.setString(2, sdf.format(Order.getDateOder()));
            ps.setInt(3, Order.getId());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * delete the Order whose id is @id
     *
     * @param id
     */
    public void deleteOrder(int id) {
        //String sql = "DELETE order, product FROM order, product WHERE order.id = product.orderId and order.id=?"; //sai
        String sql1  ="Delete from `order` where id =?;";
        try {
            // sql1
            PreparedStatement ps1 = con.prepareStatement(sql1);
            ps1.setInt(1, id);
            ps1.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Order getOrderByCartID(int key){
        Order order = new Order();
        String sql = "SELECT * from `order` where cartId = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, key);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                order.setId(rs.getInt("id"));
                Cart cart = new Cart();
                CartDAO cartDAO = new CartDAO();
                cart = cartDAO.getCartById(rs.getInt("cartId"));
                order.setCart(cart);
                order.setDateOder(rs.getDate("dateOrder"));
                order.setTotal(cart.getTotal());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return order;
    }

}

