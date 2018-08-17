package com.example.rockeypandit.pogo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ArrayAdapters extends ArrayAdapter<Cards> {

    Context context;
/*
    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
*/
    public ArrayAdapters(Context context, int resourceId , List<Cards> items){
        super(context,resourceId,items);



    }
    public View getView(int position, View convertView, ViewGroup parent){
        Cards cardItem = getItem(position);
        if(convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item,parent,false);

        TextView name = (TextView) convertView.findViewById(R.id.name);
        ImageView image = (ImageView) convertView.findViewById(R.id.image);

        name.setText(cardItem.getName());
        switch (cardItem.getProfileImageUrl()){
            case "defaultimage":
                Glide.with(convertView.getContext()).load(R.drawable.defaultimage).into(image);
                break;
            default:
                    Glide.clear(image);
                    Glide.with(convertView.getContext()).load(cardItem.getProfileImageUrl()).into(image);
                    break;

        }


        return convertView;



    }









}
