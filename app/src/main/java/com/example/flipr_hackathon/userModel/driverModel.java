package com.example.flipr_hackathon.userModel;

import android.util.Pair;

public class driverModel {

    String name;
    String username;
    String password;
    String Age;
    String Truckno;
    String mobileno;
    String truckcapacity;
    String transportername;
    String drivingexp;
    Pair<String,String> p1,p2,p3;

    public driverModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getTruckno() {
        return Truckno;
    }

    public void setTruckno(String truckno) {
        Truckno = truckno;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getTruckcapacity() {
        return truckcapacity;
    }

    public void setTruckcapacity(String truckcapacity) {
        this.truckcapacity = truckcapacity;
    }

    public String getTransportername() {
        return transportername;
    }

    public void setTransportername(String transportername) {
        this.transportername = transportername;
    }

    public String getDrivingexp() {
        return drivingexp;
    }

    public void setDrivingexp(String drivingexp) {
        this.drivingexp = drivingexp;
    }

    public Pair<String, String> getP1() {
        return p1;
    }

    public void setP1(Pair<String, String> p1) {
        this.p1 = p1;
    }

    public Pair<String, String> getP2() {
        return p2;
    }

    public void setP2(Pair<String, String> p2) {
        this.p2 = p2;
    }

    public Pair<String, String> getP3() {
        return p3;
    }

    public void setP3(Pair<String, String> p3) {
        this.p3 = p3;
    }
}
