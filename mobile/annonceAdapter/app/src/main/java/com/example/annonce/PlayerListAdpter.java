package com.example.annonce;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class PlayerListAdpter extends ArrayAdapter implements Filterable {
    private String [] name ;
    private String [] Description ;
    private Integer [] image;
    private Activity context;

    public PlayerListAdpter( String[] name, String[] description, Integer[] image, Activity context) {

        super(context,R.layout.annonce_add,name);
        this.name = name;
        Description = description;
        this.image = image;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater LayoutInflater=context.getLayoutInflater();
        View view=LayoutInflater.inflate(R.layout.annonce_add, null, true);
        ImageView img=view.findViewById(R.id.image);
        TextView textViewNom=view.findViewById(R.id.nom);

        textViewNom.setText(name[position]);

        img.setImageResource(image[position]);
        return view;
    }
    }

