package com.example.ta.quancafe.MainActivity.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ta.quancafe.MainActivity.Activity.MainActivity;
import com.example.ta.quancafe.MainActivity.Activity.SanPhamActivity;
import com.example.ta.quancafe.MainActivity.Model.SanPham;
import com.example.ta.quancafe.MainActivity.Util.Connect;
import com.example.ta.quancafe.R;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by ta on 1/14/2018.
 */

public class SanPhamAdapter extends BaseAdapter {
    Context context;
    ArrayList<SanPham> sanPhamArrayList;
    public static ArrayList<SanPham> sanPhams;

    public SanPhamAdapter(Context context, ArrayList<SanPham> sanPhamArrayList) {
        this.context = context;
        this.sanPhamArrayList = sanPhamArrayList;
    }

    @Override
    public int getCount() {
        return sanPhamArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    public class ViewHolder{
        ImageView imgHinhsp;
        TextView txtTensp,txtGiasp,txtso,txtid;
        Button btncong,btntru,btnval;


    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if(convertView==null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.item_sanpham,null);
            holder.txtso=(TextView)convertView.findViewById(R.id.textViewso);
            holder.imgHinhsp=(ImageView) convertView.findViewById(R.id.imagesp);
            holder.txtTensp=(TextView) convertView.findViewById(R.id.texttensp);
            holder.txtGiasp=(TextView)convertView.findViewById(R.id.textgiasp);
            holder.btncong=(Button)convertView.findViewById(R.id.buttoncong);
            holder.btntru=(Button)convertView.findViewById(R.id.buttontru);
            holder.btnval=(Button)convertView.findViewById(R.id.buttonval);
            holder.txtid=(TextView)convertView.findViewById(R.id.textViewid);
            convertView.setTag(holder);
        }else {
            holder=(ViewHolder)convertView.getTag();
        }
        final SanPham sp = sanPhamArrayList.get(position);
        holder.btnval.setText(sp.getSoLuongMua()+"");
        holder.txtTensp.setText(sp.getTenSP());
        holder.txtid.setText(sp.getIDSanPham()+"");
        holder.txtso.setText(sp.getGia()+"");
        DecimalFormat deci = new DecimalFormat("###,###,###");
        holder.txtGiasp.setText("Giá: "+deci.format(sp.getGia())+" Đ");
        Picasso.with(context).load(Connect.geturl(sp.getHinhAnhSP())).into(holder.imgHinhsp);
        holder.btncong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int soluong = Integer.parseInt(holder.btnval.getText().toString());
                if(soluong ==10){return;}
                soluong = soluong+1;
                holder.btnval.setText(soluong+"");
                int id = sanPhamArrayList.get(position).getIDSanPham();
                for(int i = 0; i< MainActivity.sanPhams.size(); i++){
                    if(MainActivity.sanPhams.get(i).getIDSanPham()==id){
                        MainActivity.sanPhams.get(i).setSoLuongMua(soluong);
                    }
                }
            }
        });
        holder.btntru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int soluong = Integer.parseInt(holder.btnval.getText().toString());
                if(soluong ==0){return;}
                soluong = soluong-1;
                holder.btnval.setText(soluong+"");
                int id = sanPhamArrayList.get(position).getIDSanPham();
                for(int i=0;i<MainActivity.sanPhams.size();i++){
                    if(MainActivity.sanPhams.get(i).getIDSanPham()==id){
                        MainActivity.sanPhams.get(i).setSoLuongMua(soluong);
                    }
                }

            }
        });
        return convertView;
    }
}
