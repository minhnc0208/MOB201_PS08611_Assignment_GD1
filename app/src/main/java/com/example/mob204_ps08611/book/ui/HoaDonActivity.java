package com.example.mob204_ps08611.book.ui;

import android.content.Intent;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;


import com.example.dell.book.R;
import com.example.mob204_ps08611.book.adapter.BillAdapter;
import com.example.mob204_ps08611.book.dao.HoaDonDao;
import com.example.mob204_ps08611.book.model.HoaDon;

import java.util.ArrayList;
import java.util.List;

public class HoaDonActivity extends AppCompatActivity {
    private ListView listView;
    BillAdapter billAdapter=null;
    public static List<HoaDon> dshoaDons=new ArrayList<>();
    HoaDonDao hoaDonDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoa_don);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        listView=findViewById(R.id.customlvhoadon);
        dshoaDons = new ArrayList<>();
        hoaDonDao= new HoaDonDao(HoaDonActivity.this);



        dshoaDons = hoaDonDao.getAllHoaDon();


        billAdapter = new BillAdapter(dshoaDons,this);
        listView.setAdapter(billAdapter);

    }

    // @Override
   /* protected void onResume() {
        super.onResume();
       dshoaDons.clear();
        try {
            dshoaDons = hoaDonDao.getAllHoaDon();
            billAdapter.changeDataset(hoaDonDao.getAllHoaDon());
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuhoadon, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemaddhoadon:
                Intent a = new Intent(HoaDonActivity.this,ThemHoaDonActivity.class);
                startActivity(a);
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
