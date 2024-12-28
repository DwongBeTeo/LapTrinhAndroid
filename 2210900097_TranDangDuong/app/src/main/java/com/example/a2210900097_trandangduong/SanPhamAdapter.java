package com.example.a2210900097_trandangduong;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.DecimalFormat;

public class SanPhamAdapter extends ArrayAdapter<SanPham> {
    Activity context97;
    int resource97;
    public SanPhamAdapter(@NonNull Activity context97, int resource97) {
        super(context97, resource97);
        this.context97=context97;
        this.resource97=resource97;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        DecimalFormat df = new DecimalFormat("#.00");
        LayoutInflater inflater97 = context97.getLayoutInflater();
        View customview97 =inflater97.inflate(resource97,null);
        TextView txtTenSP97,txtMaSP97,txtSL97,txtDonGia97,txtThanhTien97;
        txtMaSP97=customview97.findViewById(R.id.txtMaSP97);
        txtTenSP97=customview97.findViewById(R.id.txtTenSP97);
        txtSL97=customview97.findViewById(R.id.txtSL97);
        txtDonGia97=customview97.findViewById(R.id.txtDonGia97);
        txtThanhTien97=customview97.findViewById(R.id.txtThanhTien97);
        SanPham sp97 = getItem(position);
        double donGia = sp97.getDonGia();
        int soLuong = sp97.getSoLuong();
        double thanhTien = soLuong * donGia;
        txtMaSP97.setText(sp97.getMaSanPham()+"");
        txtTenSP97.setText(sp97.getTenSanPham());
        txtDonGia97.setText(df.format(sp97.getDonGia()));
        txtSL97.setText(String.valueOf(soLuong));
        txtThanhTien97.setText(String.format("%.2f", thanhTien));
        return customview97;
    }
}

