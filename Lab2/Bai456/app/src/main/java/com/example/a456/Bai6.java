package com.example.a456;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Bai6 extends AppCompatActivity {
    //khai báo giao diện
    EditText edtTen,edtMSSV,edtTuoi;
    RadioGroup rgGioiTinh;
    RadioButton rbNam,rbNu;
    CheckBox cbDaBong,cbChoiGame;
    Button btnLuu;
    TextView tvKetQua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai6);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //ánh xạ id
        edtTen=findViewById(R.id.edtTen);
        edtMSSV=findViewById(R.id.edtMSSV);
        edtTuoi=findViewById(R.id.edtTuoi);
        rgGioiTinh=findViewById(R.id.rgGioiTinh);
        rbNam=findViewById(R.id.rbNam);
        rbNu=findViewById(R.id.rbNu);
        cbDaBong=findViewById(R.id.cbDaBong);
        cbChoiGame=findViewById(R.id.cbChoiGame);
        btnLuu=findViewById(R.id.btnLuu);
        tvKetQua=findViewById(R.id.tvKetQua);
        //xử lý nút lưu btnLuu
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy thông tin từ các trường nhập
                String ten = edtTen.getText().toString();
                String mssv = edtMSSV.getText().toString();
                int tuoi = Integer.parseInt(edtTuoi.getText().toString());
                // Lấy giới tính
                String GioiTinh ="";
                if (rbNam.isChecked()){
                    GioiTinh ="Nam";
                } else if (rbNu.isChecked()) {
                    GioiTinh="Nữ";
                }
                // Lấy sở thích
                StringBuilder soThich = new StringBuilder();
                if (cbDaBong.isChecked()){
                    soThich.append("Đá bóng");
                }if (cbChoiGame.isChecked()){
                    if (soThich.length()>0){
                        // Thêm dấu phẩy nếu đã có sở thích trước
                        soThich.append(", ");
                    }
                    soThich.append("Chơi game");
                }
                // Kiểm tra nếu không có sở thích nào được chọn
                if (soThich.length()==0){
                    soThich.append("Không có sở thích");
                }
                // Kiểm tra dữ liệu
                if (ten.isEmpty()){
                    Toast.makeText(Bai6.this, "Hãy nhập tên của bạn", Toast.LENGTH_SHORT).show();
                }if (mssv.isEmpty()){
                    Toast.makeText(Bai6.this, "Hãy nhập mã sinh viên", Toast.LENGTH_SHORT).show();
                }if (tuoi <= 0){
                    Toast.makeText(Bai6.this, "Hãy nhập đúng tuổi của bạn", Toast.LENGTH_SHORT).show();
                } else{
                    String ketQua = "Họ tên: "+ten +
                                    " \nMã sinh viên: "+mssv+
                                    " \nTuổi: "+tuoi+
                                    " \nGiới tính: "+GioiTinh+
                                    " \nSở thích: "+soThich;
                    tvKetQua.setText(ketQua);
                }
            }
        });
    }
}