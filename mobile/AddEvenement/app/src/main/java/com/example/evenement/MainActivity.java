package com.example.evenement;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.DashPathEffect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.evenement.Database.Databasehelper;
import com.example.evenement.Database.Evenement;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private EvenementAdpter adapter;
    private Databasehelper db;
    private ArrayList<Evenement> listEvenement;
    FloatingActionButton b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.list_view);
        db=new Databasehelper(this);
        int nb=db.getAnnonceCount();
        if (nb>0) {
            listEvenement=db.getAllAnnonce();
            EvenementAdpter adapter=new EvenementAdpter(this,listEvenement);
            adapter.notifyDataSetChanged();
            listView.setAdapter(adapter);
            db.close();

        }
        else {
            Toast.makeText(MainActivity.this,"there is no Evenement in this table",Toast.LENGTH_LONG).show();
        }


        b=findViewById(R.id.btn_add);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater inflater=LayoutInflater.from(MainActivity.this);
                View viewadd=inflater.inflate(R.layout.add_evenement,null);

                EditText n=viewadd.findViewById(R.id.edit_name);
                EditText im=viewadd.findViewById(R.id.edit_date);
                EditText des=viewadd.findViewById(R.id.edit_temps);
                AlertDialog.Builder a=new AlertDialog.Builder(MainActivity.this);
                a.setTitle("Add new Evenement");
                a.setView(viewadd);
                a.create();
                a.setPositiveButton("Add Evenement", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String name=n.getText().toString();
                        String image=im.getText().toString();
                        String description=des.getText().toString();
                        if ( TextUtils.isEmpty(name)){
                            Toast.makeText(MainActivity.this,"check input values",Toast.LENGTH_LONG).show();

                        }else{
                            Evenement aa=new Evenement(name,image,description);
                            db.addAnnonce(aa);
                            finish();
                            startActivity(getIntent());
                        }
                    }
                });

                a.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"Task cancelled",Toast.LENGTH_LONG).show();
                    }
                });
                a.show();
            }
        });




    }
}