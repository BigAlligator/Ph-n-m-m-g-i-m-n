package com.example.ta.quancafe.MainActivity.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ta.quancafe.MainActivity.Model.ThanhToan;
import com.example.ta.quancafe.MainActivity.Util.Connect;
import com.example.ta.quancafe.R;

import java.util.ArrayList;

/**
 * Created by ta on 1/15/2018.
 */

public class ThanhToanAdapter extends BaseAdapter {
    Context context;
    ArrayList<ThanhToan> thanhToanArrayList;

    public ThanhToanAdapter(Context context, ArrayList<ThanhToan> thanhToanArrayList) {
        this.context = context;
        this.thanhToanArrayList = thanhToanArrayList;
    }

    @Override
    public int getCount() {
        return thanhToanArrayList.size();
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
        TextView txtTenThanhToan,txtSoluong,txtThanhtien;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.thanhtoan_dong,null);
            holder.txtTenThanhToan=(TextView)convertView.findViewById(R.id.textViewTen);
            holder.txtSoluong=(TextView)convertView.findViewById(R.id.textViewSol);
            holder.txtThanhtien=(TextView)convertView.findViewById(R.id.textViewThanhtien);
            convertView.setTag(holder);
        }else {holder= (ViewHolder) convertView.getTag();}
        ThanhToan gh= thanhToanArrayList.get(position);
        holder.txtTenThanhToan.setText(gh.getTen());
        holder.txtSoluong.setText(gh.getSol()+"");
        int tien=gh.getSol()*gh.getGia();

        holder.txtThanhtien.setText(Connect.Money(tien));
        return convertView;
    }



}
