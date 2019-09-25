package com.example.mob204_ps08611.book.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dell.book.R;

import com.example.mob204_ps08611.book.dao.HoaDonDao;
import com.example.mob204_ps08611.book.model.HoaDon;

import java.util.List;


public class BillAdapter extends BaseAdapter {
    List<HoaDon> hoaDons;
    public Activity context;
    public LayoutInflater inflater;
    HoaDonDao hoaDonDao;

    public BillAdapter(List<HoaDon> hoaDons, Activity context) {
        this.hoaDons = hoaDons;
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        hoaDonDao = new HoaDonDao(context);
    }

    @Override
    public int getCount() {
        return hoaDons.size();
    }

    @Override
    public Object getItem(int position) {
        return hoaDons.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public static class ViewHolder {
        ImageView imgavatarbill;
        TextView txtMahd;
        TextView txtNgay;
        ImageView imgDelete;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder ;
        if (convertView == null) {
            holder= new ViewHolder();
            convertView = inflater.inflate(R.layout.customhoadon, null);
            holder.imgavatarbill = (ImageView) convertView.findViewById(R.id.imgavatarhoadon);
            holder.txtMahd = (TextView) convertView.findViewById(R.id.tvmahoadon);
            holder.txtNgay= (TextView) convertView.findViewById(R.id.tvngayhoadon);
            holder.imgDelete = (ImageView) convertView.findViewById(R.id.imgdeletehoadon);
//            holder.iconchangepassword = (ImageView) convertView.findViewById(R.id.imgchangepass);
            holder.imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    hoaDonDao.deleteHoaDon(hoaDons.get(position).maHoaDon);
                    hoaDons.remove(position);
                    notifyDataSetChanged();
                }
            });
//            holder.iconchangepassword.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent=new Intent(context,DoiMatKhauActivity.class);
//                    Bundle bundle=new Bundle();
//                    bundle.putString("username1",holder.txtName.getText().toString());
//                    intent.putExtra("key",bundle);
//                    context.startActivity(intent);
//                }
//            });
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();
        HoaDon _entryHD = (HoaDon) hoaDons.get(position);
        if (position % 3 == 0) {
            holder.imgavatarbill.setImageResource(R.drawable.emone);
        } else if (position % 3 == 1) {
            holder.imgavatarbill.setImageResource(R.drawable.emtwo);
        } else {
            holder.imgavatarbill.setImageResource(R.drawable.emthree);
        }
        holder.txtMahd.setText(_entryHD.getMaHoaDon());
        holder.txtNgay.setText(_entryHD.ngayMua);
        return convertView;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    public void changeDataset(List<HoaDon> items){
        this.hoaDons=items;
        notifyDataSetChanged();
    }
}
