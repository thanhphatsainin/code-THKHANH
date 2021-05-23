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
public class Order implements Serializable{
    private int id;
    private Date dateOder;
    private float total;
    private Cart cart;

    public Order() {
    }

    public Order(int id, Date dateOder, float total, Cart cart) {
        this.id = id;
        this.dateOder = dateOder;
        this.total = total;
        this.cart = cart;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateOder() {
        return dateOder;
    }

    public void setDateOder(Date dateOder) {
        this.dateOder = dateOder;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", dateOder=" + dateOder + ", total=" + total + ", cart=" + cart + '}';
    }
    
}
