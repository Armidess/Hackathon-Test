package com.example.flipr_hackathon.userModel;

import android.util.Pair;

import java.io.Serializable;

public class dealerModel implements Serializable {

    String name = null;
    String username = null;
    String password = null;
    String mobileno = null;
    String nature = null;
    String weight = null;
    String quantity = null;
    String uid=null;
    int type=0;
    Pair<String,String> city = null;

    public dealerModel() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public dealerModel(String username, String password, int type) {
        this.username = username;
        this.password = password;
        this.type=0;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Pair<String, String> getCity() {
        return city;
    }

    public void setCity(Pair<String, String> city) {
        this.city = city;
    }
}
