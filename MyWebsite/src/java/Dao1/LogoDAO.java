/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao1;



import Model.Logo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */



public class LogoDAO extends DAO {

    public LogoDAO() {
        super();
    }


    /**
     * get a logo whose id is @key
     *
     * @param key
     * @return
     */
    public Logo getlogoById(int key) {
    	Logo logo = new Logo();
        String sql = "SELECT * FROM logo WHERE id=?"; 
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, key);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                logo.setId(rs.getInt("id"));
                logo.setImage(rs.getString("image"));
                logo.setName(rs.getString("name"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return logo;
    }

    /**
     * get all logo from logo
     *
     * @return
     */
    public ArrayList<Logo> getAlllogo() {
        ArrayList<Logo> result = new ArrayList<Logo>();
        String sql = "SELECT * FROM logo";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            	Logo logo = new Logo();
                logo.setId(rs.getInt("id"));
                logo.setImage(rs.getString("image"));
                logo.setName(rs.getString("name"));
                result.add(logo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * add a new @logo into the DB
     *
     * @param logo
     */
    public void addlogo(Logo logo) {
        String sql = "INSERT INTO logo(image, name) VALUES(?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, logo.getImage());
            ps.setString(2, logo.getName());

            ps.executeUpdate();

            //get id of the new inserted logo
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                logo.setId(generatedKeys.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * update the @logo
     *
     * @param logo
     */
    public void editlogo(Logo logo) {
        String sql = "UPDATE logo SET image =?, name=? WHERE id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, logo.getImage());
            ps.setString(2, logo.getName());
            ps.setInt(3, logo.getId());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * delete the logo whose id is @id
     *
     * @param id
     */
    public void deletelogo(int id) {
        String sql = "DELETE FROM logo WHERE id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


