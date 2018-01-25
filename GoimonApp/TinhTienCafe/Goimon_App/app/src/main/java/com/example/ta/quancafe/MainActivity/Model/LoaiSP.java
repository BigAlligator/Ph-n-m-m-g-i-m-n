package com.example.ta.quancafe.MainActivity.Model;

import java.io.Serializable;

/**
 * Created by ta on 1/13/2018.
 */

public class LoaiSP implements Serializable{


    int id;
    String TenSP;
    String HinhAnhLoaiSP;

    public LoaiSP(int id, String tenSP, String hinhAnhLoaiSP) {
        this.id = id;
        TenSP = tenSP;
        HinhAnhLoaiSP = hinhAnhLoaiSP;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String tenSP) {
        TenSP = tenSP;
    }

    public String getHinhAnhLoaiSP() {
        return HinhAnhLoaiSP;
    }

    public void setHinhAnhLoaiSP(String hinhAnhLoaiSP) {
        HinhAnhLoaiSP = hinhAnhLoaiSP;
    }
}
