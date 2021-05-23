/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class Bill implements Serializable{
    private int id;
    private String code;
    private Date datePay;
    private float total;
    private String status;
    private User user;
    private Order order;

    public Bill() {
    }

    public Bill(int id, String code, Date datePay, float total, String status, User user, Order order) {
        this.id = id;
        this.code = code;
        this.datePay = datePay;
        this.total = total;
        this.status = status;
        this.user = user;
        this.order = order;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDatePay() {
        return datePay;
    }

    public void setDatePay(Date datePay) {
        this.datePay = datePay;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Bill{" + "id=" + id + ", code=" + code + ", datePay=" + datePay + ", total=" + total + ", status=" + status + ", user=" + user + ", order=" + order + '}';
    }

    
    
}
