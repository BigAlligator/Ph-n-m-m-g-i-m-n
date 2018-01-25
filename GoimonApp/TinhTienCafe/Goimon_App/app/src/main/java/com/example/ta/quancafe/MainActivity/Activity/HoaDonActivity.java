package com.example.ta.quancafe.MainActivity.Activity;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.ta.quancafe.MainActivity.Adapter.HoaDonAdapter;
import com.example.ta.quancafe.MainActivity.Model.HoaDon;
import com.example.ta.quancafe.MainActivity.Util.Connect;
import com.example.ta.quancafe.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HoaDonActivity extends AppCompatActivity {
    Toolbar toolbarHD;
    ListView lvhd;
    Button btnthoat;
    ArrayList<HoaDon> hoadonArrayList;
    HoaDonAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoa_don);
        Anhxa();
        ActionBar();
        DanhSachHoaDon();
        Thoat();
        chitietHoaDon();
    }

    private void Anhxa() {
        toolbarHD = (Toolbar) findViewById(R.id.toolbarHoadon);
        btnthoat=(Button) findViewById(R.id.buttondong);
        lvhd=(ListView)findViewById(R.id.ListviewHD);
        hoadonArrayList=new ArrayList<>();
        adapter=new HoaDonAdapter(getApplicationContext(),hoadonArrayList);
        lvhd.setAdapter(adapter);

    }
    private void ActionBar() {
        setSupportActionBar(toolbarHD);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarHD.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void DanhSachHoaDon() {
        final RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        String url = Connect.geturl(Connect.urlgetDSHD);
        JsonArrayRequest json =new JsonArrayRequest(com.android.volley.Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                //  Toast.makeText(HoadonActivity.this,response.toString(),Toast.LENGTH_SHORT).show();
                for(int i=0;i<response.length();i++){
                    try {
                        JSONObject object= response.getJSONObject(i);
                        int id=object.getInt("Idhd");
                        String ngay=object.getString("Ngay");
                        String noidung =object.getString("Noidung");
                        int ban=object.getInt("Ban");
                        hoadonArrayList.add(new HoaDon(id,noidung,ngay,ban));
                        adapter.notifyDataSetChanged();


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(HoaDonActivity.this,"LỖi",Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(json);

    }
    private void Thoat() {
        btnthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void chitietHoaDon() {
        lvhd.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HoaDon hd = hoadonArrayList.get(position);
                dialogCTHD(hd);
            }
        });
    }

    private void dialogCTHD(HoaDon hd) {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.chitiethd);
        dialog.setCanceledOnTouchOutside(false);
        TextView txtmahdct=(TextView) dialog.findViewById(R.id.textViewMahdCT);
        TextView txtbanct=(TextView)dialog.findViewById(R.id.textViewBanCT);
        TextView txtngayct=(TextView)dialog.findViewById(R.id.textViewDateCT);
        TextView txtnoidungct=(TextView)dialog.findViewById(R.id.textViewNoidungCT);
        Toolbar toolbarhdct=(Toolbar)dialog.findViewById(R.id.toolbarHoadonCT);
        txtmahdct.setText("Mã hóa đơn: HD"+hd.getMaHD());
        txtbanct.setText("Bàn số: "+hd.getBan());
        txtngayct.setText("Ngày xuất: "+hd.getNgay());
        txtnoidungct.setText(hd.getNoidung());
        dialog.show();
        setSupportActionBar(toolbarhdct);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       toolbarhdct.setNavigationOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               dialog.cancel();
           }
       });

    }
}
