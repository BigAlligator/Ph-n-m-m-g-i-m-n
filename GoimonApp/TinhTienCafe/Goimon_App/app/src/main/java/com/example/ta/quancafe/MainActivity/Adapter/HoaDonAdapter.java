package com.example.ta.quancafe.MainActivity.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ta.quancafe.MainActivity.Model.HoaDon;
import com.example.ta.quancafe.MainActivity.Util.Connect;
import com.example.ta.quancafe.R;

import java.util.ArrayList;

/**
 * Created by ta on 1/15/2018.
 */

public class HoaDonAdapter extends BaseAdapter {
    Context context;
    ArrayList<HoaDon> hoadonArrayList;

    public HoaDonAdapter(Context context, ArrayList<HoaDon> hoadonArrayList) {
        this.context = context;
        this.hoadonArrayList = hoadonArrayList;
    }

    public class ViewHolder{
        TextView txtMahd,txtban,txtngay,txtnoidung;
    }
    @Override
    public int getCount() {
        return hoadonArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){

            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.hoadon_dong,null);
            holder.txtMahd=(TextView)convertView.findViewById(R.id.textViewMahd);
            holder.txtban=(TextView)convertView.findViewById(R.id.textViewBan);
            holder.txtngay=(TextView)convertView.findViewById(R.id.textViewDate);
            holder.txtnoidung=(TextView)convertView.findViewById(R.id.textViewNoidung);
            convertView.setTag(holder);
        }else {holder= (ViewHolder) convertView.getTag();}
        HoaDon hd= hoadonArrayList.get(position);
        holder.txtMahd.setText("Mã hóa đơn: HD"+hd.getMaHD());
        holder.txtban.setText("Bàn số: "+hd.getBan());
        holder.txtngay.setText("Ngày xuất: "+hd.getNgay());
        holder.txtnoidung.setText("Tổng tiền: "+ Connect.catchuoi(hd.getNoidung()));
        return convertView;
    }
}
