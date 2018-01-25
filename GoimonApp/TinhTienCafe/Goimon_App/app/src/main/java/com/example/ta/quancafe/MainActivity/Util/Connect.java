package com.example.ta.quancafe.MainActivity.Util;

import android.text.format.Formatter;
import android.util.Log;

import com.example.ta.quancafe.MainActivity.Activity.MainActivity;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.text.DecimalFormat;
import java.util.Enumeration;

/**
 * Created by ta on 1/13/2018.
 */

public class Connect {
    public static String urlloaisp="http://localhost/cuahangcafe/getLoaisanpham.php";

    public static String urlAllsp="http://localhost/cuahangcafe/getAllsp.php";
    public static String urlHinh1="http://localhost/cuahangcafe/hinhanh/images1.jpg";
    public static String urlHinh2="http://localhost/cuahangcafe/hinhanh/images3.jpg";
    public static String urlHinh3="http://localhost/cuahangcafe/hinhanh/images5.jpg";
    public static String urlHinh4="http://localhost/cuahangcafe/hinhanh/images6.jpg";
    public static String urlHoadon="http://localhost/cuahangcafe/dshoadon.php";
    public static String urlgetDSHD="http://localhost/cuahangcafe/getdsHoadon.php";
    public static String urlconnect="http://localhost/cuahangcafe/Connect.php";

    public static String geturl(String st){

        return st.replace("localhost", MainActivity.ip);
    }
   public static String Money(int i){
        DecimalFormat deci = new DecimalFormat("###,###,###");
        return "Giá: "+deci.format(i)+" Đ";

    }
    public static String catchuoi(String st){
        return st.substring(st.length()-10).trim();
    }

}
