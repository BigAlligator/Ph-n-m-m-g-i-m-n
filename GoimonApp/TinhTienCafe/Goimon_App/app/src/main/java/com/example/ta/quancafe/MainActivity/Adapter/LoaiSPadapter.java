package com.example.ta.quancafe.MainActivity.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ta.quancafe.MainActivity.Activity.MainActivity;
import com.example.ta.quancafe.MainActivity.Activity.SanPhamActivity;
import com.example.ta.quancafe.MainActivity.Model.LoaiSP;
import com.example.ta.quancafe.MainActivity.Model.SanPham;
import com.example.ta.quancafe.R;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by ta on 1/13/2018.
 */

public class LoaiSPadapter extends RecyclerView.Adapter<LoaiSPadapter.ViewHolder> {
    Context context;
    ArrayList<LoaiSP> loaispArrayList;

    public LoaiSPadapter(Context context, ArrayList<LoaiSP> loaispArrayList) {
        this.context = context;
        this.loaispArrayList = loaispArrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.loaisp_layout,null);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        LoaiSP loaisp = loaispArrayList.get(position);
        holder.txtTenloaisp.setText(loaisp.getTenSP());
        String urlHinh = loaisp.getHinhAnhLoaiSP().replace("localhost", MainActivity.ip+"/cuahangcafe");
        Picasso.with(context).load(urlHinh).into(holder.hinhloaisp);
    }

    @Override
    public int getItemCount() {
        return loaispArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtTenloaisp ;
        ImageView hinhloaisp;
        public ViewHolder(View itemView) {
            super(itemView);
            txtTenloaisp = (TextView) itemView.findViewById(R.id.txtTenTheLoai);
            hinhloaisp=(ImageView)itemView.findViewById(R.id.imgTheLoai);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context,SanPhamActivity.class);
                    intent.putExtra("ABC", (Serializable) loaispArrayList.get(getPosition()));
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            });

        }
    }
}
