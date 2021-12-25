package com.example.kintaastarida;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.kintaastarida.model.DataWeb;

import java.util.ArrayList;
public class AdapterWeb extends ArrayAdapter {
    ArrayList<DataWeb> dataWebs;
    LayoutInflater layoutInflater;
    Context context;

    public AdapterWeb(Context context, ArrayList<DataWeb> dataweb) {
        super(context, R.layout.list_web, dataweb);
        this.dataWebs = dataweb;
        layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.list_web, parent, false);
        DataWeb dataWeb = this.dataWebs.get(position);

        TextView titleListview = convertView.findViewById(R.id.name_web);
        ImageView imageView = convertView.findViewById(R.id.logo_web);

        Glide
                .with(context)
                .load(dataWeb.getLogo())
                .placeholder(R.drawable.ic_refres_foreground)
                .into(imageView);

        titleListview.setText(dataWeb.getNameWeb());

        return convertView;
    }
}

