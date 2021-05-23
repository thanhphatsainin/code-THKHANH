
package Controller.User;

import static Dao1.DAO.con;
import com.sun.scenario.effect.impl.prism.ps.PPSDrawable;
import Controller.User.MD5Hashing;
import Dao1.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.User;

/**
 *
 * @author ADMIN
 */
public class UserImpl extends DAO {
    public boolean checkUser(User user){
        String sql="SELECT * FROM mywebsite.user WHERE username=? and password=?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            
            String password = user.getPassword();
            String hash_pws = MD5Hashing.getMD5(password);
            
            ps.setString(1,user.getUsername());
            ps.setString(2,hash_pws);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                user.setName(rs.getString("name"));
                user.setPosition(rs.getString("position"));
                return true;
            }
                    
        } catch (SQLException ex) {
            Logger.getLogger(UserImpl.class.getName()).log(Level.SEVERE,null,ex);
        }
        return false;
    }
    public User getUserByUserName(String key){
        User user=new User();
        String sql= "SELECT * FROM mywebsite.user WHERE username=? ";
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
     public User getUserByName(String key){
        User user=new User();
        String sql= "SELECT * FROM mywebsite.user WHERE name=? ";
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
        String sql = "SELECT * FROM user WHERE id=?";
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
