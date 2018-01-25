package com.example.ta.quancafe.MainActivity.Model;

/**
 * Created by ta on 1/14/2018.
 */

public class ThanhToan {
    public String Ten;
    public int Sol;
    public int Gia;

    public ThanhToan(String ten, int sol, int gia) {
        Ten = ten;
        Sol = sol;
        Gia = gia;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public int getSol() {
        return Sol;
    }

    public void setSol(int sol) {
        Sol = sol;
    }

    public int getGia() {
        return Gia;
    }

    public void setGia(int gia) {
        Gia = gia;
    }
}
