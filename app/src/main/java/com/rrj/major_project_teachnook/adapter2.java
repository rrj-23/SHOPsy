package com.rrj.major_project_teachnook;

import static com.google.android.material.internal.ContextUtils.getActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.rrj.major_project_teachnook.ui.gallery.GalleryFragment;
import com.rrj.major_project_teachnook.ui.home.HomeFragment;

import java.util.ArrayList;
import java.util.List;

public class adapter2 extends BaseAdapter {
    public ArrayList<pojo> al;
    private List<pojo> l;
    Context ct;

    public adapter2(List<pojo> l, Context c) {
        ct = c;
        this.l = l;
        this.al = new ArrayList<pojo>();
        this.al.addAll(l);
    }

    public class ViewHolder{
        ImageView pic;
        TextView brand,name,price;
        ImageView b;

    }

    @Override
    public int getCount() {
        return l.size();
    }

    @Override
    public Object getItem(int i) {
        return l.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolder h;
        final DBHelper2[] db = new DBHelper2[1];
        if(view == null){
            view = LayoutInflater.from(ct).inflate(R.layout.custom_listview,null);
            h = new ViewHolder();
            h.pic = view.findViewById(R.id.imageView);
            h.brand = view.findViewById(R.id.textView);
            h.name = view.findViewById(R.id.textView2);
            h.price = view.findViewById(R.id.textView3);
            h.b = view.findViewById(R.id.imageView3);

            h.b.setVisibility(View.GONE);

            view.setTag(h);
        }
        else{
            h = (ViewHolder) view.getTag();
        }

        try{
            int image = l.get(i).getImage();
            h.pic.setImageResource(image);
            h.name.setText(l.get(i).getName());
            h.brand.setText(l.get(i).getBrand());
            h.price.setText(l.get(i).getPrice());

        }
        catch (Exception e){

        }

        return view;
    }
}
