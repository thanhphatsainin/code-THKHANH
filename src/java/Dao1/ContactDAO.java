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

import Model.Contact;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */



public class ContactDAO extends DAO {

    public ContactDAO() {
        super();
    }

    /**
     * get a contact whose id is @key
     *
     * @param key
     * @return
     */
    public Contact getcontactById(int key) {
    	Contact contact = new Contact();
        String sql = "SELECT * FROM contact WHERE id=?"; 
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, key);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                contact.setId(rs.getInt("id"));
                contact.setAddress(rs.getString("address"));
                contact.setEmail(rs.getString("email"));
                contact.setSdt(rs.getString("sdt"));
                contact.setHottline(rs.getString("hottline"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contact;
    }

    /**
     * get all contact from contact
     *
     * @return
     */
    public ArrayList<Contact> getAllcontact() {
        ArrayList<Contact> result = new ArrayList<Contact>();
        String sql = "SELECT * FROM contact";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            	Contact contact = new Contact();
                contact.setId(rs.getInt("id"));
                contact.setAddress(rs.getString("address"));
                contact.setEmail(rs.getString("email"));
                contact.setSdt(rs.getString("sdt"));
                contact.setHottline(rs.getString("hottline"));
                result.add(contact);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * add a new @contact into the DB
     *
     * @param contact
     */
    public void addcontact(Contact contact) {
        String sql = "INSERT INTO contact(address, email, sdt, hottline) VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, contact.getAddress());
            ps.setString(2, contact.getEmail());
            ps.setString(3, contact.getSdt());
            ps.setString(4, contact.getHottline());

            ps.executeUpdate();

            //get id of the new inserted contact
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                contact.setId(generatedKeys.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * update the @contact
     *
     * @param contact
     */
    public boolean editcontact(Contact contact) {
        String sql = "UPDATE contact SET address=?, email =?, sdt=?, hottline=? WHERE id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, contact.getAddress());
            ps.setString(2, contact.getEmail());
            ps.setString(3, contact.getSdt());
            ps.setString(4, contact.getHottline());
            ps.setInt(5, contact.getId());
            return ps.executeUpdate() > 0;
            //ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * delete the contact whose id is @id
     *
     * @param id
     */
    public void deletecontact(int id) {
        String sql = "DELETE FROM contact WHERE id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

