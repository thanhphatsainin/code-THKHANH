/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.cart;

import static Dao1.DAO.con;
import Model.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import Model.Category;

/**
 *
 * @author ADMIN
 */
public class ProductImpl extends Dao1.DAO {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public ArrayList<Product> searchProduct(String key) {
        ArrayList<Product> result = new ArrayList<Product>();
        String sql = "SELECT p.id, p.categoryId, p.image, p.name, p.price, p.desShort, p.dateAdd, c.id, c.name "
                + "FROM product p, category c"
                + " WHERE p.categoryId = c.id AND p.name LIKE ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + key + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product product = new Product();
                Category category = new Category();
                product.setCategory(category);
                product.setId(rs.getInt("p.id"));
                category.setId(rs.getInt("p.categoryId"));
                category.setName(rs.getString("c.name"));
                product.setImage(rs.getString("p.image"));
                product.setName(rs.getString("p.name"));
                product.setPrice(rs.getDouble("p.price"));
                product.setDesShort(rs.getString("p.desShort"));
                product.setDateAdd(rs.getDate("p.dateAdd"));
                result.add(product);
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
        String sql = "SELECT p.id, p.categoryId, p.image, p.name,p.amount, p.price, p.desShort, p.dateAdd, c.id, c.name "
                + "FROM product p, category c"
                + " WHERE p.categoryId = c.id AND p.id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, key);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                product.setId(rs.getInt("p.id"));
                Category category = new Category();
                category.setId(rs.getInt("p.categoryId"));
                category.setName(rs.getString("c.name"));
                product.setCategory(category);
                product.setImage(rs.getString("p.image"));
                product.setName(rs.getString("p.name"));
                product.setPrice(rs.getDouble("p.price"));
                product.setAmount(rs.getInt("p.amount"));
                product.setDesShort(rs.getString("p.desShort"));
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
        String sql = "SELECT p.id, p.categoryId, p.image, p.name, p.price, p.amount, p.desShort, p.dateAdd, c.id, c.name "
                + "FROM product p, category c"
                + " WHERE p.categoryId = c.id";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product Product = new Product();
                Product.setId(rs.getInt("p.id"));
                Category category = new Category();
                category.setId(rs.getInt("p.categoryId"));
                category.setName(rs.getString("c.name"));
                Product.setCategory(category);
                Product.setImage(rs.getString("p.image"));
                Product.setName(rs.getString("p.name"));
                Product.setPrice(rs.getDouble("p.price"));
                Product.setAmount(rs.getInt("p.amount"));
                Product.setDesShort(rs.getString("p.desShort"));
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
        String sql = "INSERT INTO product(categoryId, image, name, price,amount, desShort, dateAdd) VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, Product.getCategory().getId());
            ps.setString(2, Product.getImage());
            ps.setString(3, Product.getName());
            ps.setDouble(4, Product.getPrice());
            ps.setInt(5, Product.getAmount());
            ps.setString(6, Product.getDesShort());
            ps.setString(7, sdf.format(Product.getDateAdd()));

            ps.executeUpdate();

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
        String sql = "UPDATE product SET categoryId=?, image=?, name=?, price=?,amount =?, desShort=?, dateAdd=? WHERE id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, Product.getCategory().getId());
            ps.setString(2, Product.getImage());
            ps.setString(3, Product.getName());
            ps.setInt(4, Product.getAmount());
            ps.setDouble(5, Product.getPrice());
            ps.setString(6, Product.getDesShort());
            ps.setString(7, sdf.format(Product.getDateAdd()));
            ps.setInt(8, Product.getId());

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
