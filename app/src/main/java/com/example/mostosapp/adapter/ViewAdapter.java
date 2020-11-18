package com.example.mostosapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mostosapp.R;
import com.example.mostosapp.models.MotoModel;

import java.util.List;

public class ViewAdapter extends BaseAdapter {
    Context context;
    List<MotoModel> datos;
    public ViewAdapter(Context context, List<MotoModel> datos) {
        this.context = context;
        this.datos = datos;
    }

    @Override
    public int getCount() {
        return datos.size();
    }

    @Override
    public Object getItem(int position) {
        return datos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vista = convertView;
        LayoutInflater inflate = LayoutInflater.from(context);
        vista = inflate.inflate(R.layout.view_list,null);
        ImageView img= (ImageView) vista.findViewById(R.id.img);
        TextView marca = (TextView) vista.findViewById(R.id.marca);
        TextView model = (TextView) vista.findViewById(R.id.model);
        TextView km = (TextView) vista.findViewById(R.id.km);
        TextView price = (TextView) vista.findViewById(R.id.price);
        ImageView imgV = (ImageView) vista.findViewById(R.id.imgView);
        int uno = R.drawable.ojo;
        imgV.setImageResource(uno);
        price.setText(datos.get(position).getPrecio());
        marca.setText(datos.get(position).getMarca());
        img.setImageResource(datos.get(position).getImage());
        return vista;
    }
}
