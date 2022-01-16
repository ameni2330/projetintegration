package com.example.annonce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.SearchView;

import java.util.List;

public class MainActivity<lateinit> extends AppCompatActivity  {

    GridView gridView;
    SearchView searchView;
    ArrayAdapter<String> arrayAdapter;
    String[] name = {"Décapotable", "Proche", "RangeRover", "Maison", "Maison", "Maison", "Robe Enfant", "Robe enfant", "Robe Enfant", "Robe Femme", "Robe Soirée", "Robe Soirée", "Lunette", "Lunette", "Lunette"};
    Integer[] image = {R.drawable.decapotable, R.drawable.proche, R.drawable.rangerover, R.drawable.maison, R.drawable.maison1, R.drawable.maison3, R.drawable.enfant, R.drawable.robr, R.drawable.enfant2, R.drawable.robe1, R.drawable.robe2, R.drawable.robe, R.drawable.linette, R.drawable.linette1, R.drawable.linette2};
    String[] description = {"premiere main ", "tout options ", " importé ", " un batiment d'habitation", "a louer", "robe avec  plissees brodées avec des détail chic", "robe avec  plissees brodées avec des détail chic", "robe avec plissees brodées avec des détails chic", "Une bonne qualité de robe", "Une bonne qualité de robe", "Une bonne qualité de robe", "bonne état ", "etat presque neuf ", "neuf avec étiquette", "jamais porté "};


////////////////////////////////////////
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem menuItem = menu.findItem(R.id.search_view);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
//////////////////////////////////////

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.search_view) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
////////////////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchView = findViewById(R.id.search_view);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        Log.i("MainActivity", "onCreate: ");
        gridView = findViewById(R.id.gv_gridview);
        PlayerListAdpter adapter = new PlayerListAdpter(name, description, image, this);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                AlertDialog.Builder a = new AlertDialog.Builder(MainActivity.this);
                a.setTitle("votre choix ");
                a.setIcon(image[position]);
                a.setMessage(name[position] + " : " + "  " + description[position]);
                a.setPositiveButton("ok", null);
                a.show();


            }
        });
/////////////////////////////



    }
}
