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
public class Contact implements Serializable{
    private int id;
    private String address;
    private String email;
    private String sdt;
    private String hottline;

    public Contact() {
    }

    public Contact(int id, String address, String email, String sdt, String hottline) {
        this.id = id;
        this.address = address;
        this.email = email;
        this.sdt = sdt;
        this.hottline = hottline;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getHottline() {
        return hottline;
    }

    public void setHottline(String hottline) {
        this.hottline = hottline;
    }

    @Override
    public String toString() {
        return "Contact{" + "id=" + id + ", address=" + address + ", email=" + email + ", sdt=" + sdt + ", hottline=" + hottline + '}';
    }
    
}
