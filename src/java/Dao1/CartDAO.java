/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao1;


import Model.Cart;
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
public class CartDAO extends DAO{
    
    public CartDAO() {
        super();
    }
    
    public Cart getCartById(int key) {
    	Cart cart = new Cart();
        String sql = "SELECT c.id, c.userId " +
                    "FROM cart c, user u " +
                    "WHERE c.userId = u.id and c.id=?"; 
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, key);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                cart.setId(rs.getInt("c.id"));
                User user = new User();
                UserDAO userDAO = new UserDAO();
                user = userDAO.getUserById(rs.getInt("c.userId"));
//                user.setId(rs.getInt("c.userId"));
//                user.setName(rs.getString("u.name"));
//                user.setEmail(rs.getString("u.email"));
//                user.setAddress(rs.getString("u.address"));
//                user.setPosition(rs.getString("u.position"));
//                user.setUsername(rs.getString("u.username"));
//                user.setPassword(rs.getString("u.password"));
                cart.setUser(user);
                
                ArrayList<ProCart> listProCarts = new ArrayList<ProCart>();
                ProductCartDAO productCartDAO = new ProductCartDAO();
                listProCarts = productCartDAO.getListProCartByIdCart(rs.getInt("c.id"));
                cart.setListProCarts(listProCarts);
                float sum = 0;
                for (int i = 0; i < listProCarts.size(); i++) {
                    ProCart proCart = listProCarts.get(i);
                    sum += proCart.getAmount()*proCart.getProduct().getPrice();
                }
                cart.setTotal(sum);
                
//                Product product = new Product();
//                ProductDAO productDAO = new ProductDAO();
//                product = productDAO.getProductById(rs.getInt("pc.productId"));
//                product.setId(rs.getInt("pc.productId"));
//                //Product.setCategory.(rs.getInt("id")); 
//                Category category = new Category();
//                category.setId(rs.getInt("p.categoryId"));
//                category.setName(rs.getString("cat.name"));
//                product.setCategory(category);
//                product.setImage(rs.getString("p.image"));
//                product.setName(rs.getString("p.name"));
//                product.setAmount(rs.getInt("p.amount"));
//                product.setPriceInit(rs.getDouble("p.priceInit"));
//                product.setPrice(rs.getDouble("p.price"));
//                double price = product.getPrice();
//                product.setDesShort(rs.getString("p.desShort"));
//                product.setDesLong(rs.getString("p.desLong"));
//                product.setDateAdd(rs.getDate("p.dateAdd"));
//                double price = product.getPrice();
                
                
//                ProCart pc = new ProCart();
//                ProductCartDAO productCartDAO = new ProductCartDAO();
//                pc = productCartDAO.getProCartById(rs.getInt("pc.id"));
//                pc.setId(rs.getInt("pc.id"));
//                pc.setAmount(rs.getInt("pc.amount"));
//                int amount = pc.getAmount();
//                double price = pc.getProduct().getPrice();
//                pc.setProduct(product);
//                List<ProCart> listPC = new ArrayList<>();
//                listPC.add(pc);
//                float total =  (float)amount * (float)price;
//                cart.setTotal(total);
//                cart.setListProCarts(listPC);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cart;
    }
    
    
