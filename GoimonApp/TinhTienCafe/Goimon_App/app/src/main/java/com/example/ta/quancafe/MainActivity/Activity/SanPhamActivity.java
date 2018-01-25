package com.example.ta.quancafe.MainActivity.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ta.quancafe.MainActivity.Adapter.SanPhamAdapter;
import com.example.ta.quancafe.MainActivity.Model.LoaiSP;
import com.example.ta.quancafe.MainActivity.Model.SanPham;
import com.example.ta.quancafe.R;

import java.util.ArrayList;

public class SanPhamActivity extends AppCompatActivity {
    Button btnThanhtoan,btnTieptuc,btnHuy;
    ListView listsp;
    Toolbar toolbarsp;
    TextView txtmenu;
    ArrayList<SanPham> mangsp;
    SanPhamAdapter adaptersp;
    int idl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_san_pham);
        anhxa();

        LoaiSP lsp = (LoaiSP) getIntent().getSerializableExtra("ABC");
        idl=lsp.getId();
        txtmenu.setText(lsp.getTenSP());
        actionBar();
        Huy();
        loadSP();
        thanhtoan();
        Tieptuc();
}

    private void Tieptuc()
    {
        btnTieptuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private  void  actionBar()
    {
        setSupportActionBar(toolbarsp);
      getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarsp.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void Huy()
    {
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SanPhamActivity.this,MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
    private void loadSP() {
        for (int i=0 ; i<MainActivity.sanPhams.size();i++){
            int IDLoaiSP = MainActivity.sanPhams.get(i).getIDLoaiSP();
            if(IDLoaiSP==idl){
                int idsp = MainActivity.sanPhams.get(i).getIDSanPham();
                String tensp = MainActivity.sanPhams.get(i).getTenSP();
                String hinh = MainActivity.sanPhams.get(i).getHinhAnhSP();
                int gia=MainActivity.sanPhams.get(i).getGia();
                int sol=MainActivity.sanPhams.get(i).getSoLuongMua();
                mangsp.add(new SanPham(idsp,tensp,hinh,gia,sol,IDLoaiSP));
                adaptersp.notifyDataSetChanged();
            }
        }
    }
    private void anhxa()
    {
        listsp = (ListView) findViewById(R.id.ListviewSp);
        toolbarsp = (Toolbar) findViewById(R.id.toolbarSanpham);
        txtmenu =(TextView)findViewById(R.id.textmenu);
        btnThanhtoan=(Button)findViewById(R.id.buttonthantoan);
        btnTieptuc=(Button)findViewById(R.id.buttontieptuc);
        btnHuy=(Button)findViewById(R.id.buttonhuy);
        mangsp = new ArrayList<>();
        adaptersp = new SanPhamAdapter(SanPhamActivity.this,mangsp);
        listsp.setAdapter(adaptersp);
    }


    private void thanhtoan() {
        btnThanhtoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SanPhamActivity.this,ThanhToanActivity.class);
                startActivity(intent);
            }
        });
    }

}
