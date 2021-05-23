/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao1;

import Model.Product;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class main {
    public static void main(String[] args) {
        ProductDAO daoo = new ProductDAO();
        List<Product> li = daoo.searchProduct("ao");
        for (Product li1 : li) {
            System.out.println(li1.getName());
        }
        
    }
}
