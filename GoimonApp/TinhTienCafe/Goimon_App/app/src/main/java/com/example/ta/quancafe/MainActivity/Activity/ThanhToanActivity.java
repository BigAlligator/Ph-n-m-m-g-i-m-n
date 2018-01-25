package com.example.ta.quancafe.MainActivity.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ta.quancafe.MainActivity.Adapter.ThanhToanAdapter;
import com.example.ta.quancafe.MainActivity.Model.ThanhToan;
import com.example.ta.quancafe.MainActivity.Util.Connect;
import com.example.ta.quancafe.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class ThanhToanActivity extends AppCompatActivity {
    Toolbar toolbarThanhToan;
    TextView txtTong;
    Button btnThanhtoanHD,btnHuyHD;
    Spinner spin;
    ListView lvgh;
    ArrayList<ThanhToan> thanhToanArrayList;
    ThanhToanAdapter thanhToanAdapter;
    TextView txtdate;
    String noidungHD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanh_toan);
        Anhxa();
        getHoaDon();
        soBan();
        ActionBar();
        thanhtoan();
        Huy();
    }
    private void Anhxa() {
        toolbarThanhToan=(Toolbar)findViewById(R.id.toolbarThanhToan);
        lvgh=(ListView)findViewById(R.id.ListviewThanhToan);
        txtTong=(TextView)findViewById(R.id.textViewTong);
        btnHuyHD=(Button)findViewById(R.id.buttonHuyHD);
        btnThanhtoanHD=(Button)findViewById(R.id.buttonThanhtoanHD);
        spin=(Spinner)findViewById(R.id.spinnerBan);
        thanhToanArrayList = new ArrayList<>();
        thanhToanAdapter = new ThanhToanAdapter(ThanhToanActivity.this,thanhToanArrayList);
        lvgh.setAdapter(thanhToanAdapter);
        txtdate=(TextView)findViewById(R.id.textdate);
        Calendar calendar = Calendar.getInstance();
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("dd/MM/yyyy");
        txtdate.setText(simpleDateFormat.format(calendar.getTime()));

    }
    private void soBan() {
        Integer[] soban = new Integer[]{1,2,3,4,5,6,7,8,9,10};
        ArrayAdapter<Integer> arrayadapter= new ArrayAdapter<Integer>(this,android.R.layout.simple_spinner_dropdown_item,soban);
        spin.setAdapter(arrayadapter);
    }
    private void ActionBar() {
        setSupportActionBar(toolbarThanhToan);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarThanhToan.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void getHoaDon() {
        int tongtien=0;noidungHD="";
        for(int i=0;i<MainActivity.sanPhams.size();i++){
            if(MainActivity.sanPhams.get(i).getSoLuongMua()>0){
                String ten=MainActivity.sanPhams.get(i).getTenSP();
                int sol =MainActivity.sanPhams.get(i).getSoLuongMua();
                int gia = MainActivity.sanPhams.get(i).getGia();
                int thanhtien = sol*gia;
                tongtien=tongtien+thanhtien;
                thanhToanArrayList.add(new ThanhToan(ten,sol,gia));
                noidungHD=noidungHD+ten+" : "+sol+" : "+Connect.Money(thanhtien)+"\n";
            }
        }thanhToanAdapter.notifyDataSetChanged();txtTong.setText(Connect.Money(tongtien));
        noidungHD=noidungHD+"Tổng tiền thanh toán :     "+Connect.Money(tongtien)+"\n";
    }
    private void Huy() {
        btnHuyHD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ThanhToanActivity.this,MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
    private void thanhtoan() {
        btnThanhtoanHD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(thanhToanArrayList.size()<=0){
                    Toast.makeText(ThanhToanActivity.this,"Chưa đặt hàng!",Toast.LENGTH_SHORT).show();
                }else {
                    String ban = spin.getSelectedItem().toString();
                    luuHD();
                    Toast.makeText(ThanhToanActivity.this,"Đã thanh toán đơn hàng bàn số: "+ban+"!",Toast.LENGTH_SHORT).show();}
                Intent intent = new Intent(ThanhToanActivity.this,MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    private void luuHD(){
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest request=new StringRequest(Request.Method.POST, Connect.geturl(Connect.urlHoadon), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> hashMap = new HashMap<String, String>();
                hashMap.put("Ngay",txtdate.getText().toString());
                hashMap.put("Noidung",noidungHD);
                hashMap.put("Ban",spin.getSelectedItem().toString());
                return hashMap;
            }
        };requestQueue.add(request);
    }
}
