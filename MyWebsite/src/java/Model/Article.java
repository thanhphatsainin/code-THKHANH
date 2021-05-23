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
public class Article implements Serializable{
    private int id;
    private String name;
    private String image;
    private String des;

    public Article() {
    }

    public Article(int id, String name, String image, String des) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.des = des;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    @Override
    public String toString() {
        return "Article{" + "id=" + id + ", name=" + name + ", image=" + image + ", des=" + des + '}';
    }
    
    
}
