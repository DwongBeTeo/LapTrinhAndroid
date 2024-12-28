package com.example.lap08;

import java.io.Serializable;

public class Contact implements Serializable {
    private int Ma;
    private String ten;
    private String dienthoai;

    public int getMa() {
        return Ma;
    }

    public void setMa(int ma) {
        Ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDienthoai() {
        return dienthoai;
    }

    public void setDienthoai(String dienthoai) {
        this.dienthoai = dienthoai;
    }

    public Contact() {
    }

    public Contact(int ma, String ten, String dienthoai) {
        Ma = ma;
        this.ten = ten;
        this.dienthoai = dienthoai;
    }

    @Override
    public String toString() {
        return Ma+" "+ten+" "+dienthoai;
    }
}
