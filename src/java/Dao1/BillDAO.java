/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao1;



import Model.Article;
import Model.Bill;
import Model.Order;
import Model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */



public class BillDAO extends DAO {
    
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public BillDAO() {
        super();
    }

public Bill getBillById(int key) {
    	Bill bill = new Bill();
        String sql = "SELECT * from bill where id = ?"; 
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, key);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                bill.setId(rs.getInt("id"));
                User user = new User();
                UserDAO userDAO = new UserDAO();
                user = userDAO.getUserById(rs.getInt("userId"));
                bill.setUser(user);
                
                Order order = new Order();
                OrderDAO orderDAO = new OrderDAO();
                order = orderDAO.getOrderById(rs.getInt("orderId"));
                bill.setOrder(order);
                
                bill.setCode(rs.getString("code"));
                bill.setDatePay(rs.getDate("datePay"));
                bill.setStatus(rs.getString("status"));
                bill.setTotal(order.getTotal());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bill;
    }
 
    public ArrayList<Bill> getAllBill() {
        ArrayList<Bill> result = new ArrayList<Bill>();
        //String sql = "SELECT * FROM article";
        String sql = "SELECT * from bill"; 
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Bill bill = new Bill();
                bill.setId(rs.getInt("id"));
                User user = new User();
                UserDAO userDAO = new UserDAO();
                user = userDAO.getUserById(rs.getInt("userId"));
                bill.setUser(user);
                
                Order order = new Order();
                OrderDAO orderDAO = new OrderDAO();
                order = orderDAO.getOrderById(rs.getInt("orderId"));
                bill.setOrder(order);
                
                bill.setCode(rs.getString("code"));
                bill.setDatePay(rs.getDate("datePay"));
                bill.setStatus(rs.getString("status"));
                bill.setTotal(order.getTotal());
                result.add(bill);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    


    public void addBill(Bill Bill) {
        String sql = "INSERT INTO bill(userId, orderId, code, datePay, status) VALUES(?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, Bill.getUser().getId());
            ps.setInt(2, Bill.getOrder().getId());
            ps.setString(3, Bill.getCode());
            ps.setString(4, sdf.format(Bill.getDatePay()));
            ps.setString(5, Bill.getStatus());
            
            ps.executeUpdate();

            //get id of the new inserted Bill
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                Bill.setId(generatedKeys.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * update the @Bill
     *
     * @param Bill
     */
    public void editBill(Bill Bill) {
        String sql = "UPDATE bill SET userId=?, orderId=?, code=?, datePay=?, status=? WHERE id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, Bill.getUser().getId());
            ps.setInt(2, Bill.getOrder().getId());
            ps.setString(3, Bill.getCode());
            ps.setString(4, sdf.format(Bill.getDatePay()));
            ps.setString(5, Bill.getStatus());;
            ps.setInt(6, Bill.getId());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteBill(int id) {
        //String sql = "DELETE bill, order FROM bill, order WHERE bill.id = order.billId and bill.id=?"; //sai
        String sql1  ="Delete from bill where id =?;";
        try {
            // sql1
            PreparedStatement ps1 = con.prepareStatement(sql1);
            ps1.setInt(1, id);
            ps1.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

