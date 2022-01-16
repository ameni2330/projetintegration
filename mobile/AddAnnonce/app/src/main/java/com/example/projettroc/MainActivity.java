package com.example.projettroc;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.projettroc.Database.Annonce;
import com.example.projettroc.Database.DatabaseHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private ListView listView;
private AnnonceAdapter adapter;
private DatabaseHelper db;
private ArrayList<Annonce> listAnnonce;
FloatingActionButton b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.list_view);
        db=new DatabaseHelper(this);
        int nb=db.getAnnonceCount();
        if (nb>0) {
            listAnnonce=db.getAllAnnonce();
            AnnonceAdapter adapter=new AnnonceAdapter(this,listAnnonce);
            adapter.notifyDataSetChanged();
            listView.setAdapter(adapter);
            db.close();

        }
        else {
            Toast.makeText(MainActivity.this,"there is no Annonce in this table",Toast.LENGTH_LONG).show();
        }


        b=findViewById(R.id.btn_add);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater inflater=LayoutInflater.from(MainActivity.this);
                View viewadd=inflater.inflate(R.layout.add_annonce,null);

                EditText n=viewadd.findViewById(R.id.edit_name);
                EditText des=viewadd.findViewById(R.id.edit_desc);
                AlertDialog.Builder a=new AlertDialog.Builder(MainActivity.this);
                a.setTitle("Add new Annonce");
                a.setView(viewadd);
                a.create();
                a.setPositiveButton("Add Annonce", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String name=n.getText().toString();
String description=des.getText().toString();
                        if ( TextUtils.isEmpty(name)){
                            Toast.makeText(MainActivity.this,"check input values",Toast.LENGTH_LONG).show();

                        }else{
                            Annonce aa=new Annonce(name,description);
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