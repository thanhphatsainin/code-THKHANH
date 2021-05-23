/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao1;

import Model.Category;
import Model.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO extends DAO {

    public CategoryDAO() {
        super();
    }
    
    public Category getCategoryById(int key) {
    	Category category = new Category();
        String sql = "SELECT * FROM category WHERE id=?"; 
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, key);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return category;
    }
    
//    public Category getCategoryById(int key) {
//        Category category = new Category();
//        //String sql = "SELECT * FROM category WHERE id=?";
//        String sql = "SELECT DISTINCT c.id, c.name, p.id, p.categoryId, p.name, p.amount, p.priceInit, p.price, p.desShort, p.desLong, p.dateAdd "
//                + "FROM product p, category c"
//                + " WHERE p.categoryId = c.id AND c.id=?"; 
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setInt(1, key);
//            ResultSet rs = ps.executeQuery();
//
//            if (rs.next()) {
//                category.setId(rs.getInt("c.id"));
//                category.setName(rs.getString("c.name"));
//                List<Product> listpProduct = new ArrayList<>();
//                Product product = new Product();
//                product.setId(rs.getInt("p.id"));
//                //Product.setCategory.(rs.getInt("id")); 
//                product.setCategory(category);
//                product.setName(rs.getString("p.name"));
//                product.setAmount(rs.getInt("p.amount"));
//                product.setPriceInit(rs.getDouble("p.priceInit"));
//                product.setPriceInit(rs.getDouble("p.price"));
//                product.setDesShort(rs.getString("p.desShort"));
//                product.setDesLong(rs.getString("p.desLong"));
//                product.setDateAdd(rs.getDate("p.dateAdd"));
//                listpProduct.add(product);
//                category.setListProduct(listpProduct);
//
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return category;
//    }

    /**
     * get all article from article
     *
     * @return
     */
    public ArrayList<Category> getAllCategory() {
        ArrayList<Category> result = new ArrayList<Category>();
        //String sql = "SELECT * FROM article";
        String sql = "SELECT DISTINCT c.id, c.name, p.id, p.categoryId, p.name, p.amount, p.priceInit, p.price, p.desShort, p.desLong, p.dateAdd "
                + "FROM product p, category c"
                + " WHERE p.categoryId = c.id";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt("c.id"));
                category.setName(rs.getString("c.name"));
                List<Product> listpProduct = new ArrayList<>();
                Product product = new Product();
                product.setId(rs.getInt("p.id"));
                //Product.setCategory.(rs.getInt("id")); 
                product.setCategory(category);
                product.setName(rs.getString("p.name"));
                product.setAmount(rs.getInt("p.amount"));
                product.setPriceInit(rs.getDouble("p.priceInit"));
                product.setPriceInit(rs.getDouble("p.price"));
                product.setDesShort(rs.getString("p.desShort"));
                product.setDesLong(rs.getString("p.desLong"));
                product.setDateAdd(rs.getDate("p.dateAdd"));
                listpProduct.add(product);
                category.setListProduct(listpProduct);
                result.add(category);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public ArrayList<Category> getAllCategoryNoCategorys() {
        ArrayList<Category> result = new ArrayList<Category>();
        String sql = "SELECT * FROM category";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            	Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                result.add(category);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public void addCategory(Category Category) {
        String sql = "INSERT INTO category(name) VALUES(?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, Category.getName());
            ps.executeUpdate();

            //get id of the new inserted Category
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                Category.setId(generatedKeys.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * update the @Category
     *
     * @param Category
     */
    public void editCategory(Category Category) {
        String sql = "UPDATE category SET name=? WHERE id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, Category.getName());
            ps.setInt(2, Category.getId());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * delete the Category whose id is @id
     *
     * @param id
     */
    public void deleteCategory(int id) {
        //String sql = "DELETE category, product FROM category, product WHERE category.id = product.categoryId and category.id=?"; //sai
        String sql1 = "Delete from product where categoryId = ?;";
        String sql2  ="Delete from category where id =?;";
        try {
            // sql1
            PreparedStatement ps1 = con.prepareStatement(sql1);
            ps1.setInt(1, id);
            ps1.executeUpdate();
            
            //sql2
            PreparedStatement ps2 = con.prepareStatement(sql2);
            ps2.setInt(1, id);
            ps2.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
