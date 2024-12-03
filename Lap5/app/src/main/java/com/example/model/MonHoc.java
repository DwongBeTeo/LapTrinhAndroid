package com.example.model;

public class MonHoc {
   private int maMH;
   private String tenMH;
    private int soTiet;

    public MonHoc(int maMH, int soTiet, String tenMH) {
        this.maMH = maMH;
        this.tenMH = tenMH;
        this.soTiet = soTiet;

    }

    public int getMaMH() {
        return maMH;
    }

    public void setMaMH(int maMH) {
        this.maMH = maMH;
    }

    public String getTenMH() {
        return tenMH;
    }

    public void setTenMH(String tenMH) {
        this.tenMH = tenMH;
    }

    public int getSoTiet() {
        return soTiet;
    }

    public void setSoTiet(int soTiet) {
        this.soTiet = soTiet;
    }

    @Override
    public String toString() {
        return "MonHoc{" +
                "maMH=" + maMH +
                ", soTiet=" + soTiet +
                ", tenMH='" + tenMH + '\'' +
                '}';
    }
}
