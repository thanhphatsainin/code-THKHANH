/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao1;

import Controller.User.MD5Hashing;
import Model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.iharder.Base64;
import org.apache.commons.codec.binary.Hex;

/**
 *
 * @author DELL
 */
public class UserDAO extends DAO {

    public UserDAO() {
        super();
    }

    public boolean checkLogin(User user) {
        boolean result = false;
        String sql = "SELECT name, position FROM user WHERE username = ? AND password = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            String password = user.getPassword();
            String hash_pws = MD5Hashing.getMD5(password);
            
            ps.setString(1, user.getUsername());
            ps.setString(2, hash_pws);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user.setName(rs.getString("name"));
                user.setPosition(rs.getString("position"));
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public ArrayList<User> searchUser(String key) {
        ArrayList<User> result = new ArrayList<User>();
        String sql = "SELECT * FROM user WHERE name LIKE ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + key + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setAddress(rs.getString("address"));
                user.setPosition(rs.getString("position"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                result.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * get a User whose id is @key
     *
     * @param key
     * @return
     */
    public User getUserByUserName(String key) {
        User user = new User();
        String sql = "SELECT * FROM user WHERE username=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, key);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setAddress(rs.getString("address"));
                user.setPosition(rs.getString("position"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                System.out.println(user.toString());
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    public User getUserByName(String key) {
        User user = new User();
        String sql = "SELECT * FROM user WHERE name=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, key);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setAddress(rs.getString("address"));
                user.setPosition(rs.getString("position"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                System.out.println(user.toString());
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public User getUserByEmail(String key) {
        User user = new User();
        String sql = "SELECT * FROM user WHERE email=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, key);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setAddress(rs.getString("address"));
                user.setPosition(rs.getString("position"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                System.out.println(user.toString());
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public User getUserById(int key) {
        User user = new User();
        String sql = "SELECT * FROM btlweb.user WHERE id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, key);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setAddress(rs.getString("address"));
                user.setPosition(rs.getString("position"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                System.out.println(user.toString());
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * get all User from user
     *
     * @return
     */
    public ArrayList<User> getAllUser() {
        ArrayList<User> result = new ArrayList<>();
        String sql = "SELECT * FROM user";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setAddress(rs.getString("address"));
                user.setPosition(rs.getString("position"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                result.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * add a new @User into the DB
     *
     * @param User
     */
    public void addUser(User user) {
        String sql = "INSERT INTO user(name, email, address, position, username, password) VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getAddress());
            ps.setString(4, user.getPosition());
            ps.setString(5, user.getUsername());
            ps.setString(6, user.getPassword());

            ps.executeUpdate();

            //get id of the new inserted User
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                user.setId(generatedKeys.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * update the @User
     *
     * @param User
     */
    public boolean editUser(User user) {
        String sql = "UPDATE user SET name=?, email=?, address=?, position=?, username=?, password=? WHERE id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getAddress());
            ps.setString(4, user.getPosition());
            ps.setString(5, user.getUsername());
            ps.setString(6, user.getPassword());
            ps.setInt(7, user.getId());
            return ps.executeUpdate() > 0;

//            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loi edit");
        }
        return false;
    }

    /**
     * delete the User whose id is @id
     *
     * @param id
     */
    public void deleteUser(int id) {
        String sql = "DELETE FROM user WHERE id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
