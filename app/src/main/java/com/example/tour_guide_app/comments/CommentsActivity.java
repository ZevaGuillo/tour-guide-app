package com.example.tour_guide_app.comments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.tour_guide_app.R;
import com.example.tour_guide_app.information.InformationActivity;
import com.example.tour_guide_app.maps.MapsActivity;

public class CommentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_comments);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Inflar el menú en el Toolbar
        getMenuInflater().inflate(R.menu.menu_bar, toolbar.getMenu());


        String nombre = getIntent().getStringExtra("nombre");
        TextView textView = findViewById(R.id.texto_lugarmostrar);
        textView.setText(nombre);

        String nombre1 = getIntent().getStringExtra("nombreu");
        TextView textViewnombre = findViewById(R.id.texto_usuariomostrar);
        textViewnombre.setText(nombre1 + " deja un comentario");

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.menu_opcion1) {
            Intent intent = new Intent(CommentsActivity.this, InformationActivity.class);
            startActivity(intent);
            return true;
        } else if (itemId == R.id.menu_opcion2) {
            // Lógica para la opción 2
            Intent intent = new Intent(CommentsActivity.this, CommentsActivity.class);
            startActivity(intent);
            return true;
        } else if (itemId == R.id.menu_opcion3) {
            // Lógica para la opción 3
            Intent intent = new Intent(CommentsActivity.this, MapsActivity.class);
            startActivity(intent);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}