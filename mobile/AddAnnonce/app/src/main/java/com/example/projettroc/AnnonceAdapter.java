package com.example.projettroc;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.projettroc.Database.Annonce;
import com.example.projettroc.Database.DatabaseHelper;

import java.util.ArrayList;

public class AnnonceAdapter extends ArrayAdapter<Annonce> {
    Activity context;
    ArrayList<Annonce> liste;
    DatabaseHelper db;


    public AnnonceAdapter( Activity context, ArrayList<Annonce> liste) {
        super(context, R.layout.annonce_item,liste);
        this.context = context;
        this.liste = liste;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View v = inflater.inflate(R.layout.annonce_item, null, true);
        TextView id = v.findViewById(R.id.txtid);
        TextView name = v.findViewById(R.id.txtn);
        TextView img = v.findViewById(R.id.txtim);
        TextView desHH = v.findViewById(R.id.txtdesH);
        ImageView edit = v.findViewById(R.id.img1);
        ImageView delete = v.findViewById(R.id.img2);
        id.setText(String.valueOf(liste.get(position).getId()));
        name.setText(liste.get(position).getName());
       desHH.setText(liste.get(position).getImage());
        Annonce s=liste.get(position);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LayoutInflater inflater1=LayoutInflater.from(context);
                View subview=inflater1.inflate(R.layout.add_annonce,null);
                EditText n=subview.findViewById(R.id.edit_name);
                EditText d=subview.findViewById(R.id.edit_desc);

                n.setText(s.getName());
                d.setText(s.getDescription());
                img.setText(s.getImage());
                AlertDialog.Builder a=new AlertDialog.Builder(context);
                a.setView(subview);
                a.create();
                a.setTitle("Edite Annonce");
                a.setPositiveButton("update",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                db=new DatabaseHelper(context);
                                String des=d.getText().toString();
                                String name=n.getText().toString();
                                String imga=img.getText().toString();
                                Annonce annonce=new Annonce(s.getId(),name,des,imga);
                                db.updateAnnonce(annonce);
                                context.finish();
                                context.startActivity(context.getIntent());
                            }
                        });
                a.show();

            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db=new DatabaseHelper(context);
                db.removeAnnonce(s.getId());
                context.finish();
                context.startActivity(context.getIntent());
                Toast.makeText(context,"Annonce Delete",Toast.LENGTH_LONG).show();
            }
        });
        return v; }
    private  void DeletAnnonce(Annonce s){
        db.removeAnnonce(s.getId());context.finish();
        context.startActivity(context.getIntent());
        Toast.makeText(context,"Annonce delete",Toast.LENGTH_LONG).show();

    }


    }
