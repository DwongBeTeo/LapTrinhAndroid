package com.example.a2210900097_trandangduong;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ThemSua extends AppCompatActivity {

    Intent intent97;  // Intent nhận dữ liệu
    EditText edtMaSP97, edtTenSP97, edtSL97, edtDonGia97;
    Button btnaddsua97, btnthoat97;
    String trangthai97;  // Đánh dấu cho biết thêm mới hay sửa
    TextView title97;  // Title để hiển thị "Thêm sản phẩm" hoặc "Sửa sản phẩm"

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_them_sua);  // Gọi layout

        // Set padding cho layout chính, tránh bị che bởi thanh trạng thái hệ thống
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        addview();
        addevent();
    }

    private void addview() {
        intent97 = getIntent();  // Nhận dữ liệu từ Intent
        trangthai97 = intent97.getStringExtra("TRANGTHAI");  // Lấy trạng thái (thêm hay sửa)

        // Ánh xạ các View
        title97 = findViewById(R.id.title97);
        edtMaSP97 = findViewById(R.id.edtMaSP97);
        edtTenSP97 = findViewById(R.id.edtTenSP97);
        edtSL97 = findViewById(R.id.edtSL97);
        edtDonGia97 = findViewById(R.id.edtDonGia97);
        btnaddsua97 = findViewById(R.id.btnaddsua97);
        btnthoat97 = findViewById(R.id.btnthoat97);

        // Kiểm tra trạng thái (THÊM hoặc SỬA) để thay đổi giao diện
        if ("THEM".equals(trangthai97)) {
            title97.setText("Thêm sản phẩm");
            btnaddsua97.setText("Thêm");
        } else {
            title97.setText("Sửa sản phẩm");
            btnaddsua97.setText("Sửa");

            // Lấy sản phẩm cần sửa và hiển thị thông tin
            SanPham sp = (SanPham) intent97.getSerializableExtra("SANPHAM");
            edtMaSP97.setText(String.valueOf(sp.getMaSanPham()));  // Hiển thị mã sản phẩm
            edtMaSP97.setEnabled(false);  // Không cho phép chỉnh sửa mã sản phẩm
            edtTenSP97.setText(sp.getTenSanPham());  // Hiển thị tên sản phẩm
            edtSL97.setText(String.valueOf(sp.getSoLuong()));  // Hiển thị số lượng
            edtDonGia97.setText(String.valueOf(sp.getDonGia()));  // Hiển thị đơn giá
        }
    }

    private void addevent() {
        // Sự kiện khi người dùng nhấn "Thêm" hoặc "Sửa"
        btnaddsua97.setOnClickListener(v -> {
            // Lấy thông tin sản phẩm từ các EditText
            String maSP = edtMaSP97.getText().toString();
            String tenSP = edtTenSP97.getText().toString();
            String slSP = edtSL97.getText().toString();
            String donGia = edtDonGia97.getText().toString();

            // Kiểm tra thông tin nhập vào và tạo đối tượng SanPham mới
            if (!maSP.isEmpty() && !tenSP.isEmpty() && !slSP.isEmpty() && !donGia.isEmpty()) {
                SanPham sp = new SanPham();
                sp.setMaSanPham(Integer.parseInt(maSP));
                sp.setTenSanPham(tenSP);
                sp.setSoLuong(Integer.parseInt(slSP));
                sp.setDonGia(Double.parseDouble(donGia));

                // Nếu trạng thái là "THEM", gửi đối tượng sản phẩm mới
                if ("THEM".equals(trangthai97)) {
                    intent97.putExtra("SANPHAM", sp);
                    setResult(114, intent97);  // Trả kết quả là 114
                }
                // Nếu trạng thái là "SỬA", cập nhật sản phẩm
                else {
                    intent97.putExtra("SANPHAM", sp);
                    setResult(115, intent97);  // Trả kết quả là 115
                }

                finish();  // Đóng Activity
            } else {
                // Nếu có trường thông tin không hợp lệ, thông báo lỗi
                Toast.makeText(ThemSua.this, "Vui lòng nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
            }
        });

        // Sự kiện khi người dùng nhấn "Thoát"
        btnthoat97.setOnClickListener(v -> {
            finish();  // Đóng Activity và quay lại màn hình trước
        });
    }
}

