package com.example.model;

import java.io.Serializable;
public class Sanpham2chieu implements Serializable {
    private String ma;
    private String ten;
    private int gia;
    public Sanpham2chieu(){}

    public Sanpham2chieu(String ma, int gia, String ten) {
        this.ma = ma;
        this.ten = ten;
        this.gia = gia;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    @Override
    public String toString() {
        return ma+" "+ten+" "+gia;
    }
}

