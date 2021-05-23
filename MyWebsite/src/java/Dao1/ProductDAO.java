/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Model.Category;
import Model.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.text.SimpleDateFormat;

/**
 *
 * @author DELL
 */



public class ProductDAO extends DAO {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public ProductDAO() {
        super();
    }

    public ArrayList<Product> searchProduct(String key) {
        ArrayList<Product> result = new ArrayList<Product>();
        String sql = "SELECT p.id, p.categoryId, p.image, p.name, p.amount, p.priceInit, p.price, p.desShort, p.desLong, p.dateAdd, c.id, c.name "
                + "FROM product p, category c"
                + " WHERE p.categoryId = c.id AND p.name LIKE ?"; 
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + key + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product Product = new Product();
                Product.setId(rs.getInt("p.id"));
                //Product.setCategory.(rs.getInt("id")); 
                Category category = new Category();
                category.setId(rs.getInt("p.categoryId"));
                category.setName(rs.getString("c.name"));
                Product.setCategory(category);
                Product.setImage(rs.getString("p.image"));
                Product.setName(rs.getString("p.name"));
                Product.setAmount(rs.getInt("p.amount"));
                Product.setPriceInit(rs.getDouble("p.priceInit"));
                Product.setPrice(rs.getDouble("p.price"));
                Product.setDesShort(rs.getString("p.desShort"));
                Product.setDesLong(rs.getString("p.desLong"));
                Product.setDateAdd(rs.getDate("p.dateAdd"));
                result.add(Product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    


    /**
     * get a Product whose id is @key
     *
     * @param key
     * @return
     */
    public Product getProductById(int key) {
        Product product = new Product();
        String sql = "SELECT p.id, p.categoryId, p.image, p.name, p.amount, p.priceInit, p.price, p.desShort, p.desLong, p.dateAdd, c.id, c.name "
                + "FROM product p, category c"
                + " WHERE p.categoryId = c.id AND p.id=?"; 
//        String sql = "SELECT * FROM product WHERE id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, key);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                product.setId(rs.getInt("p.id"));
                //Product.setCategory.(rs.getInt("id")); 
                Category category = new Category();
                category.setId(rs.getInt("p.categoryId"));
                category.setName(rs.getString("c.name"));
                product.setCategory(category);
                product.setImage(rs.getString("p.image"));
                product.setName(rs.getString("p.name"));
                product.setAmount(rs.getInt("p.amount"));
                product.setPriceInit(rs.getDouble("p.priceInit"));
                product.setPrice(rs.getDouble("p.price"));
                product.setDesShort(rs.getString("p.desShort"));
                product.setDesLong(rs.getString("p.desLong"));
                product.setDateAdd(rs.getDate("p.dateAdd"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }

    /**
     * get all Product from Product
     *
     * @return
     */
    public ArrayList<Product> getAllProduct() {
        ArrayList<Product> result = new ArrayList<Product>();
        String sql = "SELECT p.id, p.categoryId, p.image, p.name, p.amount, p.priceInit, p.price, p.desShort, p.desLong, p.dateAdd, c.id, c.name "
                + "FROM product p, category c"
                + " WHERE p.categoryId = c.id"; 
//        String sql = "SELECT * FROM product";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product Product = new Product();
                Product.setId(rs.getInt("p.id"));
                //Product.setCategory.(rs.getInt("id")); 
                Category category = new Category();
                category.setId(rs.getInt("p.categoryId"));
                category.setName(rs.getString("c.name"));
                Product.setCategory(category);
                Product.setImage(rs.getString("p.image"));
                Product.setName(rs.getString("p.name"));
                Product.setAmount(rs.getInt("p.amount"));
                Product.setPriceInit(rs.getDouble("p.priceInit"));
                Product.setPrice(rs.getDouble("p.price"));
                Product.setDesShort(rs.getString("p.desShort"));
                Product.setDesLong(rs.getString("p.desLong"));
                Product.setDateAdd(rs.getDate("p.dateAdd"));
                result.add(Product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * add a new @Product into the DB
     *
     * @param Product
     */
    public void addProduct(Product Product) {
        String sql = "INSERT INTO product(categoryId, image, name, amount, priceInit, price, desShort, desLong, dateAdd) VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, Product.getCategory().getId());
            ps.setString(2, Product.getImage());
            ps.setString(3, Product.getName());
            ps.setInt(4, Product.getAmount());
            ps.setDouble(5, Product.getPriceInit());
            ps.setDouble(6, Product.getPrice());
            ps.setString(7, Product.getDesShort());
            ps.setString(8, Product.getDesLong());
            ps.setString(9, sdf.format(Product.getDateAdd()));

            ps.executeUpdate();

            //get id of the new inserted Product
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                Product.setId(generatedKeys.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * update the @Product
     *
     * @param Product
     */
    public void editProduct(Product Product) {
        String sql = "UPDATE product SET categoryId=?, image=?, name=?, amount =?, priceInit=?, price=?, desShort=?, desLong=?, dateAdd=? WHERE id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, Product.getCategory().getId());
            ps.setString(2, Product.getImage());
            ps.setString(3, Product.getName());
            ps.setInt(4, Product.getAmount());
            ps.setDouble(5, Product.getPriceInit());
            ps.setDouble(6, Product.getPrice());
            ps.setString(7, Product.getDesShort());
            ps.setString(8, Product.getDesLong());
            ps.setString(9, sdf.format(Product.getDateAdd()));
            ps.setInt(10, Product.getId());
            

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * delete the Product whose id is @id
     *
     * @param id
     */
    public void deleteProduct(int id) {
        String sql = "DELETE FROM product WHERE id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
