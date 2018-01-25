package com.example.ta.quancafe.MainActivity.Model;

/**
 * Created by ta on 1/13/2018.
 */

public class SanPham {
    int IDSanPham;
    String TenSP,HinhAnhSP;
    int Gia;
    int SoLuongMua;
    int IDLoaiSP;

    public SanPham(int IDSanPham, String tenSP, String hinhAnhSP, int gia, int soLuongMua, int IDLoaiSP) {
        this.IDSanPham = IDSanPham;
        TenSP = tenSP;
        HinhAnhSP = hinhAnhSP;
        Gia = gia;
      SoLuongMua = soLuongMua;
        this.IDLoaiSP = IDLoaiSP;
    }

    public int getIDSanPham() {
        return IDSanPham;
    }

    public void setIDSanPham(int IDSanPham) {
        this.IDSanPham = IDSanPham;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String tenSP) {
        TenSP = tenSP;
    }

    public String getHinhAnhSP() {
        return HinhAnhSP;
    }

    public void setHinhAnhSP(String hinhAnhSP) {
        HinhAnhSP = hinhAnhSP;
    }

    public int getGia() {
        return Gia;
    }

    public void setGia(int gia) {
        Gia = gia;
    }

    public int getSoLuongMua() {
        return SoLuongMua;
    }

    public void setSoLuongMua(int soLuongMua) {
       SoLuongMua = soLuongMua;
    }

    public int getIDLoaiSP() {
        return IDLoaiSP;
    }

    public void setIDLoaiSP(int IDLoaiSP) {
        this.IDLoaiSP = IDLoaiSP;
    }
}
