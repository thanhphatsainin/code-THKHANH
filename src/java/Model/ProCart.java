/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author DELL
 */
public class ProCart implements Serializable{
    private int id;
    private int amount;
    private Cart cart;
    private Product product;

    public ProCart() {
    }

    public ProCart(int id, int amount, Product product) {
        this.id = id;
        this.amount = amount;
        this.product = product;
    }
    
    

    public ProCart(int id, int amount, Cart cart, Product product) {
        this.id = id;
        this.amount = amount;
        this.cart = cart;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProCart{" + "id=" + id + ", amount=" + amount + ", cart=" + cart + ", product=" + product + '}';
    }
    
    
}
