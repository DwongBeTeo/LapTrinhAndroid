package com.example.Model;

import java.util.ArrayList;

public class DanhMuc {
    private String ma,ten;
    private ArrayList<SanPham> sanphams=new ArrayList<SanPham>();
    public DanhMuc(String ma, String ten){
        this.ma=ma;
        this.ten=ten;
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

    public ArrayList<SanPham> getSanphams() {
        return sanphams;
    }

    public void setSanphams(ArrayList<SanPham> sanphams) {
        this.sanphams = sanphams;
    }

    @Override
    public String toString() {
        return ten;
    }
}