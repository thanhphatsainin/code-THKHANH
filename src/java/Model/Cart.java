/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author DELL
 */
public class Cart implements Serializable{
    private int id;
    private float total;
    private User user;
    private List<ProCart> listProCarts;

    public Cart() {
    }

    public Cart(int id, User user) {
        this.id = id;
        this.user = user;
    }
    
    

    public Cart(int id, User user, List<ProCart> listProCarts) {
        this.id = id;
        this.user = user;
        this.listProCarts = listProCarts;
    }
  

    public Cart(int id, float total, User user, List<ProCart> listProCarts) {
        this.id = id;
        this.total = total;
        this.user = user;
        this.listProCarts = listProCarts;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<ProCart> getListProCarts() {
        return listProCarts;
    }

    public void setListProCarts(List<ProCart> listProCarts) {
        this.listProCarts = listProCarts;
    }

    @Override
    public String toString() {
        return "Cart{" + "id=" + id + ", total=" + total + ", user=" + user + ", listProCarts=" + listProCarts + '}';
    }

    
    
    
}
