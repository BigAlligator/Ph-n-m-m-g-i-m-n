package com.example.ta.quancafe.MainActivity.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ta.quancafe.MainActivity.Adapter.LoaiSPadapter;
import com.example.ta.quancafe.MainActivity.Model.LoaiSP;
import com.example.ta.quancafe.MainActivity.Model.SanPham;
import com.example.ta.quancafe.MainActivity.Util.Connect;
import com.example.ta.quancafe.R;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    Button btnDangNhap,btnHuy;
    EditText txtDangNhap;
    Toolbar toolbar ;
    ViewFlipper viewFlipper;
    RecyclerView recyclerViewmanhinhchinh;
   ArrayList<LoaiSP> arrayLoaisp;
    LoaiSPadapter loaispAdapter;
    public static ArrayList<SanPham> sanPhams;
    public static String ip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Anhxa();
        ActionBar();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.thanhtoan,menu);
        getMenuInflater().inflate(R.menu.hodon,menu);
        getMenuInflater().inflate(R.menu.thoat,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent,intent1;
        switch (item.getItemId()){
            case R.id.menuthanhtoan:
                intent = new Intent(getApplicationContext(),ThanhToanActivity.class);
                startActivity(intent);
                break;
            case R.id.menuhoadon:
                intent = new Intent(getApplicationContext(),HoaDonActivity.class);
                startActivity(intent);
                break;
            case R.id.menuthoat:
                finish();
                System.exit(0);
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    private void DangNhap() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dangnhap);
        dialog.setCanceledOnTouchOutside(false);
        final EditText edtip = (EditText) dialog.findViewById(R.id.editTextlocalhost);
        btnDangNhap = (Button) dialog.findViewById(R.id.buttonDangnhap);
       btnHuy = (Button) dialog.findViewById(R.id.buttonHuyDangnhap);
        dialog.show();
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ip = edtip.getText().toString().trim();
                String url = Connect.geturl(Connect.urlconnect);
                RequestQueue request = Volley.newRequestQueue(getApplicationContext());
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(MainActivity.this, "Kết nối thành công!", Toast.LENGTH_SHORT).show();
                        Slide();
                        getSPData();
                        addMenu();
                        dialog.cancel();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Lỗi kết nối", Toast.LENGTH_SHORT).show();
                    }
                });
                request.add(stringRequest);
            }
        });
    }


    private void getSPData() {
        String url = Connect.geturl(Connect.urlAllsp);
        RequestQueue request = Volley.newRequestQueue(this);
        JsonArrayRequest json =new JsonArrayRequest(com.android.volley.Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<response.length();i++){
                    try {
                        JSONObject object= response.getJSONObject(i);
                        int id=object.getInt("Id");
                        String tensp=object.getString("TenSp");
                        String hinhsp = object.getString("HinhAnhSP").replace("localhost",ip+"/cuahangcafe");
                        int gia =object.getInt("Gia");
                        int idl=object.getInt("IdLoai");
                        int soluongmua = 0;
                        sanPhams.add(new SanPham(id,tensp,hinhsp,gia,soluongmua,idl));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,"LỖi",Toast.LENGTH_SHORT).show();
            }
        });
        request.add(json);
    }

    private void Anhxa() {
        toolbar = (Toolbar) findViewById(R.id.toolbarMain);
        viewFlipper =(ViewFlipper) findViewById(R.id.fliperMenu);
        recyclerViewmanhinhchinh=(RecyclerView) findViewById(R.id.recycleMenu);
        sanPhams = new ArrayList<>();
        if (ip==null){DangNhap();}else {
            Slide();
            getSPData();
            addMenu();}
    }

    private void Slide() {
        ArrayList<String> slide = new ArrayList<>();
        slide.add(Connect.geturl(Connect.urlHinh1));
        slide.add(Connect.geturl(Connect.urlHinh2));
        slide.add(Connect.geturl(Connect.urlHinh3));
        slide.add(Connect.geturl(Connect.urlHinh4));
        for (int i =0;i<slide.size();i++){
            ImageView imag = new ImageView(getApplicationContext());
            Picasso.with(getApplicationContext()).load(slide.get(i)).into(imag);
            imag.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imag);
            viewFlipper.setFlipInterval(5000);
            viewFlipper.setAutoStart(true);
            Animation animin = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);

            Animation animout =AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);
            animin.setDuration(3000);
            animout.setDuration(3000);
            viewFlipper.setInAnimation(animin);
            viewFlipper.setOutAnimation(animout);

        }

    }

    private void addMenu() {

        arrayLoaisp = new ArrayList<>();
        loaispAdapter = new LoaiSPadapter(getApplicationContext(),arrayLoaisp);
        recyclerViewmanhinhchinh.setHasFixedSize(true);
        GridLayoutManager grid = new GridLayoutManager(getApplicationContext(),2);
        recyclerViewmanhinhchinh.setLayoutManager(grid);
        DividerItemDecoration div = new DividerItemDecoration(this,grid.getOrientation());
        recyclerViewmanhinhchinh.addItemDecoration(div);
        recyclerViewmanhinhchinh.setAdapter(loaispAdapter);
        RequestQueue request= Volley.newRequestQueue(this);
        String url =Connect.geturl(Connect.urlloaisp);
        JsonArrayRequest json =new JsonArrayRequest(com.android.volley.Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<response.length();i++){
                    try {
                        JSONObject object= response.getJSONObject(i);
                        int id=object.getInt("Id");
                        String tenloiasp=object.getString("TenLoaiSP");
                        String hinhloaisp = object.getString("HinhAnhLoaiSP").replace("localhost",ip+"/cuahangcafe");
                        arrayLoaisp.add(new LoaiSP(id,tenloiasp,hinhloaisp));
                        loaispAdapter.notifyDataSetChanged();


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,"Lỗi!",Toast.LENGTH_SHORT).show();
            }
        });
        request.add(json);


    }

    private void ActionBar() {
        setSupportActionBar(toolbar);
    }
}
