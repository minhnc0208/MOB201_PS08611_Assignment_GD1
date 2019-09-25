package com.example.mob204_ps08611.book.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.example.dell.book.R;
import com.example.mob204_ps08611.book.dao.NguoiDungDao;
import com.example.mob204_ps08611.book.database.DatabaseHelper;
import com.example.mob204_ps08611.book.model.NguoiDung;


public class LoginActivity extends AppCompatActivity {

    private EditText edtUsername;
    private EditText edtPassword;
    private CheckBox cbRemember;
    private Button btnLogin;
    String strUser, strPass;
    NguoiDungDao nguoiDungDao;
    private DatabaseHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("ĐĂNG NHẬP");

        edtUsername = (EditText) findViewById(R.id.edtUsername);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        cbRemember = (CheckBox) findViewById(R.id.cbRemember);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        nguoiDungDao = new NguoiDungDao(getApplicationContext());

        NguoiDung user2;
        user2 = nguoiDungDao.getUser("admin");
        if (user2 == null) {
            NguoiDung user3 = new NguoiDung("admin", "1234567", "0568031652", "Nguyen Cao Minh");
            nguoiDungDao.insertNguoiDung(user3);
        }
        checkLogin();

            edtUsername.setText("admin");
            edtPassword.setText("1234567");


        }


    public void checkLogin() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String userName = edtUsername.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();
                if (password.length() < 6 || userName.isEmpty() || password.isEmpty()) {

                    if (userName.isEmpty())
                        edtUsername.setError(getString(R.string.notify_empty_user));

                    if (password.isEmpty())
                        edtPassword.setError(getString(R.string.notify_empty_pass));


                } else {


                    NguoiDung user = nguoiDungDao.getUser(userName);
                    if (user != null && user.getUserName() != null) {
                        if (password.matches(user.getPassword())) {
                            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                            startActivity(intent);
                            finish();
                            Toast.makeText(LoginActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        } else {

                            Toast.makeText(LoginActivity.this, "Tài khoản hoặc mật khẩu chưa chính xác", Toast.LENGTH_SHORT).show();

                        }
                    } else {
                        Toast.makeText(LoginActivity.this, "Bạn chưa có tài khoản", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }



    public void rememberUser(String u, String p, boolean status) {
        SharedPreferences pref = getSharedPreferences("USER_FILE", MODE_PRIVATE);
        SharedPreferences.Editor edit = pref.edit();
        if (!status) {
            edit.clear();
        } else {
            edit.putString("USERNAME", u);
            edit.putString("PASSWORD", p);
            edit.putBoolean("REMEMBER", status);
        }
        edit.commit();
    }


}
