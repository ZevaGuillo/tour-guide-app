package com.example.tour_guide_app.information;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.tour_guide_app.DataBase.PlaceDBHelper;
import com.example.tour_guide_app.MainActivity;
import com.example.tour_guide_app.R;
import com.example.tour_guide_app.comments.CommentsActivity;
import com.example.tour_guide_app.maps.MapsActivity;

import androidx.appcompat.widget.Toolbar;

import androidx.recyclerview.widget.GridLayoutManager;

import androidx.recyclerview.widget.RecyclerView;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;


public class InformationActivity extends AppCompatActivity {

    private PlaceDBHelper dbHelper;
    private SQLiteDatabase db;
    MyAdapter adapter;
    TextView textViewWelcome;
    // Lista de datos de tu base de datos
    private List<MyData> dataListOriginal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textViewWelcome = findViewById(R.id.textViewWelcome);

        // BD
        dbHelper = new PlaceDBHelper(this);
        db = dbHelper.getWritableDatabase();


        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        // Crea y asigna un GridLayoutManager con 2 columnas al RecyclerView
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));

        // Obtén los datos de la base de datos
        List<MyData> dataList = getDataFromDatabase();


        // Crea y asigna el adaptador al RecyclerView
        adapter = new MyAdapter(dataList);
        recyclerView.setAdapter(adapter);

    }

    private List<MyData> getDataFromDatabase() {
        List<MyData> dataList = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM lugares", null);
        if (cursor != null && cursor.moveToFirst()) {
            int nombreColumnIndex = cursor.getColumnIndex("nombre");
            int ubicacionColumnIndex = cursor.getColumnIndex("ubicacion");
            int categoriaColumnIndex = cursor.getColumnIndex("categoria");
            int descripcionColumnIndex = cursor.getColumnIndex("descripcion");
            int preciosColumnIndex = cursor.getColumnIndex("precios");
            int horariosColumnIndex = cursor.getColumnIndex("horarios");

            do {
                if (nombreColumnIndex >= 0) {
                    String nombre = cursor.getString(nombreColumnIndex);
                    String ubicacion = cursor.getString(ubicacionColumnIndex);
                    String categoria = cursor.getString(categoriaColumnIndex);
                    String descripcion = cursor.getString(descripcionColumnIndex);
                    String precios = cursor.getString(preciosColumnIndex);
                    String horarios = cursor.getString(horariosColumnIndex);

                    MyData data = new MyData(nombre, ubicacion, categoria, descripcion, precios, horarios);
                    dataList.add(data);
                }
            } while (cursor.moveToNext());

            cursor.close();
        }

        dataListOriginal = new ArrayList<>(dataList);

        return dataList;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbHelper.close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_bar, menu);


        MenuItem searchItem = menu.findItem(R.id.searc_viewcategoria);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setQueryHint("Busca por categoria.");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Lógica para manejar la búsqueda
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.searchQuery = newText;
                adapter.notifyDataSetChanged();

                if (TextUtils.isEmpty(newText)) {
                    textViewWelcome.setVisibility(View.VISIBLE);
                } else {
                    textViewWelcome.setVisibility(View.GONE);
                }
                return true;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.menu_opcion1) {
            Intent intent = new Intent(InformationActivity.this, InformationActivity.class);
            startActivity(intent);
            return true;
        } else if (itemId == R.id.menu_opcion2) {
            // Lógica para la opción 2
            Intent intent = new Intent(InformationActivity.this, CommentsActivity.class);
            startActivity(intent);
            return true;
        } else if (itemId == R.id.menu_opcion3) {
            // Lógica para la opción 3
            Intent intent = new Intent(InformationActivity.this, MapsActivity.class);
            startActivity(intent);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}