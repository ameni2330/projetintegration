package com.example.evenement;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
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

import com.example.evenement.Database.Databasehelper;
import com.example.evenement.Database.Evenement;

import java.util.ArrayList;

public class EvenementAdpter extends ArrayAdapter<Evenement> {
    Activity context;
    ArrayList<Evenement> liste;
    Databasehelper db;


    public EvenementAdpter( Activity context, ArrayList<Evenement> liste) {
        super(context, R.layout.evenement_item,liste);
        this.context = context;
        this.liste = liste;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View v = inflater.inflate(R.layout.evenement_item, null, true);
        TextView id = v.findViewById(R.id.txtid);
        TextView name = v.findViewById(R.id.txtn);
        TextView dat = v.findViewById(R.id.txtim);
        TextView temp = v.findViewById(R.id.txtdesH);
        ImageView edit = v.findViewById(R.id.img1);
        ImageView delete = v.findViewById(R.id.img2);
        id.setText(String.valueOf(liste.get(position).getId()));
        name.setText(liste.get(position).getName());
        dat.setText(liste.get(position).getDate());
        temp.setText(liste.get(position).getTemps());
        Evenement s=liste.get(position);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LayoutInflater inflater1=LayoutInflater.from(context);
                View subview=inflater1.inflate(R.layout.add_evenement,null);
                EditText n=subview.findViewById(R.id.edit_name);
                EditText d=subview.findViewById(R.id.edit_date);
                EditText t=subview.findViewById(R.id.edit_temps);
                n.setText(s.getName());
                d.setText(s.getDate());
                t.setText(s.getTemps());
                AlertDialog.Builder a=new AlertDialog.Builder(context);
                a.setView(subview);
                a.create();
                a.setTitle("Edite Evenement");
                a.setPositiveButton("update",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                db=new Databasehelper(context);
                                String des=d.getText().toString();
                                String name=n.getText().toString();
                                String imga=t.getText().toString();
                                Evenement evenement=new Evenement(s.getId(),name,des,imga);
                                db.updateAnnonce(evenement);
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
                db=new Databasehelper(context);
                db.removeAnnonce(s.getId());
                context.finish();
                context.startActivity(context.getIntent());
                Toast.makeText(context,"Evenement Delete",Toast.LENGTH_LONG).show();
            }
        });
        return v; }
    private  void DeletAnnonce(Evenement s){
        db.removeAnnonce(s.getId());context.finish();
        context.startActivity(context.getIntent());
        Toast.makeText(context,"Evenement delete",Toast.LENGTH_LONG).show();

    }
}
