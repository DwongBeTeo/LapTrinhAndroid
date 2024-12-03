package com.example.lap5;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class Lap5_1 extends AppCompatActivity {
    //khai báo đối tượng
    EditText edtMaSo, edtHoTen, numSDT;
    TextView tvNhanVien;
    Button btnThemmoi;
    ListView lvNhanVien;

    ArrayList<String> nhanVienList; //Lưu trữ danh sách các nhân viên trong ứng dụng

    ArrayAdapter<String> adapter;

    //Mục đích:
    //Kết nối (bind) dữ liệu từ ArrayList<String> tới giao diện hiển thị danh sách (ở đây là ListView).
    //Chuyển đổi từng phần tử trong ArrayList thành một mục (item) hiển thị trên ListView.
    //Cách hoạt động:
    //Khi thêm một nhân viên vào nhanVienList, gọi adapter.notifyDataSetChanged() để cập nhật ListView.
    //Mỗi mục trên ListView sẽ hiển thị một chuỗi từ nhanVienList.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lap51);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //ánh xạ id
        edtMaSo = findViewById(R.id.edtMaSo);
        edtHoTen = findViewById(R.id.edtHoTen);
        numSDT = findViewById(R.id.numSDT);
        btnThemmoi = findViewById(R.id.btnThemmoi);
        tvNhanVien = findViewById(R.id.tvNhanVien);
        lvNhanVien = findViewById(R.id.lvNhanVien);

        // Tạo danh sách nhân viên
        nhanVienList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nhanVienList);
        lvNhanVien.setAdapter(adapter);

        //xử lý nút thêm mới
        btnThemmoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maSo = edtMaSo.getText().toString();
                String hoTen = edtHoTen.getText().toString();
                String soDienThoai = numSDT.getText().toString();
                if (maSo.isEmpty() || hoTen.isEmpty() || soDienThoai.isEmpty()) {
                    Toast.makeText(Lap5_1.this, "Vui lòng nhập đầy đủ", Toast.LENGTH_SHORT).show();
                } else {
                    String nhanVien = "Ma: " + maSo + " | HoTen: " + hoTen + " | SoDT: " + soDienThoai;
                    //lưu thông tin nhân viên vào danh sách
                    nhanVienList.add(nhanVien);
                    //hiển thị thông tin nhân viên vừa mới lưu
                    tvNhanVien.setText(nhanVien);
                    // Xóa các Thong tin nhập liệu
                    clearFields();
                }
            }
        });
        // Hiển thị thông tin nhân viên khi click vào danh sách
        lvNhanVien.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Lấy thông tin nhân viên tại vị trí được nhấn
                //getItemAtPosition(position): Lấy dữ liệu tại vị trí position trong ListView
                String nhanVien = (String) parent.getItemAtPosition(position);

                // Tách thông tin nhân viên thành các phần riêng biệt
                //split(" \\| "): Tách chuỗi nhanVien thành một mảng nhỏ hơn, dựa trên ký tự phân cách " | " .
                String[] info = nhanVien.split("\\| ");

                // Loại bỏ phần mô tả không cần thiết
                String maSo = info[0].replace("Ma: ", "");
                String hoTen = info[1].replace("HoTen: ", "");
                String soDT = info[2].replace("SoDT: ", "");

                // Hiển thị thông tin lên các EditText
                edtMaSo.setText(maSo);
                edtHoTen.setText(hoTen);
                numSDT.setText(soDT);
            }
        });
    }

    // Hàm xóa nội dung các EditText
    private void clearFields() {
        edtMaSo.setText("");
        edtHoTen.setText("");
        numSDT.setText("");
    }
}