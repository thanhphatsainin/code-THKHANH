/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class Product implements Serializable{
    private int id;
    private String image;
    private String name;
    private int amount;
    private double priceInit;
    private double price;
    private String desShort;
    private String desLong;
    private Date dateAdd;
    private Category category;

    public Product() {
    }

    public Product(int id, String image, String name, int amount, double priceInit, double price, String desShort, String desLong, Date dateAdd, Category category) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.amount = amount;
        this.priceInit = priceInit;
        this.price = price;
        this.desShort = desShort;
        this.desLong = desLong;
        this.dateAdd = dateAdd;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPriceInit() {
        return priceInit;
    }

    public void setPriceInit(double priceInit) {
        this.priceInit = priceInit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDesShort() {
        return desShort;
    }

    public void setDesShort(String desShort) {
        this.desShort = desShort;
    }

    public String getDesLong() {
        return desLong;
    }

    public void setDesLong(String desLong) {
        this.desLong = desLong;
    }

    public Date getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(Date dateAdd) {
        this.dateAdd = dateAdd;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public static Comparator<Product> getProRollno() {
        return ProRollno;
    }

    public static void setProRollno(Comparator<Product> ProRollno) {
        Product.ProRollno = ProRollno;
    }

    

    public static Comparator<Product> ProRollno = new Comparator<Product>() {

	public int compare(Product s1, Product s2) {

	   int rollno1 = s1.getId();
	   int rollno2 = s2.getId();

	   /*For ascending order*/
	   return rollno1-rollno2;

	   /*For descending order*/
	   //rollno2-rollno1;
   }};
    
    
    
}
