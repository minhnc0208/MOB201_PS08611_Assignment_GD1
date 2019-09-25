package com.example.mob204_ps08611.book.ui;

import android.content.Intent;
import android.os.CountDownTimer;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dell.book.R;


public class ManHinhChaoActivity extends AppCompatActivity {
    private ImageView imghello;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manhinhchao);

        CountDownTimer countDownTimer = new CountDownTimer(2000,2000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                finish();
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
            }
        }.start();

    }
}
