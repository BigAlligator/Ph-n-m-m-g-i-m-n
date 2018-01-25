package com.example.ta.quancafe.MainActivity.Model;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by ta on 1/15/2018.
 */

public class HoaDon {
    int MaHD;
    String Noidung;
    String Ngay;
    int Ban;

    public HoaDon(int maHD, String noidung, String ngay, int ban) {
        MaHD = maHD;
        Noidung = noidung;
        Ngay = ngay;
        Ban = ban;
    }

    public int getMaHD() {
        return MaHD;
    }

    public void setMaHD(int maHD) {
        MaHD = maHD;
    }

    public String getNoidung() {
        return Noidung;
    }

    public void setNoidung(String noidung) {
        Noidung = noidung;
    }

    public String getNgay() {
        return Ngay;
    }

    public void setNgay(String ngay) {
        Ngay = ngay;
    }

    public int getBan() {
        return Ban;
    }

    public void setBan(int ban) {
        Ban = ban;
    }
}