//    public ArrayList<ProCart> getListProCartByIdCart(int key) {
//        ArrayList<ProCart> result = new ArrayList<ProCart>();
//    	ProCart procart = new ProCart();
//        String sql = "SELECT *" +
//                    "FROM cart c, procart pc" +
//                    "WHERE pc.cartId = c.id and c.id=?"; 
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setInt(1, key);
//            ResultSet rs = ps.executeQuery();
//
//            if (rs.next()) {
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
//                result.add(procart);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
 
    public ArrayList<Cart> getAllCart() {
        ArrayList<Cart> result = new ArrayList<Cart>();
        //String sql = "SELECT * FROM article";
        String sql = "SELECT c.id, c.userId, u.name, u.email, u.address, u.position, u.username, u.password, pc.id, pc.amount, pc.productId, p.categoryId, p.image, p.name, p.amount, p.priceInit, p.price, p.desShort, p.desLong, p.dateAdd, cat.name" +
                    "FROM cart c, user u, procart pc, product p, category cat " +
                    "WHERE c.userId = u.id and pc.cartId = c.id and pc.productId = p.id and p.categoryId = cat.id"; 
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Cart cart = new Cart();
                cart.setId(rs.getInt("c.id"));
                User user = new User();
                user.setId(rs.getInt("c.userId"));
                user.setName(rs.getString("u.name"));
                user.setEmail(rs.getString("u.email"));
                user.setAddress(rs.getString("u.address"));
                user.setPosition(rs.getString("u.position"));
                user.setUsername(rs.getString("u.username"));
                user.setPassword(rs.getString("u.password"));
                cart.setUser(user);
                
                Product product = new Product();
                product.setId(rs.getInt("pc.productId"));
                //Product.setCategory.(rs.getInt("id")); 
                Category category = new Category();
                category.setId(rs.getInt("p.categoryId"));
                category.setName(rs.getString("cat.name"));
                product.setCategory(category);
                product.setImage(rs.getString("p.image"));
                product.setName(rs.getString("p.name"));
                product.setAmount(rs.getInt("p.amount"));
                product.setPriceInit(rs.getDouble("p.priceInit"));
                product.setPrice(rs.getDouble("p.price"));
                double price = product.getPrice();
                product.setDesShort(rs.getString("p.desShort"));
                product.setDesLong(rs.getString("p.desLong"));
                product.setDateAdd(rs.getDate("p.dateAdd"));
                
                ProCart pc = new ProCart();
                pc.setId(rs.getInt("pc.id"));
                pc.setAmount(rs.getInt("pc.amount"));
                int amount = pc.getAmount();
                pc.setProduct(product);
                
                List<ProCart> listPC = new ArrayList<>();
                listPC.add(pc);
                float total =  (float)amount * (float)price;
                cart.setTotal(total);
                cart.setListProCarts(listPC);
                result.add(cart);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
//    public ArrayList<Cart> getAllCartNoCarts() {
//        ArrayList<Cart> result = new ArrayList<Cart>();
//        String sql = "SELECT * FROM cart";
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//
//            while (rs.next()) {
//            	Cart cart = new Cart();
//                cart.setId(rs.getInt("id"));
//                cart.setName(rs.getString("name"));
//                result.add(cart);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return result;
//    }

    public void addCart(Cart Cart) {
        String sql = "INSERT INTO btlweb.cart(userId) VALUES(?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, Cart.getUser().getId());
            ps.executeUpdate();

            //get id of the new inserted Cart
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                Cart.setId(generatedKeys.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * update the @Cart
     *
     * @param Cart
     */
    public void editCart(Cart Cart) {
        String sql = "UPDATE cart SET userId=? WHERE id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, Cart.getUser().getId());
            ps.setInt(2, Cart.getId());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * delete the Cart whose id is @id
     *
     * @param id
     */
    public void deleteCart(int id) {
        //String sql = "DELETE cart, product FROM cart, product WHERE cart.id = product.cartId and cart.id=?"; //sai
        String sql1 = "Delete from order where cartId = ?;";
        String sql2 = "Delete from procart where cartId = ?;";
        String sql3  ="Delete from cart where id =?;";
        try {
            // sql1
            PreparedStatement ps1 = con.prepareStatement(sql1);
            ps1.setInt(1, id);
            ps1.executeUpdate();
            
            //sql2
            PreparedStatement ps2 = con.prepareStatement(sql2);
            ps2.setInt(1, id);
            ps2.executeUpdate();
            
            //sql3
            PreparedStatement ps3 = con.prepareStatement(sql3);
            ps3.setInt(1, id);
            ps3.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     public Cart getCartByUser(String key) {
        Cart cart = new Cart();
        String sql = "SELECT c.id, c.userId "
                + "FROM btlweb.cart c, btlweb.user u "
                + "WHERE c.userId = u.id and u.username=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, key);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                cart.setId(rs.getInt("c.id"));
                User user = new User();
                UserDAO userImpl = new UserDAO();
                user = userImpl.getUserById(rs.getInt("c.userId"));
                cart.setUser(user);
            
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cart;
     }
}