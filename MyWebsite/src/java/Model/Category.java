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
public class Category implements Serializable{
    private int id;
    private String name;
    private List<Product> listProduct;

    public Category() {
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    

    public Category(int id, String name, List<Product> listProduct) {
        this.id = id;
        this.name = name;
        this.listProduct = listProduct;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getListProduct() {
        return listProduct;
    }

    public void setListProduct(List<Product> listProduct) {
        this.listProduct = listProduct;
    }

    @Override
    public String toString() {
        return "Category{" + "id=" + id + ", name=" + name + ", listProduct=" + listProduct + '}';
    }

    
    
    
}
