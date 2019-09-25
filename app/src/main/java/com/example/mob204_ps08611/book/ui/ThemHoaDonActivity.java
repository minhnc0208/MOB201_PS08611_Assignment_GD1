package com.example.mob204_ps08611.book.ui;

import android.app.DatePickerDialog;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;


import com.example.dell.book.R;
import com.example.mob204_ps08611.book.dao.HoaDonDao;
import com.example.mob204_ps08611.book.model.HoaDon;

import java.util.Calendar;

public class ThemHoaDonActivity extends AppCompatActivity {

    private EditText edtMaHoaDonHoaDon;
    private TextView tvChonNgay;
    private Button btnChonNgay;
    private Button btnThemThemHoaDon;
    private Button btnHuyThemHoaDon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_hoa_don);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        initView();

        btnChonNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                final int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(ThemHoaDonActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        btnChonNgay.setText(year + "-" + month + "-" + dayOfMonth);
                        //?????

                    }
                }, year, month, day);


                datePickerDialog.show();
            }
        });
        btnThemThemHoaDon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maHoaDon = edtMaHoaDonHoaDon.getText().toString().trim();
                if (maHoaDon.matches("") | maHoaDon.length() >7){
                    edtMaHoaDonHoaDon.setError("lỗi");
                    return;
                }

                String ngayMua = btnThemThemHoaDon.getText().toString().trim();

                if (ngayMua.equals("chọn thời gian")){

                    showMessage("vui lòng chọn time");
                    return;
                }


                HoaDonDao billDAO = new HoaDonDao(ThemHoaDonActivity.this);

                HoaDon bill = new HoaDon();
                bill.maHoaDon = maHoaDon;
                bill.ngayMua = ngayMua;

                long result = billDAO.insertHoaDon(bill);

                if (result > 0){
                    showMessage("thêm thành công");
                }else {
                    showMessage("có lỗi");
                }

            }
        });
    }

    public void showDatePicker() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        // thiet lap thong tin cho date picker

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Integer n = year;
                Integer t = month;
                Integer d = dayOfMonth;
                tvChonNgay.setText(d.toString() + "-" + t.toString() + "-" + n.toString());
            }
        }, year, month, day);

        datePickerDialog.show();
    }

    private void initView() {
        edtMaHoaDonHoaDon = (EditText) findViewById(R.id.edMaHoaDon_HoaDon);
        tvChonNgay = (TextView) findViewById(R.id.tvChonNgay);
        btnChonNgay = (Button) findViewById(R.id.btnChonNgay);
        btnThemThemHoaDon = (Button) findViewById(R.id.btnThem_ThemHoaDon);
        btnHuyThemHoaDon = (Button) findViewById(R.id.btnHuy_ThemHoaDon);
    }
    public void showMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

}
