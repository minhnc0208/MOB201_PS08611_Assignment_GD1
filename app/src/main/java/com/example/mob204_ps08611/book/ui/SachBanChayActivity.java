package com.example.mob204_ps08611.book.ui;


import android.os.Bundle;
import android.widget.ListView;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;


import com.example.dell.book.R;
import com.example.mob204_ps08611.book.model.SachBanChay;

import java.util.ArrayList;
import java.util.List;

public class SachBanChayActivity extends AppCompatActivity {
    private ListView listView;
    private List<SachBanChay> sachBanChayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sach_ban_chay);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        listView = findViewById(R.id.customlvsachbanchay);
        sachBanChayList = new ArrayList<>();


    }


}

