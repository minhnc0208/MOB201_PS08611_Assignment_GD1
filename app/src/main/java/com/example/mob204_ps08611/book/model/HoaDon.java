package com.example.mob204_ps08611.book.model;

import java.util.Date;

public class HoaDon {
    public String maHoaDon;
    public String ngayMua;
    public HoaDon(){

    }

    public HoaDon(String maHoaDon, String ngayMua) {
        this.maHoaDon = maHoaDon;
        this.ngayMua = ngayMua;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(String ngayMua) {
        this.ngayMua = ngayMua;
    }
}
